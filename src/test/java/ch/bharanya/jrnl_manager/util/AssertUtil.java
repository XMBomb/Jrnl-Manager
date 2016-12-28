package ch.bharanya.jrnl_manager.util;


import org.junit.Assert;

public class AssertUtil {
	public static void assertNotEquals(final Object expected, final Object actual){
		Assert.assertFalse(expected.equals(actual));
	}
}
