package admin;

public class ValidationVO {
	private int delCount;
	private int delType;
	private int numbers;
	private String delName;
	
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public int getDelCount() {
		return delCount;
	}
	public void setDelCount(int delCount) {
		this.delCount = delCount;
	}
	public int getDelType() {
		return delType;
	}
	public void setDelType(int delType) {
		this.delType = delType;
	}
	public String getDelName() {
		return delName;
	}
	public void setDelName(String delName) {
		this.delName = delName;
	}

}
