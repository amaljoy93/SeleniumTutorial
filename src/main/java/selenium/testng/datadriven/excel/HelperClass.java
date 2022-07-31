package selenium.testng.datadriven.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class HelperClass {
	private String filePath;
	private HSSFWorkbook workbook;
	private ArrayList<String> createLists;
	private Sheet sheet;
	
	public HelperClass(String filePath) {
		this.filePath = filePath;
	}
	
	private Sheet getSheet(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		workbook = new HSSFWorkbook(file);
		if (workbook.getSheet(sheetName) != null) {
			sheet  = workbook.getSheet(sheetName);
			return sheet;
		}
		return null;
	}
	
	private ArrayList<String> loadFeatureLists() throws IOException {
		createLists = new ArrayList<String>();
		String concatString = "";
		sheet = getSheet(filePath, "features");
		if (sheet != null) {
			for (Row row : sheet) {
				for (Cell cell : row) {
					
					concatString += cell.getStringCellValue()+" ";
				}
				createLists.add(concatString.strip());
				concatString = "";
			}
		}
			
		 else {
			System.out.println("sheet not found");
			System.exit(1);
			
		}
		
		return createLists;
	}
	
	public Iterator<Object[]> loadFeatureTestCases() throws IOException {
		List<Map<String,String>> lom = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		String concatString = "";
		for (String feature : loadFeatureLists()) {
			if (getSheet(filePath, feature) != null) {
				for (Row row : getSheet(filePath, feature)) {
					for (Cell cell : row) {
						concatString += cell.getStringCellValue()+"@";
					}
					String[] arr = concatString.split("@");
					map = new HashMap<String,String>();
					map.put(arr[0].strip(), arr[1]+"@"+arr[2].strip());
					lom.add(map);
					concatString = "";
				}
			}else {
				System.out.println("Sheet Not Found");
				System.exit(1);
			}
		}
		Collection<Object[]> dp = new ArrayList<Object[]>();
		for(Map<String,String> map1:lom){
            dp.add(new Object[]{map1});
        }
        return dp.iterator();
	}
}
