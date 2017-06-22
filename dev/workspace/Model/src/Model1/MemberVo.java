package Model1;

public class MemberVo { // 데이터 구성 관련 설정
	// private 반환을 위해 public로 반환값을 만들어줘야 합니다.
	private int idx; // idx
	private String name; // name
	private int age; // age
	private String sex; // sex
	private String area; // area 여기는 조회하려는 테이블에 있는 컬럼을 각각 선언해주면 됨
	public int getIdx() { // idx값을 반환함  set는 값을 담는 것이고, get은 담은 값을 반환하는 것
		return idx; // return을 통해 idx 값을 반환
	}
	public void setIdx(int idx) { // setidx를 통해 값을 담음(타입 객체) 작성
		this.idx = idx; // 자기 자신 idx에 idx 값을 담게 됨
	}
	public String getName() { // name 값 반환
		return name;
	}
	public void setName(String name) { // name 값 담음
		this.name = name;
	}
	public int getAge() { // age 값 반환
		return age;
	}
	public void setAge(int age) { // age 값을 담음
		this.age = age;
	}
	public String getSex() { // sex 값 반환
		return sex;
	}
	public void setSex(String sex) { // sex 값 담음
		this.sex = sex;
	}
	public String getArea() { // area 값 반환
		return area;
	}
	public void setArea(String area) { // area 값 담음
		this.area = area;
	}
}
