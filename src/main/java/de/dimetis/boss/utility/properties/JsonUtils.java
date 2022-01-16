package de.dimetis.boss.utility.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.dimetis.boss.config.Constants;
import de.dimetis.boss.config.Constants.ConfigProperties;

public class JsonUtils {

	private static Map<String, String> CONFIGMAP;
	
	private JsonUtils() {
		
	}
	
	static {
		try {
			CONFIGMAP = new ObjectMapper().readValue(new File(Constants.getJsonConfigFilePath()),
					new TypeReference<HashMap<String, String>>() {
					});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String get(ConfigProperties key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name :" + key + " is not Found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
