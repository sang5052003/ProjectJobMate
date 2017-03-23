package jobmate.domain;

public class Recruit {

	private String id;
	private String name;
	private String title;
	private String requiredEducationLevel;
	private String jobType;
	private String location;
	private String href;
	private String expirationTime;
	private String applyCnt;
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Recruit(){
		
	}
	
	
	public Recruit(String name,String title,String applyCnt,String href) {
		this.name = name;
		this.title = title;
		this.applyCnt = applyCnt;
		this.href = href;
	}
	
	public String getApplyCnt() {
		return applyCnt;
	}

	public void setApplyCnt(String applyCnt) {
		this.applyCnt = applyCnt;
	}

	public Recruit(String id,String name, String title, String requiredEducationLevel, String jobType, String location,
			 String expirationTime,String href) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.requiredEducationLevel = requiredEducationLevel;
		this.jobType = jobType;
		this.location = location;
		this.expirationTime = expirationTime;
		this.href = href;
	}

	//기업명, 제목, 지원자격 - requiredEducationLevel, 근무조건 - 지역 + job-type, 마감일(등록일)
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRequiredEducationLevel() {
		return requiredEducationLevel;
	}
	public void setRequiredEducationLevel(String requiredEducationLevel) {
		this.requiredEducationLevel = requiredEducationLevel;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	
	
	
	
}
