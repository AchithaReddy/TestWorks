package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook xBook;
	private static XSSFSheet xSheet;
	private static XSSFCell xCell;
	private static XSSFRow xRow;
	
	public static void setExcel(String Path, String Sheet){
		
		try {
			FileInputStream xfile = new FileInputStream(Path);
			xBook = new XSSFWorkbook (xfile);
			xSheet = xBook.getSheet(Sheet);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
	public static String getCellValue(int iRow, int iCell){
		    
		DataFormatter formatter = new DataFormatter();
		xCell = xSheet.getRow(iRow).getCell(iCell);
		String sValue = formatter.formatCellValue(xCell);
		return sValue;
	
	}
	
	@SuppressWarnings({ "static-access", "deprecation" })
	public static void setCellValue(String sResult, int iRow, int iCell){
		
		try {
			xRow = xSheet.getRow(iRow);
			xCell = xRow.getCell(iCell, xRow.RETURN_BLANK_AS_NULL);
			if (xCell == null)
				{
				  xCell = xRow.createCell(iCell);
				  xCell.setCellValue(sResult);
				}
			else
				xCell.setCellValue(sResult);
		
			FileOutputStream xFileOut = new FileOutputStream(Constants.xcelPath+Constants.xcelfile);
			xBook.write(xFileOut);
			xFileOut.flush();
			xFileOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
