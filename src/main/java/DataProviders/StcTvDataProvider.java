package DataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Helpers.ExcelReader;

public class StcTvDataProvider {

	ExcelReader excelReader;

	@DataProvider(name = "stcTvDataProvider", parallel = true)
	public Object[][] jawwyProvider() throws IOException {
		String filePath = ".\\Resources\\stcTvData_en.xlsx";
		excelReader = new ExcelReader(filePath);
		Object[][] data = excelReader.getDataObject(1, 5);
		return data;
	}
}