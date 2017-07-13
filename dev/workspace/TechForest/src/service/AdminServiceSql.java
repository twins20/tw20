package service;

public class AdminServiceSql {

	private String adminIndexPMoneyChkList =
					"SELECT A.IDX, A.NAME, A.NICK, B.MIDX, B.CHGMONEY, B.INSDATE, B.STATUS "
			+		"FROM TF_MEMBER A, TF_MONEY_HIS B "
			+		"WHERE A.IDX = B.IDX " 
			+			"AND B.STATUS = 0 "
			+		"ORDER BY B.MIDX DESC";
	
	private String adminIndexPProjectChkList =
					"SELECT PIDX, PNAME, INSDATE, STATUS "
			+		"FROM TF_PROJECT_LIST "
			+		"WHERE STATUS = 0 "
			+		"ORDER BY PIDX DESC";	
	
	private String adminIndexPCmemChkList = 
					"SELECT A.IDX, A.NAME, B.COMPANY, A.MODDATE "
			+		"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
			+		"WHERE A.IDX = B.IDX "
			+			"AND A.STATUS = 0 "
			+			"AND A.TYPE = 'C' "
			+		"ORDER BY B.CIDX DESC";
	
	private String adminlmemInfoList =
					"SELECT A.IDX, A.ID, A.NAME, A.STATUS, B.MONEY "
			+		"FROM TF_MEMBER A, TF_IMEMBER_EXT B "
			+		"WHERE A.IDX = B.IDX "
			+			"AND A.TYPE = 'I' "
			+		"ORDER BY IIDX DESC";
	
	private String adminlmemInfoCon = 
					"SELECT * "
			+		"FROM TF_MEMBER "
			+		"WHERE IDX = ?";
	
	private String adminImemInfoMoneyHis = 
					"SELECT * "
			+		"FROM TF_MONEY_HIS " 
			+		"WHERE IDX = ? " 	
			+		"ORDER BY MIDX DESC";
	
	private String adminImemInfoProjHis =  
					"SELECT A.PIDX, A.PNAME, B.INFUNDS, B.INSDATE, A.PNFUNDS, A.PTFUNDS "
			+		"FROM TF_PROJECT_LIST A, TF_FUND_HIS B "
			+		"WHERE A.PIDX = B.PIDX " 
			+			"AND B.IDX = ? "
			+		"ORDER BY B.FIDX DESC";
			
	private String adminImemInfoQnaHis = 
					"SELECT B.BIDX, A.IDX, B.TITLE, B.INSDATE, (SELECT MAX(BDEPTH) FROM TF_BOARD_QNA WHERE OBIDX = B.OBIDX) AS MAXDEPTH, B.BDEPTH "
			+		"FROM TF_MEMBER A, TF_BOARD_QNA B "
			+		"WHERE A.IDX = B.IDX " 
			+			"AND A.IDX = ? "
			+		"ORDER BY B.BIDX DESC";
	
	private String adminMoneyList = 
					"A.IDX, B.MIDX, A.NAME, A.NICK, B.CHGMONEY, B.INSDATE, B.STATUS "
			+		"FROM TF_MEMBER A, TF_MONEY_HIS B "
			+		"WHERE A.IDX = B.IDX "
			+		"ORDER BY B.MIDX DESC";
	
	private String adminMoneyModOkTransaction_1 = 
					"UPDATE TF_MONEY_HIS " 
			+		"SET STATUS = 1, "
			+		"AMONEY = CHGMONEY + BMONEY, "
			+		"CHKADMIN = (SELECT NICK FROM TF_MEMBER WHERE IDX = ?), " 
			+		"MODDATE = SYSDATE "
			+		"WHERE MIDX = ?";
			
	private String adminMoneyModOkTransaction_2 =
					"UPDATE TF_IMEMBER_EXT "
			+		"SET MONEY = (SELECT AMONEY FROM TF_MONEY_HIS WHERE MIDX = ?) "		
			+		"WHERE IDX = (SELECT IDX FROM TF_MONEY_HIS WHERE MIDX = ?)";
			
	private String adminMoneyModNOk = 
					"UPDATE TF_MONEY_HIS " 
			+		"SET STATUS = 3, "
			+		"CHKADMIN = (SELECT NICK FROM TF_MEMBER WHERE IDX=?), " 
			+		"MODDATE = SYSDATE "
			+		"WHERE MIDX = ?";
	
	private String adminCmemInfoList = 
					"SELECT A.IDX, A.ID, A.NAME, A.STATUS, B.PNFUNDS "
			+		"FROM TF_MEMBER A, TF_PROJECT_LIST B "
			+		"WHERE A.IDX = B.IDX "						
			+			"AND A.TYPE = 'C' "
			+		"ORDER BY A.IDX DESC";
			
	private String adminCmemInfoCon = 
					"SELECT A.IDX, A.ID, A.NICK, A.NAME, A.PHONE, A.ADDR, B.CNUMBER, B.CADDR " 
			+		"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
			+		"WHERE A.IDX = B.IDX "
			+			"AND A.TYPE ='C' "
			+			"AND A.IDX = ?";
	
	private String adminCmemInfoProj =
					"SELECT PIDX, PNFUNDS, PTFUNDS, PNAME "
			+		"FROM TF_PROJECT_LIST "
			+		"WHERE STATUS = 1 "		
			+			"AND IDX = ?";
	
	private String adminCmemInfoProj1 = 
					"SELECT * "
			+		"FROM TF_FUND_HIS "
			+		"WHERE STATUS = 1 "
			+			"AND IDX = ?";
	
	private String adminCmemInfoProjHis = 
					"SELECT PIDX, PNAME, PNFUNDS, PTFUNDS, INSDATE " 
			+		"FROM TF_PROJECT_LIST "
			+		"WHERE STATUS > 3 "
			+			"AND IDX = ? "
			+		"ORDER BY PIDX DESC";
			
	private String adminCmemInfoProjFundHis = 
					"SELECT A.NICK, B.AFUNDS, B.INSDATE, B.STATUS "
			+	    "FROM TF_MEMBER A, TF_FUND_HIS B "
			+		"WHERE A.IDX = B.IDX "
			+			"AND B.PIDX = (SELECT PIDX FROM TF_PROJECT_LIST WHERE IDX = ? AND STATUS = 1) "
			+		"ORDER BY B.FIDX DESC";
	
	private String adminCmemInfoProjNewsHis = 
					"SELECT A.BIDX, A.TITLE, B.PNAME, A.INSDATE "
			+		"FROM TF_BOARD_NEWS A, TF_PROJECT_LIST B "
			+		"WHERE A.PIDX = B.PIDX "
			+			"AND A.VIEWSTAT = 1 "
			+			"AND B.IDX = ? "
			+		"ORDER BY OBIDX DESC, RBIDX ASC";
	
	private String adminCmemInfoProjQna = 
					"SELECT A.* "
			+		"FROM TF_BOARD_QNA A, TF_PROJECT_LIST B "
			+		"WHERE A.PIDX = B.PIDX "
			+			"AND A.VIEWSTAT = 1 "
			+			"AND B.IDX = ? "
			+		"ORDER BY A.OBIDX DESC, A.RBIDX ASC";
	
	private String adminCmemChkList = 
					"SELECT A.IDX, A.NAME, A.MODDATE, A.STATUS "
			+		"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
			+		"WHERE A.IDX = B.IDX "
			+			"AND TYPE = 'C' "
			+			"AND STATUS = 0 "
			+		"ORDER BY B.CIDX DESC";
	
	private String adminCmemChkOkMem = 
					"UPDATE TF_MEMBER "
			+		"SET STATUS = 3 "
			+		"WHERE IDX = ?";
	
	private String adminCmemChkOkCmem = 
					"UPDATE TF_CMEMBER_EXT "
			+		"SET CHKADMIN = (SELECT NICK FROM TF_MEMBER WHERE IDX = ?) "
			+		"WHERE IDX = ?";
	
	private String adminProjChkList = 
					"SELECT PIDX, PNAME, INSDATE, STATUS " 
			+		"FROM TF_PROJECT_LIST "
			+		"ORDER BY PIDX DESC";
	
	private String adminProJChkCon = 
					"SELECT * "
			+		"FROM TF_PROJECT_LIST A, TF_ITEM_LIST B "
			+		"WHERE A.PIDX = B.PIDX "
			+			"AND A.PIDX = ?";
	
	private String adminProJChkOk = 
					"UPDATE TF_PROJECT_LIST " 
			+		"SET STATUS = 1, "
			+		"CHKADMIN = (SELECT NICK FROM TF_MEMBER WHERE IDX = ?) "	
			+		"WHERE PIDX = ?";
	
	private String adminProJChkNOk = 
					"UPDATE TF_PROJECT_LIST " 
			+		"SET STATUS = 2, " 
			+		"CHKADMIN = (SELECT NICK FROM TF_MEMBER WHERE IDX = ?) "
			+		"WHERE PIDX = ?";
	
	private String adminBoardQnaList = 
					"SELECT * "
			+		"FROM TF_BOARD_QNA "
			+		"WHERE VIEWSTAT = 1 "
			+		"ORDER BY OBIDX DESC, RBIDX ASC";
	
	private String adminBoardQnaCon =
					"SELECT A.*, B.* "
			+		"FROM TF_BOARD_QNA A, TF_MEMBER B "
			+		"WHERE A.IDX = B.IDX "
			+ 			"AND A.BIDX = ?";
	
	private String adminBoardQnaWrite_1 = 
					"UPDATE TF_BOARD_QNA " 
			+		"SET RBIDX = RBIDX + 1 "
			+		"WHERE OBIDX = (SELECT OBIDX FROM TF_BOARD_QNA WHERE BIDX = ?) " 
			+			"AND RBIDX > (SELECT RBIDX FROM TF_BOARD_QNA WHERE BIDX = ?)";
	
	private String adminBoardQnaWrite_2 =
					"INSERT INTO TF_BOARD_QNA (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, PIDX) "
			+		"VALUES ("
			+ 				"SEQ_TF_BIDX_QNA.NEXTVAL, "
			+ 				"?, " // IDX
			+ 				"?, " // CATE
			+ 				"?, " // TITLE
			+ 				"?, " // CONTENTS
			+ 				"0, " // HIT
			+ 				"0, " // GOOD
			+ 				"0, " // BAD
			+ 				"(SELECT OBIDX FROM TF_BOARD_QNA WHERE BIDX = ?), " //OBIDX
			+ 				"(SELECT RBIDX FROM TF_BOARD_QNA WHERE BIDX = ?) + 1, " //RBIDX
			+ 				"(SELECT BDEPTH FROM TF_BOARD_QNA WHERE BIDX = ?) + 1, " //BDEPTH
			+ 				"0, " //COMMCNT
			+ 				"1, " //VIEWSTAT
			+ 				"SYSDATE, " //INSDATE
			+ 				"SYSDATE, " //MODDATE
			+ 				"(SELECT PIDX FROM TF_BOARD_QNA WHERE BIDX = ?) " //PIDX
			+ 				")";
	
	private String adminBoardQnaMod = 
					"UPDATE TF_BOARD_QNA "
			+		"SET CATE = ?, TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "	
			+		"WHERE BIDX = ?";
	
	private String adminBoardQnaDel =
					"UPDATE TF_BOARD_QNA "
			+		"SET VIEWSTAT = 0 "	
			+		"WHERE BIDX = ?";
	
	private String adminBoardFaqList = 
					"SELECT * "
			+		"FROM TF_BOARD_FAQ "
			+		"WHERE VIEWSTAT = 1 "
			+		"ORDER BY OBIDX DESC, RBIDX ASC";
	
	private String adminBoardFaqCon =
					"SELECT A.*, B.* "
			+		"FROM TF_BOARD_FAQ A, TF_MEMBER B "
			+		"WHERE A.IDX = B.IDX "
			+ 			"AND A.BIDX = ?";
	
	private String adminBoardFaqWrite =
					"INSERT INTO TF_BOARD_FAQ (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE) "
			 +		"VALUES ("
			 +			"SEQ_TF_BIDX_FAQ.NEXTVAL, "
			 + 			"?, " //IDX
			 + 			"?, " //CATE
			 + 			"?, " //TITLE
			 + 			"?, " //CONTENTS
			 + 			"0, " //HIT
			 + 			"0, " //GOOD
			 + 			"0, " //BAD
			 + 			"SEQ_TF_BIDX_FAQ.CURRVAL, " //OBIDX
			 + 			"1, " //RBIDX
			 + 			"1, " //BDEPTH
			 + 			"0, " //COMMCNT
			 + 			"1, " //VIEWSTAT
			 + 			"SYSDATE, " //INSDATE
			 + 			"SYSDATE" //MODDATE
			 + 		")";
	
	private String adminBoardFaqMod =
					"UPDATE TF_BOARD_FAQ "
			+		"SET CATE = ?, TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "	
			+		"WHERE BIDX = ?";
	
	private String adminBoardFaqDel =
					"UPDATE TF_BOARD_FAQ "
			+		"SET VIEWSTAT = 0 "	
			+		"WHERE BIDX = ?";
	
	private String adminBoardNoticeList =
					"SELECT * "
			+		"FROM TF_BOARD_NOTICE "
			+		"WHERE VIEWSTAT = 1 "
			+		"ORDER BY OBIDX DESC, RBIDX ASC";
	
	private String adminBoardNoticeCon =
					"SELECT A.*, B.* "
			+		"FROM TF_BOARD_NOTICE A, TF_MEMBER B "
			+		"WHERE A.IDX = B.IDX "
			+ 			"AND A.BIDX = ?";
	
	private String adminBoardNoticeWrite = 
					"INSERT INTO TF_BOARD_NOTICE (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE) "
			+		"VALUES ("
			+ 			"SEQ_TF_BIDX_NOTICE.NEXTVAL, "
			+ 			"?, "
			+			"?, "
			+ 			"?, "
			+ 			"?, "
			+ 			"0, "
			+ 			"0, "
			+ 			"0, "
			+ 			"SEQ_TF_BIDX_NOTICE.CURRVAL, "
			+ 			"1, "
			+ 			"1, "
			+ 			"0, "
			+ 			"1, "
			+ 			"SYSDATE, "
			+ 			"SYSDATE"
			+ 		")";
	
	private String adminBoardNoticeMod = 
					"UPDATE TF_BOARD_NOTICE "
			+		"SET CATE = ?, TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "	
			+		"WHERE BIDX = ?";
	
	private String adminBoardNoticeQnaDel = 
					"UPDATE TF_BOARD_NOTICE "
			+		"SET VIEWSTAT = 0 "	
			+		"WHERE BIDX = ?";
	
	private String adminBoardNewsList = 
					"SELECT * "
			+		"FROM TF_BOARD_NEWS "
			+		"WHERE VIEWSTAT = 1 "
			+		"ORDER BY OBIDX DESC, RBIDX ASC";
	
	private String adminBoardNewsCon =
					"SELECT A.*, B.PNAME, B.PNFUNDS, B.PGRADE, B.STATUS "
			 +		"FROM TF_BOARD_NEWS A, TF_PROJECT_LIST B " 
			 +		"WHERE A.PIDX = B.PIDX "
			 +			"AND A.BIDX = ?";
	
	private String adminBoardNewsWrite =
					"INSERT INTO TF_BOARD_NEWS (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE) "
			+		"VALUES ("
			+ 			"SEQ_TF_BIDX_NEWS.NEXTVAL, "
			+ 			"?, " // IDX
			+ 			"?, " // CATE
			+ 			"?, " // TITLE
			+ 			"?, " // CONTENTS
			+ 			"0, " // HIT
			+ 			"0, " // GOOD
			+ 			"0, " // BAD
			+ 			"SEQ_TF_BIDX_NEWS.CURRVAL, " // OBIDX
			+ 			"1, " // RBIDX
			+ 			"1, " // BDEPTH
			+ 			"0, " // COMMCNT
			+ 			"1, " // VIEWSTAT
			+ 			"SYSDATE, " // INSDATE
			+ 			"SYSDATE" // MODDATE
			+ 		")";
	
	private String adminBoardNewsMod = 
					"UPDATE TF_BOARD_NEWS "
			+		"SET CATE = ?, TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "	
			+		"WHERE BIDX = ?";
	
	private String adminBoardNewsDel = 
					"UPDATE TF_BOARD_NEWS "
			+		"SET VIEWSTAT = 0 "	
			+		"WHERE BIDX = ?";
	
	private String adminBoardMemoList = 
					"SELECT * "
			+		"FROM TF_MEMO_LIST "
			+		"WHERE RECVIDX = ? "
			+		"ORDER BY MEMOIDX DESC";
	
	private String adminBoardMemoSend = 
					"INSERT INTO TF_MEMO_LIST (MEMOIDX,SENDIDX,RECVIDX,CONTENTS,STATUS,INSDATE) "
			+		"VALUES ("
			+ 			"SEQ_TF_MEMOIDX.NEXTVAL, "
			+ 			"?, "
			+ 			"(SELECT IDX FROM TF_MEMBER WHERE ID = ?), "
			+ 			"?, "
			+ 			"0, "
			+ 			"SYSDATE"
			+ 		")";

	
	public String getAdminIndexPMoneyChkList() {
		return adminIndexPMoneyChkList;
	}

	public String getAdminIndexPProjectChkList() {
		return adminIndexPProjectChkList;
	}

	public String getAdminIndexPCmemChkList() {
		return adminIndexPCmemChkList;
	}

	public String getAdminlmemInfoList() {
		return adminlmemInfoList;
	}

	public String getAdminlmemInfoCon() {
		return adminlmemInfoCon;
	}

	public String getAdminImemInfoMoneyHis() {
		return adminImemInfoMoneyHis;
	}

	public String getAdminImemInfoProjHis() {
		return adminImemInfoProjHis;
	}

	public String getAdminImemInfoQnaHis() {
		return adminImemInfoQnaHis;
	}

	public String getAdminMoneyList() {
		return adminMoneyList;
	}

	public String getAdminMoneyModOkTransaction_1() {
		return adminMoneyModOkTransaction_1;
	}

	public String getAdminMoneyModOkTransaction_2() {
		return adminMoneyModOkTransaction_2;
	}

	public String getAdminMoneyModNOk() {
		return adminMoneyModNOk;
	}

	public String getAdminCmemInfoList() {
		return adminCmemInfoList;
	}

	public String getAdminCmemInfoCon() {
		return adminCmemInfoCon;
	}

	public String getAdminCmemInfoProj() {
		return adminCmemInfoProj;
	}

	public String getAdminCmemInfoProj1() {
		return adminCmemInfoProj1;
	}

	public String getAdminCmemInfoProjHis() {
		return adminCmemInfoProjHis;
	}

	public String getAdminCmemInfoProjFundHis() {
		return adminCmemInfoProjFundHis;
	}

	public String getAdminCmemInfoProjNewsHis() {
		return adminCmemInfoProjNewsHis;
	}

	public String getAdminCmemInfoProjQna() {
		return adminCmemInfoProjQna;
	}

	public String getAdminCmemChkList() {
		return adminCmemChkList;
	}

	public String getAdminCmemChkOkMem() {
		return adminCmemChkOkMem;
	}

	public String getAdminCmemChkOkCmem() {
		return adminCmemChkOkCmem;
	}

	public String getAdminProjChkList() {
		return adminProjChkList;
	}

	public String getAdminProJChkCon() {
		return adminProJChkCon;
	}

	public String getAdminProJChkOk() {
		return adminProJChkOk;
	}

	public String getAdminProJChkNOk() {
		return adminProJChkNOk;
	}

	public String getAdminBoardQnaList() {
		return adminBoardQnaList;
	}

	public String getAdminBoardQnaCon() {
		return adminBoardQnaCon;
	}

	public String getAdminBoardQnaWrite_1() {
		return adminBoardQnaWrite_1;
	}

	public String getAdminBoardQnaWrite_2() {
		return adminBoardQnaWrite_2;
	}

	public String getAdminBoardQnaMod() {
		return adminBoardQnaMod;
	}

	public String getAdminBoardQnaDel() {
		return adminBoardQnaDel;
	}

	public String getAdminBoardFaqList() {
		return adminBoardFaqList;
	}

	public String getAdminBoardFaqCon() {
		return adminBoardFaqCon;
	}

	public String getAdminBoardFaqWrite() {
		return adminBoardFaqWrite;
	}

	public String getAdminBoardFaqMod() {
		return adminBoardFaqMod;
	}

	public String getAdminBoardFaqDel() {
		return adminBoardFaqDel;
	}

	public String getAdminBoardNoticeList() {
		return adminBoardNoticeList;
	}

	public String getAdminBoardNoticeCon() {
		return adminBoardNoticeCon;
	}

	public String getAdminBoardNoticeWrite() {
		return adminBoardNoticeWrite;
	}

	public String getAdminBoardNoticeMod() {
		return adminBoardNoticeMod;
	}

	public String getAdminBoardNoticeQnaDel() {
		return adminBoardNoticeQnaDel;
	}

	public String getAdminBoardNewsList() {
		return adminBoardNewsList;
	}

	public String getAdminBoardNewsCon() {
		return adminBoardNewsCon;
	}

	public String getAdminBoardNewsWrite() {
		return adminBoardNewsWrite;
	}

	public String getAdminBoardNewsMod() {
		return adminBoardNewsMod;
	}

	public String getAdminBoardNewsDel() {
		return adminBoardNewsDel;
	}

	public String getAdminBoardMemoList() {
		return adminBoardMemoList;
	}

	public String getAdminBoardMemoSend() {
		return adminBoardMemoSend;
	}
	
	
}
