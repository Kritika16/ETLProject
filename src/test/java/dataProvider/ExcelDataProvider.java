package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
public class ExcelDataProvider {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelDataProvider() throws Exception{
		ConfigDataProvider config = new ConfigDataProvider();
		File src = new File(config.getExcelPath());
		try {
			
			FileInputStream fil = new FileInputStream(src);
			wb = new XSSFWorkbook(fil); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is"+e.getMessage());
		}
	}			

public String getData(int sheetno, int row, int col){
	sheet = wb.getSheetAt(sheetno);
	String data = sheet.getRow(row).getCell(col).getStringCellValue();
	return data;	
}

public String getData(String sheetname, int row, int col){
	sheet = wb.getSheet(sheetname);
	String data = sheet.getRow(row).getCell(col).getStringCellValue();
	return data;	
}
}
