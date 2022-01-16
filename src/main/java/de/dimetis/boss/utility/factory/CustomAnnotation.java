package de.dimetis.boss.utility.factory;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import de.dimetis.boss.config.Constants.CategoryType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface CustomAnnotation {
	
	public String[] author();
	
	public CategoryType[] category();

}
