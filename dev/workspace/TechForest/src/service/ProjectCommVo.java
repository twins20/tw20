package service;

public class ProjectCommVo {
	
	private int rNum;
	private int pCommIdx;
 	private int pIdx;
 	private int idx;
 	private String Comments;
 	private int good;
 	private int bad;
 	private int opCommIdx;
 	private int rpCommIdx;
 	private int pCommDepth;
 	private int viewStat;
 	private String insDate;
 	private String modDate;
	
 	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getpCommIdx() {
		return pCommIdx;
	}
	public void setpCommIdx(int pCommIdx) {
		this.pCommIdx = pCommIdx;
	}
	public int getpIdx() {
		return pIdx;
	}
	public void setpIdx(int pIdx) {
		this.pIdx = pIdx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
	public int getOpCommIdx() {
		return opCommIdx;
	}
	public void setOpCommIdx(int opCommIdx) {
		this.opCommIdx = opCommIdx;
	}
	public int getRpCommIdx() {
		return rpCommIdx;
	}
	public void setRpCommIdx(int rpCommIdx) {
		this.rpCommIdx = rpCommIdx;
	}
	public int getpCommDepth() {
		return pCommDepth;
	}
	public void setpCommDepth(int pCommDepth) {
		this.pCommDepth = pCommDepth;
	}
	public int getViewStat() {
		return viewStat;
	}
	public void setViewStat(int viewStat) {
		this.viewStat = viewStat;
	}
	public String getInsDate() {
		return insDate;
	}
	public void setInsDate(String insDate) {
		this.insDate = insDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
  	
}
