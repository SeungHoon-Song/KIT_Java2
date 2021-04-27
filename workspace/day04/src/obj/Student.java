package obj;

public class Student {
	//alt shift a 그리드 모드
	public int num;
	public String name;
	
	public Student() {
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj;
			if(this.hashCode() == std.hashCode()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.num;
	}
}
