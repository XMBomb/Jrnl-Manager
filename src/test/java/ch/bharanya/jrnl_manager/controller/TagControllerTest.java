package ch.bharanya.jrnl_manager.controller;

import java.util.List;

import ch.bharanya.jrnl_manager.controller.message.EMessageType;
import ch.bharanya.jrnl_manager.controller.message.ErrorMessage;
import org.junit.Assert;
import org.junit.Test;

import com.google.gson.internal.LinkedTreeMap;

import ch.bharanya.jrnl_manager.parser.Tag;
import ch.bharanya.jrnl_manager.util.RequestUtil;

public class TagControllerTest extends AControllerTest{
	
	@Test
	public void getAllTags() {
	  final TestResponse res = RequestUtil.request("GET", "/tags");
	  final List<LinkedTreeMap<String, Integer>> tags = res.getJson(List.class);
	  Assert.assertEquals(200, res.status);
	  Assert.assertEquals("@cyrill", tags.get(0).get("name"));
	  Assert.assertEquals(new Double(14), tags.get(0).get("numUses"));
	  
	  Assert.assertEquals("@noah", tags.get(1).get("name"));
	  Assert.assertEquals(new Double(4), tags.get(1).get("numUses"));
	}
	
	@Test
	public void getTagByName() {
		  final TestResponse res = RequestUtil.request("GET", "/tag/@cyrill");
		  final Tag tag = res.getJson(Tag.class);
		  Assert.assertEquals(new Tag("@cyrill", 14), tag);
	}
	
	@Test
	public void getNonExistingTag() {
		  final TestResponse res = RequestUtil.request("GET", "/tag/@nopasdklajsdolasjd");
		  final ErrorMessage errorMessage = res.getJson(ErrorMessage.class);
		  
		  
		  Assert.assertTrue(errorMessage.getType() == EMessageType.ERROR);
		  // I know :) but if the error message at least contains the stuff were looking for I'm happy
		  Assert.assertTrue(errorMessage.getMessage().contains("@nopasdklajsdolasjd"));
	}
	
	

}
