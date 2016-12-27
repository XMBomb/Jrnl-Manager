package ch.bharanya.jrnl_manager.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import ch.bharanya.jrnl_manager.parser.json.JsonJrnl;

public class JrnlParser {
	private List<JrnlEntry> jrnlEntries;
	private final File jsonEntriesFile;
	private List<Tag> tags;

	public JrnlParser(final File jsonEntriesFile) {
		this.jsonEntriesFile = jsonEntriesFile;
	}

	public void parseFile() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		final Gson gson = new Gson();

		final JsonJrnl jsonJrnl = gson.fromJson(new FileReader(jsonEntriesFile), JsonJrnl.class);
		this.jrnlEntries = jsonJrnl.getJrnlEntries();
		this.tags = jsonJrnl.getTags();
	}

	public List<JrnlEntry> getJrnlEntries() {
		return jrnlEntries;
	}

	public List<Tag> getTags() {
		return tags;
	}
}
