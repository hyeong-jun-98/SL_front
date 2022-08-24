package javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// 자바 프로그램에서 excel 파일 제어하기	
public class ExcelManager {

	FileInputStream fis; // 파일 스트림
	XSSFWorkbook workbook; // 엑셀파일
	XSSFSheet sheet; // 시트

	public ExcelManager() {
		try {
			fis = new FileInputStream("C:/Users/SL/eclipse-workspace/javaseapp/data/상품.xlsx");
			System.out.println(fis);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // 첫번째 시트

			Iterator rowIt = sheet.iterator();
			
			// iterator 안의 요소 중 다음 요소를 판단한다.. 있으면 true, 없으면 false
			while (rowIt.hasNext()) {
				rowIt.next(); // 다음 요소 접근

				Row row = (Row) rowIt.next();

				// 하나의 row에 포함된 cell 들을 Iterator를 통해 얻어온다.
				Iterator<Cell> cellIt = row.cellIterator(); // row라고 안하고 cell이라고 한다.
				
				while(cellIt.hasNext()) {		// 셀의 개수만큼
					Cell cell = cellIt.next();
					if(cell.getCellType() ==CellType.STRING ) {	// produc_name
						System.out.println(cell.getStringCellValue());
					} else if(cell.getCellType() ==CellType.NUMERIC) {	// price
						System.out.println(cell.getNumericCellValue());
					} else if( cell.getCellType() ==CellType.STRING) {	// brand
						System.out.println(cell.getStringCellValue());
					}
					
				}
				System.out.println("");

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {

		new ExcelManager();

	}
}
