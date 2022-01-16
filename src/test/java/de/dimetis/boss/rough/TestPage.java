package de.dimetis.boss.rough;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import de.dimetis.boss.base.BaseTest;

public class TestPage extends BaseTest {

	@Test(description = "This is simplae test")
	public void testMethod(Method m) {
		m.getAnnotation(Test.class).description();
		
	}
}
