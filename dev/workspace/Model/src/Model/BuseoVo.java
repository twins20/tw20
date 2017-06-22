package Model;

public class BuseoVo { // 데이터 구성 관련 설정

	private int bidx; // idx
	private String bname; // name
	private int idx; // age
	
	public int getBidx() { // idx값을 반환함  set는 값을 담는 것이고, get은 담은 값을 반환하는 것
		return bidx; // return을 통해 idx 값을 반환
	}
	public void setBidx(int bidx) { // setidx를 통해 값을 담음(타입 객체) 작성
		this.bidx = bidx; // 자기 자신 idx에 idx 값을 담게 됨
	}
	public String getBname() { // name 값 반환
		return bname;
	}
	public void setBname(String bname) { // name 값 담음
		this.bname = bname;
	}
	public int getIdx() { // age 값 반환
		return idx;
	}
	public void setIdx(int idx) { // age 값을 담음
		this.idx = idx;
	}

}
