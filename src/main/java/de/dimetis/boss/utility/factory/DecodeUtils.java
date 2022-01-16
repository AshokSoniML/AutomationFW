package de.dimetis.boss.utility.factory;

import java.util.Base64;

public final class DecodeUtils {

	private DecodeUtils() {	}
	
	public static String getDecodedString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}
}
