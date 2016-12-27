package ch.bharanya.jrnl_manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import ch.bharanya.jrnl_manager.parser.JrnlParser;
import ch.bharanya.jrnl_manager.parser.Tag;

public class JrnlManager {
	/**
	* <p>The {@link Logger} for this class.</p>
	*/
	private static final Logger LOGGER = LoggerFactory.getLogger(JrnlManager.class);

	private List<JrnlEntry> jrnlEntries = new ArrayList<>();
	private List<Tag> tags = new ArrayList<>();

	protected JrnlManager() {
		final JrnlParser parser = new JrnlParser(new File("res\\test\\export.json"));
		try{
			parser.parseFile();
			jrnlEntries = parser.getJrnlEntries();
			tags = parser.getTags();
		}catch(final Exception e){
			LOGGER.error("Couldn't parse file :(", e);
		}
	};
	
	private static final JrnlManager instance = new JrnlManager();

	// Runtime initialization
	// By default ThreadSafe
	public static JrnlManager getInstance() {
		return instance;
	}
	
	public List<JrnlEntry> getJrnlEntries(){
		return jrnlEntries;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

//	public JrnlEntry findJrnlEntryWithDate(final String dateTime) {
//		LocalDateTime.o
//	}

}
