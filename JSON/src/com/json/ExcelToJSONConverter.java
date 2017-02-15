package com.json;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;



public class ExcelToJSONConverter {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		String excelFilePath = "C:\\Users\\njai49\\Documents\\Json\\sampleExcel.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			
		Workbook workbook =  new XSSFWorkbook(inputStream); 

		// Get the first Sheet.
		Sheet sheet = workbook.getSheetAt( 0 );
		
		    // Start constructing JSON.
		    JSONObject json = new JSONObject();

		    // Iterate through the rows.
		    JSONArray rows = new JSONArray();
		    
		    int firstRowNumber = 0;
		    Row firstRow = sheet.getRow(firstRowNumber);
	        String[] columnHeading = new String[firstRow.getLastCellNum()];
	        int columnIndex = 0;
	        for (Cell cell : firstRow) {
				columnHeading[columnIndex++] = cell.getStringCellValue();
				//System.out.println(columnHeading[columnIndex-1]);
			}
	        
		
		    		    
		    for ( Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext(); )
		    {
		    	
		        Row row = rowsIT.next();
		        JSONObject jRow = new JSONObject();

		        // Iterate through the cells.
		        JSONObject cells;
		        
		        if (row.getRowNum() != firstRowNumber) {
					cells = new JSONObject();
					for (Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext();) {
						Cell cell = cellsIT.next();
						String val = "";
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							val = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							val = Double.toString(cell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							val = Boolean.toString(cell.getBooleanCellValue());
							break;
						case Cell.CELL_TYPE_FORMULA:
							cell.getCellFormula();
							break;
						}
						cells.put(columnHeading[cell.getColumnIndex()], val);
						
				       
					} 
					jRow.put( "recipient", cells );
					rows.put( jRow );
				}
				
		    }

		    // Create the JSON.
		    json.put( "recipientsData", rows );
		    System.out.println( json.toString());
		    workbook.close();
	}
	
	
	
}
