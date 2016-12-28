package ch.bharanya.jrnl_manager.jrnl;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import ch.bharanya.jrnl_manager.parser.JrnlParser;
import ch.bharanya.jrnl_manager.parser.Tag;
import org.junit.Assert;

public class JrnlParserTest {
	File testFile = new File("res\\test\\export.json");
	JrnlParser parser = new JrnlParser(testFile);

	@Test
	public void testParseFile() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		parser.parseFile();

		final List<JrnlEntry> jrnlEntries = parser.getJrnlEntries();

		Assert.assertEquals(LocalDateTime.of(2014, 12, 22, 00, 00, 00), jrnlEntries.get(0).getDate());
		Assert.assertEquals("Just finished now\nHappy :D\n\n", jrnlEntries.get(0).getBody());
		Assert.assertEquals("Rating: 8, Good day at work, got to work on this", jrnlEntries.get(0).getTitle());
		Assert.assertEquals(false, jrnlEntries.get(0).isStarred());

		Assert.assertEquals(true, jrnlEntries.get(1).isStarred());

		Assert.assertEquals(LocalDateTime.of(2014, 12, 23, 12, 12, 00), jrnlEntries.get(1).getDate());
		Assert.assertEquals(LocalDateTime.of(2014, 12, 24, 13, 59, 00), jrnlEntries.get(2).getDate());
	}

	@Test
	public void testTags() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		parser.parseFile();
		final List<Tag> tags = parser.getTags();
		Assert.assertEquals(new Tag("@cyrill", 14), tags.get(0));
		Assert.assertEquals(new Tag("@noah", 4), tags.get(1));
	}
}
