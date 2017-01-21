package ch.bharanya.jrnl_manager.controller;

import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import ch.bharanya.jrnl_manager.parser.json.JsonJrnl;
import ch.bharanya.jrnl_manager.util.RequestUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class EntryControllerTest extends AControllerTest{
	@Test
	public void getAllEntries() {
		final TestResponse res = RequestUtil.request("GET", "/entries");
		final JsonJrnl entries = res.getJson(JsonJrnl.class);
		Assert.assertEquals(200, res.status);
	}

	@Test
	public void getEntryWithDate() {
		final TestResponse res = RequestUtil.request("GET", "/entry/2014-12-23T12:12");
		final JrnlEntry entry = res.getJson(JrnlEntry.class);
		Assert.assertEquals(200, res.status);
	}

//	@Test
//	public void getTagByName() {
//		final TestResponse res = RequestUtil.request("GET", "/tag/@cyrill");
//		final Tag tag = res.getJson(Tag.class);
//		Assert.assertEquals(new Tag("@cyrill", 14), tag);
//	}
//
//	@Test
//	public void getNonExistingTag() {
//		final TestResponse res = RequestUtil.request("GET", "/tag/@nopasdklajsdolasjd");
//		final ErrorMessage errorMessage = res.getJson(ErrorMessage.class);
//
//		Assert.assertTrue(errorMessage.getType() == EMessageType.ERROR);
//		// I know :) but if the error message at least contains the stuff were
//		// looking for I'm happy
//		Assert.assertTrue(errorMessage.getMessage().contains("@nopasdklajsdolasjd"));
//	}

}
