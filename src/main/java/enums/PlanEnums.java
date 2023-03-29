package enums;

public enum PlanEnums {
	LITE("lite","لايت"),
	CLASSIC("classic","الأساسية"),
	PREMIUM("premium","بريميوم");
	
	public final String arabicName;
	public final String englishName;
	
	private PlanEnums(String englishName,String arabicName) {
		this.arabicName = arabicName;
		this.englishName = englishName;
	}
}
