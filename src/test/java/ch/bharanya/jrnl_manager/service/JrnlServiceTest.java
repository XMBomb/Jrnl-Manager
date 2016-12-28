package ch.bharanya.jrnl_manager.service;

import ch.bharanya.jrnl_manager.ATest;
import ch.bharanya.jrnl_manager.conf.Config;
import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import ch.bharanya.jrnl_manager.parser.Tag;
import ch.bharanya.jrnl_manager.util.AssertUtil;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

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
        JrnlEntry jrnlEntry = new JrnlEntry()
                .setDate(LocalDateTime.of(2014,12,24,13,59))
                .setBody("\n")
                .setTitle("Rating: 9")
                .setStarred(false);
        Assert.assertEquals(jrnlEntry, JrnlService.getInstance().findJrnlEntryWithDate("2014-12-24T13:59").get());
    }

    @Test
    public void findJrnlEntriesByTagName() throws Exception {
        List<JrnlEntry> entries = JrnlService.getInstance().findJrnlEntriesByTagName("@Test");
        Assert.assertEquals(3, entries.size());
    }


}