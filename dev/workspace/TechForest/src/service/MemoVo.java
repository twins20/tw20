package service;

public class MemoVo {

	private int rNum;
	private int memoIdx;
	private int sendIdx;
	private int recvIdx;
	private String contents;
	private int status;
	private String insDate;
	private String modDate;
	
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getMemoIdx() {
		return memoIdx;
	}
	public void setMemoIdx(int memoIdx) {
		this.memoIdx = memoIdx;
	}
	public int getSendIdx() {
		return sendIdx;
	}
	public void setSendIdx(int sendIdx) {
		this.sendIdx = sendIdx;
	}
	public int getRecvIdx() {
		return recvIdx;
	}
	public void setRecvIdx(int recvIdx) {
		this.recvIdx = recvIdx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
