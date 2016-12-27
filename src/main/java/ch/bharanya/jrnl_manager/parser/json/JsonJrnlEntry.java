package ch.bharanya.jrnl_manager.parser.json;

public class JsonJrnlEntry {
	private String date;
	private String time;
	private String body;
	private String title;
	private boolean starred;

	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(final String time) {
		this.time = time;
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public boolean isStarred() {
		return starred;
	}

	public void setStarred(final boolean starred) {
		this.starred = starred;
	}
}
