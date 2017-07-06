package service;

public class CMemberServiceSql {
	
	private String cMemIndexProjNowList =
			"SELECT PIDX, IDX, PNAME, PCATE, PTFUNDS, PNFUNDS, PGRADE, STATUS "
					+	"FROM TF_PROJECT_LIST "
					+	"WHERE STATUS = 1 "
					+		"AND IDX = ?";
		
	private String cMemIndexCommList = 
			"SELECT * "
					+	"FROM TF_PROJECT_COMM "
					+	"WHERE VIEWSTAT = 1 "
					+		"AND PIDX = (SELECT PIDX FROM TF_PROJECT_LIST WHERE STATUS = 1 AND IDX = ?) "
					+	"ORDER BY OPCOMMIDX DESC, RPCOMMIDX ASC";
	
	private String cMemIndexNewsList = 
			"SELECT B.* "
					+	"FROM TF_PROJECT_LIST A, TF_BOARD_NEWS B "
					+	"WHERE B.VIEWSTAT = 1 "
					+		"AND A.PIDX = B.PIDX "
					+		"AND A.IDX = ? "
					+	"ORDER BY B.OBIDX DESC, B.RBIDX ASC";
	
	private String cMemInfoCon =
			"SELECT A.*, B.* "
					+	"FROM TF_MEMBER A, TF_CMEMBER_EXT B "
					+	"WHERE A.IDX = B.IDX "
					+	"AND A.IDX = ?";
	
	private String cMemInfoModChk =
			"SELECT COUNT(*) "
					+	"FROM TF_MEMBER "
					+	"WHERE IDX = ? "
					+		"AND PW = ?";
	
	private String cMemInfoMod =
			"UPDATE TF_MEMBER "
					+	"SET PW = ?, NICK = ?, PHONE = ?, ADDR = ?, MODDATE = SYSDATE "
					+	"WHERE IDX = ?";
	
	private String cMemInfoExtWriteChk = 
			"SELECT COUNT(*) "
					+	"FROM TF_CMEMBER_EXT "
					+	"WHERE IDX = ?";
	
	private String cMemInfoExtWrite = 
			"INSERT INTO TF_CMEMBER_EXT (CIDX, IDX, COMPANY, CNUMBER, CADDR) "
					+	"VALUES (SEQ_TF_CIDX.NEXTVAL, ?, ?, ?, ?)";
	
	private String cMemMemoWriteIMemList =
			"SELECT DISTINCT(A.NICK), A.IDX "
					+	"FROM TF_MEMBER A, TF_PROJECT_LIST B, TF_FUND_HIS C "
					+	"WHERE B.PIDX = C.PIDX "
					+		"AND A.IDX = C.IDX "
					+		"AND B.PIDX = ? "
					+	"ORDER BY A.IDX ASC";
	
	private String cMemMemoWrite =
			"INSERT INTO TF_MEMO_LIST(MEMOIDX, SENDIDX, RECVIDX, CONTENTS, STATUS, INSDATE) "
					+	"VALUES(SEQ_TF_MEMOIDX.NEXTVAL, ?, ?, ?, 0, SYSDATE)";
	
	private String cMemMemoSendList =
			"SELECT * "
					+	"FROM TF_MEMO_LIST "
					+	"WHERE SENDIDX = ? "
					+		"AND (STATUS = 0 OR STATUS = 2) "
					+	"ORDER BY MEMOIDX DESC";
	
	private String cMemMemoDel =
			"UPDATE TF_MEMO_LIST "
					+	"SET STATUS = STATUS + 1 "
					+	"WHERE (STATUS = 0 OR STATUS = 2) "
					+		"AND MEMOIDX = ?";
		
	private String cMemNewsList = 
			"SELECT B.* "
					+	"FROM TF_PROJECT_LIST A, TF_BOARD_NEWS B "
					+	"WHERE B.VIEWSTAT = 1 "
					+		"AND A.PIDX = B.PIDX "
					+		"AND A.IDX = ? "
					+	"ORDER BY B.OBIDX DESC, B.RBIDX ASC";

	private String cMemNewsCon = 
			"SELECT A.*, B.PIDX, B.PNAME, B.PNFUNDS, B.PGRADE, B.STATUS "
					+	"FROM TF_BOARD_NEWS A, TF_PROJECT_LIST B "
					+	"WHERE A.PIDX = B.PIDX "
					+		"AND A.BIDX = ?";
	
	private String cMemNewsMod =
			"UPDATE TF_BOARD_NEWS "
					+	"SET CATE = (SELECT PCATE FROM TF_PROJECT_LIST WHERE PIDX = ?), TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE, PIDX = ? "
					+	"WHERE BIDX = ?";
	
	private String cMemNewsWriteProjNow = 
			"SELECT PIDX, IDX, PNAME, PCATE, PTFUNDS, PNFUNDS, PGRADE, STATUS "
					+	"FROM TF_PROJECT_LIST "
					+	"WHERE STATUS = 1 "
					+		"AND IDX = ?";
	
	private String cMemNewsWrite =
			"INSERT INTO TF_BOARD_NEWS (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, PIDX) "
					+	"VALUES (SEQ_TF_BIDX_NEWS.NEXTVAL, ?, (SELECT PCATE FROM TF_PROJECT_LIST WHERE PIDX = ?), ?, ?, 0, 0, 0, SEQ_TF_BIDX_NEWS.CURRVAL, 1, 1, 0, 1, SYSDATE, SYSDATE, ?)";
	
	private String cMemNewsDel =
			"UPDATE TF_BOARD_NEWS "
					+	"SET VIEWSTAT = 0, MODDATE = SYSDATE "
					+ 	"WHERE BIDX = ?";
	
	private String cMemProjNowList =
			"SELECT PIDX, IDX, PNAME, PCATE, PTFUNDS, PNFUNDS, PGRADE, STATUS "
					+	"FROM TF_PROJECT_LIST "
					+	"WHERE STATUS = 1 "
					+		"AND IDX = ?";
	
	private String cMemProjHisList = 
			"SELECT PIDX, IDX, PNAME, PCATE, PTFUNDS, PNFUNDS, PGRADE, STATUS "
					+	"FROM TF_PROJECT_LIST "
					+	"WHERE STATUS > 3 "
					+		"AND IDX = ?";
	
	private String cMemProjApplyConProj =
			"SELECT PIDX, IDX, PNAME, PCATE, CONTENTS, ITLIST, ITLISTCNT, PTFUNDS, PEDATE, PCDATE "
					+	"FROM TF_PROJECT_LIST "
					+	"WHERE IDX = ? "
					+		"AND STATUS = 0 ";
	
	private String cMemProjApplyConItem =
			"SELECT ITIDX, ITNAME, ITPRICE, CONTENTS, ITTCNT "
					+	"FROM TF_ITEM_LIST "
					+	"WHERE PIDX = ?";
	
	private String cMemProjApplyModTransaction_1 =
			"UPDATE TF_PROJECT_LIST "
					+	"SET PNAME = ?, CONTENTS = ?, ITLIST = ?, ITLISTCNT = ?, MODDATE = SYSDATE "
					+	"WHERE PIDX = ?";
	
	private String cMemProjApplyModTransaction_2 =
			"UPDATE TF_ITEM_LIST "
					+	"SET ITNAME = ?, ITPRICE = ?, CONTENTS = ?, ITTCNT = ? "
					+	"WHERE ITIDX = ?"
					+ 		"AND PIDX = ?";
	
	private String cMemProjApplyModProj =
			"UPDATE TF_PROJECT_LIST "
					+	"SET PNAME = ?, CONTENTS = ?, ITLIST = ?, ITLISTCNT = ?, MODDATE = SYSDATE "
					+	"WHERE PIDX = ?";
	
	private String cMemProjApplyModItem =
			"UPDATE TF_ITEM_LIST "
					+	"SET ITNAME = ?, ITPRICE = ?, CONTENTS = ?, ITTCNT = ? "
					+	"WHERE ITIDX = ? "
					+		"AND PIDX = ?";
	
	private String cMemProjApplyItemPlusConProj =
			"SELECT PIDX, IDX, PNAME, PCATE, CONTENTS, ITLIST, ITLISTCNT, PTFUNDS, PEDATE, PCDATE "
					+	"FROM TF_PROJECT_LIST "
					+	"WHERE IDX = ? "
					+		"AND STATUS = 0 ";
	
	private String cMemProjApplyItemPlusConItem =
			"SELECT ITIDX, ITNAME, ITPRICE, CONTENTS, ITTCNT "
					+	"FROM TF_ITEM_LIST "
					+	"WHERE PIDX = ?";
	
	private String cMemProjApplyItemPlus_1 =
			"SELECT SEQ_TF_ITIDX.NEXTVAL FROM DUAL";
	
	private String cMemProjApplyItemPlus_2 =
			"INSERT INTO TF_ITEM_LIST (ITIDX, PIDX, ITNAME, ITPRICE, CONTENTS, ITTCNT, ITSCNT, STATUS) "
					+	"VALUES (?, ?, ?, ?, ?, ?, 0, 0)";
	
	private String cMemProjApplyItemPlus_3 =
			"UPDATE TF_PROJECT_LIST "
					+	"SET "
					+		"ITLIST = ITLIST || ?, "
					+		"ITLISTCNT = ITLISTCNT + ? "
					+	"WHERE PIDX = ?";
	
	private String cMemQnaList =
			"SELECT A.PIDX, A.PNAME, B.BIDX, B.IDX, B.CATE, B.TITLE, B.HIT, B.GOOD, B.BAD, B.COMMCNT, B.OBIDX, B.INSDATE, B.PIDX, (SELECT MAX(BDEPTH) FROM TF_BOARD_QNA WHERE BIDX = B.BIDX) STATUS "
					+	"FROM TF_PROJECT_LIST A, TF_BOARD_QNA B "
					+	"WHERE A.PIDX = B.PIDX "
					+		"AND A.IDX = ? "
					+	"ORDER BY B.OBIDX DESC, B.RBIDX ASC";
	
	private String cMemQnaCon =
			"SELECT A.*, B.PIDX, B.PNAME, B.PNFUNDS, B.PGRADE, B.STATUS "
					+	"FROM TF_BOARD_QNA A, TF_PROJECT_LIST B "
					+	"WHERE A.PIDX = B.PIDX "
					+		"AND A.BIDX = ?";
	
	private String cMemQnaWrite_1 =
			"UPDATE TF_BOARD_QNA "
					+	"SET RBIDX = RBIDX + 1 "
					+	"WHERE OBIDX = (SELECT OBIDX FROM TF_BOARD_QNA WHERE BIDX = ?) "
					+		"AND RBIDX > (SELECT RBIDX FROM TF_BOARD_QNA WHERE BIDX = ?)";

	private String cMemQnaWrite_2 =  
			"INSERT INTO TF_BOARD_QNA (BIDX, IDX, CATE, TITLE, CONTENTS, HIT, GOOD, BAD, OBIDX, RBIDX, BDEPTH, COMMCNT, VIEWSTAT, INSDATE, MODDATE, PIDX) "
					+	"VALUES ("
					+		"SEQ_TF_BIDX_QNA.NEXTVAL, "
					+		"?, " //IDX
					+		"(SELECT CATE FROM TF_BOARD_QNA WHERE BIDX = ?), " //CATE
					+		"?, " //TITLE
					+		"?, " //CONTENTS
					+		"0, "
					+		"0, "
					+		"0, "
					+		"(SELECT OBIDX FROM TF_BOARD_QNA WHERE BIDX = ?), " //OBIDX
					+		"(SELECT RBIDX FROM TF_BOARD_QNA WHERE BIDX = ?) + 1, " //RBIDX
					+		"(SELECT BDEPTH FROM TF_BOARD_QNA WHERE BIDX = ?) + 1, " //BDEPTH
					+		"0, "
					+		"1, "
					+		"SYSDATE, "
					+		"SYSDATE, "
					+		"(SELECT PIDX FROM TF_BOARD_QNA WHERE BIDX = ?)" //PIDX
					+	")";
	
	private String cMemQnaMod =
			"UPDATE TF_BOARD_QNA "
					+	"SET TITLE = ?, CONTENTS = ?, MODDATE = SYSDATE "
					+	"WHERE BIDX = ?";

	public String getcMemIndexProjNowList() {
		return cMemIndexProjNowList;
	}

	public String getcMemIndexCommList() {
		return cMemIndexCommList;
	}

	public String getcMemIndexNewsList() {
		return cMemIndexNewsList;
	}

	public String getcMemInfoCon() {
		return cMemInfoCon;
	}

	public String getcMemInfoModChk() {
		return cMemInfoModChk;
	}

	public String getcMemInfoMod() {
		return cMemInfoMod;
	}

	public String getcMemInfoExtWriteChk() {
		return cMemInfoExtWriteChk;
	}

	public String getcMemInfoExtWrite() {
		return cMemInfoExtWrite;
	}

	public String getcMemMemoWriteIMemList() {
		return cMemMemoWriteIMemList;
	}

	public String getcMemMemoWrite() {
		return cMemMemoWrite;
	}

	public String getcMemMemoSendList() {
		return cMemMemoSendList;
	}

	public String getcMemMemoDel() {
		return cMemMemoDel;
	}

	public String getcMemNewsList() {
		return cMemNewsList;
	}

	public String getcMemNewsCon() {
		return cMemNewsCon;
	}

	public String getcMemNewsMod() {
		return cMemNewsMod;
	}

	public String getcMemNewsWriteProjNow() {
		return cMemNewsWriteProjNow;
	}

	public String getcMemNewsWrite() {
		return cMemNewsWrite;
	}

	public String getcMemNewsDel() {
		return cMemNewsDel;
	}

	public String getcMemProjNowList() {
		return cMemProjNowList;
	}

	public String getcMemProjHisList() {
		return cMemProjHisList;
	}

	public String getcMemProjApplyConProj() {
		return cMemProjApplyConProj;
	}

	public String getcMemProjApplyConItem() {
		return cMemProjApplyConItem;
	}

	public String getcMemProjApplyModTransaction_1() {
		return cMemProjApplyModTransaction_1;
	}

	public String getcMemProjApplyModTransaction_2() {
		return cMemProjApplyModTransaction_2;
	}

	public String getcMemProjApplyModProj() {
		return cMemProjApplyModProj;
	}

	public String getcMemProjApplyModItem() {
		return cMemProjApplyModItem;
	}

	public String getcMemProjApplyItemPlusConProj() {
		return cMemProjApplyItemPlusConProj;
	}

	public String getcMemProjApplyItemPlusConItem() {
		return cMemProjApplyItemPlusConItem;
	}

	public String getcMemProjApplyItemPlus_1() {
		return cMemProjApplyItemPlus_1;
	}

	public String getcMemProjApplyItemPlus_2() {
		return cMemProjApplyItemPlus_2;
	}

	public String getcMemProjApplyItemPlus_3() {
		return cMemProjApplyItemPlus_3;
	}

	public String getcMemQnaList() {
		return cMemQnaList;
	}

	public String getcMemQnaCon() {
		return cMemQnaCon;
	}

	public String getcMemQnaWrite_1() {
		return cMemQnaWrite_1;
	}

	public String getcMemQnaWrite_2() {
		return cMemQnaWrite_2;
	}

	public String getcMemQnaMod() {
		return cMemQnaMod;
	}
	
}
