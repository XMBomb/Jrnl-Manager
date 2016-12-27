package ch.bharanya.jrnl_manager.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ch.bharanya.jrnl_manager.parser.json.JsonJrnlEntry;

public class JrnlEntry {
	private LocalDateTime date;
	private String body;
	private String title;
	private boolean starred;
	
	public JrnlEntry(final JsonJrnlEntry jsonEntry) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.date = LocalDateTime.parse(jsonEntry.getDate() + " " + jsonEntry.getTime(), formatter);
		this.body = jsonEntry.getBody();
		this.title = jsonEntry.getTitle();
		this.starred = jsonEntry.isStarred();
	}

	public String getContent(){
		return title+body;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(final LocalDateTime date) {
		this.date = date;
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
