package Model;

public class SalaryVo { // 데이터 구성 관련 설정
	// private 반환을 위해 public로 반환값을 만들어줘야 합니다.
	private int sidx; 
	private int round;
	private int amount; 
	private int idx; 
	
	public int getSidx() { 
		return sidx; 
	}
	public void setSidx(int sidx) { 
		this.sidx = sidx; 
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) { 
		this.round = round;
	}
	public int getAmount() { // age 값 반환
		return amount;
	}
	public void setAmount(int amount) { // age 값을 담음
		this.amount = amount;
	}
	public int getIdx() { // sex 값 반환
		return idx;
	}
	public void setIdx(int idx) { // sex 값 담음
		this.idx = idx;
	}
}
