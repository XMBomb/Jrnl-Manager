package ch.bharanya.jrnl_manager.service;

import ch.bharanya.jrnl_manager.ATest;
import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import ch.bharanya.jrnl_manager.parser.Tag;
import ch.bharanya.jrnl_manager.service.validation.ValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by XMBomb on 28.12.2016.
 */
public class JrnlServiceTest extends ATest{

    @Test
    public void getJrnlEntries() throws Exception {
        // tested in parser
    }

    @Test
    public void getTags() throws Exception {
        // tested in parser
    }

    @Test
    public void findTagByName() throws Exception {
        Assert.assertTrue(new Tag("@cyrill", 14).equals(JrnlService.getInstance().findTagByName("@cyrill").get()));
        Assert.assertTrue(new Tag("@noah", 4).equals(JrnlService.getInstance().findTagByName("@noah").get()));
        Assert.assertFalse(JrnlService.getInstance().findTagByName("@ndsesdfsdfsfoah").isPresent());
    }

    @Test
    public void findJrnlEntryWithDate() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.of(2014, 12, 24, 13, 59);
        JrnlEntry jrnlEntry = new JrnlEntry()
                .setDate(localDateTime)
                .setBody("\n")
                .setTitle("Rating: 9")
                .setStarred(false);
        Assert.assertEquals(jrnlEntry, JrnlService.getInstance().findJrnlEntryWithDateTime("2014-12-24T13:59").get());

        Assert.assertEquals(jrnlEntry, JrnlService.getInstance().findJrnlEntryWithDateTime(localDateTime).get());
    }

    @Test
    public void findJrnlEntriesByTagName() throws Exception {
        List<JrnlEntry> entries = JrnlService.getInstance().findJrnlEntries("@Test");
        Assert.assertEquals(3, entries.size());
    }

    @Test
    public void findRandomEntry() throws Exception {
        JrnlEntry jrnlEntry = JrnlService.getInstance().findRandomEntry();
        Assert.assertTrue(jrnlEntry != null  && jrnlEntry instanceof JrnlEntry);
    }

    @Test
    public void addJrnlEntry() throws ValidationException {
        LocalDateTime localDateTime = LocalDateTime.now();
        JrnlEntry jrnlEntry = new JrnlEntry().setBody("TestBody").setDate(localDateTime).setTitle("TestTitle").setStarred(false);

        JrnlService.getInstance().addJrnlEntry(jrnlEntry);

        Optional<JrnlEntry> savedJrnlEntry = JrnlService.getInstance().findJrnlEntryWithDateTime(localDateTime);

        Assert.assertTrue(savedJrnlEntry.isPresent());
        Assert.assertEquals(savedJrnlEntry.get(), jrnlEntry);
    }

    @Test
    public void updateJrnlEntry(){

    }

    @Test
    public void deleteJrnlEntry(){

    }

}