package de.dimetis.boss.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDataTestCase {

	@Test(dataProvider = "getData")
	public void doLogin(Map<String, String> map) {
		System.out.println(map.get("username"));
		
	}
	
	@SuppressWarnings("resource")
	@DataProvider
	public Object[] getData() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/excel/testData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("userLogin");
		
		int rowNo = sheet.getLastRowNum();
		int columnNo = sheet.getRow(0).getLastCellNum();
		
		Object [] data = new Object[rowNo];
		Map<String, String> map;
		for(int i=1;i<=rowNo;i++) {
			map = new HashMap<>();
			for(int j=0;j<columnNo;j++) {
				String key =sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i-1] = map;
			}
		}
		return data;
	}
}
