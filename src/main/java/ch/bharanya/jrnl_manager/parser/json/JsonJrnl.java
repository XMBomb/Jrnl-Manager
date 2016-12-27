package ch.bharanya.jrnl_manager.parser.json;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import ch.bharanya.jrnl_manager.parser.Tag;

public class JsonJrnl {

	List<JsonJrnlEntry> entries;
	Map<String, Integer> tags;

	public List<JsonJrnlEntry> getEntries() {
		return entries;
	}

	public void setEntries(final List<JsonJrnlEntry> entries) {
		this.entries = entries;
	}

	public List<Tag> getTags() {
		return tags.keySet().stream()
			.map(key -> {
				return new Tag(key, tags.get(key));
			})
			.collect(Collectors.toList());
	}

	public void setTags(final Map<String, Integer> tags) {
		this.tags = tags;
	}
	
	public List<JrnlEntry> getJrnlEntries(){
		return entries.stream()
				.map(jsonEntry -> {
					return new JrnlEntry(jsonEntry);
				}).collect(Collectors.toList());
	}
}
