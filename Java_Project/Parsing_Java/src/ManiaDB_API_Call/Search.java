package ManiaDB_API_Call;


// http://www.maniadb.com/api/search/[keyword]/?sr=[artist|album|song]&display=[1~100]&key=[apikey]&v=[version]
public class Search {
	
	private String keyword;
	private String type;
	private int display;
	private String key;
	private String ver;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public Search(String keyword, String type, int display, String key, String ver) {
		super();
		this.keyword = keyword;
		this.type = type;
		this.display = display;
		this.key = key;
		this.ver = ver;
	}
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
