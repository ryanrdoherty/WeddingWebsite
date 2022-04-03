package com.mrfeelings;

import java.util.Map;

import org.conical.common.bbl.util.PropertyMapLoader;

public class Config {
	
	public static enum PropKey {
		registryUrl,
		imagesDir,
		userDataFile,
		guestbookEmail,
		rsvpEmail,
		happyCoupleEmail,
		smtpServer,
		smtpAuthUsername,
		smtpAuthPassword;
	}
	
	private static final String PROPERTY_FILE = "config.properties";

	private static final Map<PropKey, String> _props =
		PropertyMapLoader.loadEnumProperties(PROPERTY_FILE, PropKey.class);
	
	public static String getValue(PropKey key) {
		return _props.get(key);
	}
}
