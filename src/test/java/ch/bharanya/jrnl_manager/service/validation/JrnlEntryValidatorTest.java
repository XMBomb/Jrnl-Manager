package ch.bharanya.jrnl_manager.service.validation;

import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by XMBomb on 21.01.2017.
 */
public class JrnlEntryValidatorTest {
    @Test
    public void valid() throws Exception {
        JrnlEntry validEntry = new JrnlEntry().setBody("validBody").setTitle("ValidTitle").setDate(LocalDateTime.now()).setStarred(false);

        JrnlEntryValidator jrnlEntryValidator = new JrnlEntryValidator(validEntry);
        Assert.assertTrue(jrnlEntryValidator.isValid());
    }

    @Test
    public void nonValid() {
        JrnlEntry nothingValidEntry = new JrnlEntry().setBody(null).setTitle(null).setDate(null).setStarred(false);
        JrnlEntry bodyValidEntry = new JrnlEntry().setBody("validBody").setTitle(null).setDate(null).setStarred(false);
        JrnlEntry titleValidEntry = new JrnlEntry().setBody(null).setTitle("validTitle").setDate(null).setStarred(false);
        JrnlEntry dateValidEntry = new JrnlEntry().setBody(null).setTitle(null).setDate(LocalDateTime.now()).setStarred(false);

        JrnlEntryValidator jrnlEntryValidator = new JrnlEntryValidator(nothingValidEntry);
        Assert.assertFalse(jrnlEntryValidator.isValid());

        jrnlEntryValidator = new JrnlEntryValidator(bodyValidEntry);
        Assert.assertFalse(jrnlEntryValidator.isValid());

        jrnlEntryValidator = new JrnlEntryValidator(titleValidEntry);
        Assert.assertFalse(jrnlEntryValidator.isValid());

        jrnlEntryValidator = new JrnlEntryValidator(dateValidEntry);
        Assert.assertFalse(jrnlEntryValidator.isValid());

        jrnlEntryValidator = new JrnlEntryValidator(null);
        Assert.assertFalse(jrnlEntryValidator.isValid());

    }

}