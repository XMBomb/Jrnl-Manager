package ch.bharanya.jrnl_manager.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import ch.bharanya.jrnl_manager.conf.Config;
import ch.bharanya.jrnl_manager.controller.TestResponse;
import junit.framework.Assert;
import spark.utils.IOUtils;

public class RequestUtil {
	
	public static TestResponse request(final String method, final String path) {
		try {
			final URL url = new URL(Config.getDefault().getStringProperty("url") + path);
			final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			connection.connect();
			InputStream inputStream;
			try {
				inputStream = connection.getInputStream();
			}catch(final IOException ioe){
				inputStream = connection.getErrorStream();
			}

			final String body = IOUtils.toString(inputStream);
			return new TestResponse(connection.getResponseCode(), body);
		} catch (final IOException e) {
			e.printStackTrace();
			Assert.fail("Sending request failed: " + e.getMessage());
			return null;
		}
	}
}
