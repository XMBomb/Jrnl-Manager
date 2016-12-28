package ch.bharanya.jrnl_manager.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import ch.bharanya.jrnl_manager.parser.json.JsonJrnlEntry;
import ch.bharanya.jrnl_manager.util.JsonUtil;

public class JrnlEntry {
	private LocalDateTime date;
	private String body;
	private String title;
	private boolean starred;

	public JrnlEntry(){

	}
	
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

	public JrnlEntry setDate(final LocalDateTime date) {
		this.date = date;
		return this;
	}

	public String getBody() {
		return body;
	}

	public JrnlEntry setBody(final String body) {
		this.body = body;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public JrnlEntry setTitle(final String title) {
		this.title = title;
		return this;
	}

	public boolean isStarred() {
		return starred;
	}

	public JrnlEntry setStarred(final boolean starred) {
		this.starred = starred;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof  JrnlEntry)) return false;

		JrnlEntry otherEntry = (JrnlEntry) obj;
		return (
				otherEntry.getDate().equals(getDate())
				&& otherEntry.getBody().equals(getBody())
				&& otherEntry.getContent().equals(getContent())
				&& otherEntry.getTitle().equals(getTitle())
				&& otherEntry.isStarred() == isStarred()
		);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBody(), getContent(), getDate(), getTitle(), isStarred());
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
