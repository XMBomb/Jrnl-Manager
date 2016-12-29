package ch.bharanya.jrnl_manager.service;

import ch.bharanya.jrnl_manager.conf.Config;
import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import ch.bharanya.jrnl_manager.parser.JrnlParser;
import ch.bharanya.jrnl_manager.parser.Tag;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JrnlService {
	/**
	* <p>The {@link Logger} for this class.</p>
	*/
	private static final Logger LOGGER = LoggerFactory.getLogger(JrnlService.class);

	private List<JrnlEntry> jrnlEntries = new ArrayList<>();
	private List<Tag> tags = new ArrayList<>();

	protected JrnlService() {
		final JrnlParser parser = new JrnlParser(new File(Config.getDefault().getStringProperty("importFile")));
		try{
			parser.parseFile();
			jrnlEntries = parser.getJrnlEntries();
			tags = parser.getTags();
		}catch(final Exception e){
			LOGGER.error("Couldn't parse file :(", e);
		}
	};
	
	private static final JrnlService instance = new JrnlService();

	// Runtime initialization
	// By default ThreadSafe
	public static JrnlService getInstance() {
		return instance;
	}
	
	public List<JrnlEntry> getJrnlEntries(){
		return jrnlEntries;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public Optional<Tag> findTagByName(final String tagName) {
		return getTags().stream()
				.filter(tag -> StringUtils.equalsIgnoreCase(tag.getName(), tagName)).findFirst();
	}

	public Optional<JrnlEntry> findJrnlEntryWithDate(final String dateTime) {
		try {
			LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
			return getJrnlEntries().stream()
					.filter(jrnlEntry ->
							jrnlEntry.getDate().isEqual(localDateTime)
					)
					.findFirst();
		}catch (DateTimeParseException e){
			return Optional.empty();
		}
	}

	public List<JrnlEntry> findJrnlEntries(String searchText){
		return getJrnlEntries().stream()
				.filter(jrnlEntry ->
						StringUtils.containsIgnoreCase(jrnlEntry.getContent(), searchText)
				)
				.collect(Collectors.toList());
	}

	public JrnlEntry findRandomEntry() {
		int min = 0;
		List<JrnlEntry> jrnlEntries = getJrnlEntries();
		int max = jrnlEntries.size();
		return jrnlEntries.get(ThreadLocalRandom.current().nextInt(min, max));
	}
}
