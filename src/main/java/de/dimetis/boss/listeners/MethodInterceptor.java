package de.dimetis.boss.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import de.dimetis.boss.utility.factory.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String, String>> list = ExcelUtils.getTestDetails("RUNNERMODE");
		List<IMethodInstance> result = new ArrayList<>();
		
		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testcaseName"))) {
					if(list.get(j).get("is_executable").equalsIgnoreCase("yes")) {
						methods.get(i).getMethod().setDescription(list.get(j).get("description"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
						result.add(methods.get(i));
					}
				}
			}
		}
		return result;
	}
}
