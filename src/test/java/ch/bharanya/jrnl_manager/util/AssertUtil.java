package ch.bharanya.jrnl_manager.util;

import junit.framework.Assert;

public class AssertUtil {
	public static void assertNotEquals(final Object expected, final Object actual){
		Assert.assertFalse(expected.equals(actual));
	}
}
