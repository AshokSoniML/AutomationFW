package de.dimetis.boss.utility.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import de.dimetis.boss.config.Constants;
import de.dimetis.boss.config.Constants.ConfigProperties;
import de.dimetis.boss.exception.PropertitesUtilsException;

public final class PropertitesUtils {

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	private PropertitesUtils() {	}

	static {
		try (FileInputStream fis = new FileInputStream(Constants.getConfigFilePath());
				BufferedInputStream bfis = new BufferedInputStream(fis);) {
			property.load(fis);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
		} catch (IOException e) {
			throw new PropertitesUtilsException("Something went for IO exception happned while reading Propertites file.");
		}
	}

	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertitesUtilsException("Property name :" + key + " is not Found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
