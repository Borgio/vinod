/**
 * 
 */
package com.poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author vinod
 *
 */
public class ExcelExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createExcelFile();
	}

	public static void createExcelFile() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("COMMERCIAL INVOICE");
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);

		int rownum = 2;
		
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 2));
		   
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(1);
		cell.setCellValue("Emmett London");
		CellStyle headerStyle = workbook.createCellStyle();
		HSSFFont headerFont = workbook.createFont();
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerFont.setFontHeightInPoints((short) 40);
		headerStyle.setFont(headerFont);
		headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellStyle(headerStyle);
		
		rownum = rownum+2;
		row = sheet.createRow(rownum);
		cell = row.createCell(0);
		cell.setCellValue("COMMERCIAL INVOICE");
		cell.setCellStyle(style);
		
		row = sheet.createRow(++rownum);
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellValue("DATE");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("28/6/16");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellValue("SENDERS VAT No.");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("563180253");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellValue("SENDER REFERENCE");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("100004303");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellValue("SHIPPER INFORMATION");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("CONSIGNEE INFORMATION");
		cell.setCellStyle(style);
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		CellStyle cs = workbook.createCellStyle();
		cs.setWrapText(true);
		//cell.setCellStyle(cs);
		cell.setCellValue("Emmett Shirts Ltd. \n380 King's Road \nLondon \nSW3 5UZ");
		
		cell = row.createCell(1);
		//cell.setCellStyle(cs);
		cell.setCellValue("Clive Parry \nSAGE (Marketing) \n2455 TELLER ROAD \nThousand Oaks, California, 91320 \nUnited States");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("CONSIGNEE CONTACT DETAILS");
		cell = row.createCell(1);
		cell.setCellValue("T: 347 571 9899");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("AGENTS WAYBILL No.");
		cell = row.createCell(1);
		cell.setCellValue("");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("PIECES");
		cell = row.createCell(1);
		cell.setCellValue("100");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("WEIGHT");
		cell = row.createCell(1);
		cell.setCellValue("200");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("WECONSIGNMENT DETAILSIGHT");
		cell = row.createCell(1);
		cell.setCellValue("");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("GOODS DESCRIPTION");
		
		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("QUANTITY");
		
		cell = row.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("UNIT VALUE");
		
		cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("TOTAL CUSTOMS VALUE");
		
		//TODO for loop with order lines
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellValue("Blue Cotton Twill");
		
		cell = row.createCell(1);
		cell.setCellValue("2");
		
		cell = row.createCell(2);
		cell.setCellValue("£ 125.00");
		
		cell = row.createCell(3);
		cell.setCellValue("£ 250.00");
		
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellValue("Blue Jean Linen");
		
		cell = row.createCell(1);
		cell.setCellValue("1");
		
		cell = row.createCell(2);
		cell.setCellValue("£ 145.00");
		
		cell = row.createCell(3);
		cell.setCellValue("£ 145.00");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellValue("Blue Jean Linen");
		
		cell = row.createCell(1);
		cell.setCellValue("1");
		
		cell = row.createCell(2);
		cell.setCellValue("£ 125.00");
		
		cell = row.createCell(3);
		cell.setCellValue("£ 125.00");
		
		row = sheet.createRow(++rownum);
		row = sheet.createRow(++rownum);
		row = sheet.createRow(++rownum);
		row = sheet.createRow(++rownum);
		row = sheet.createRow(++rownum);
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("TOTAL");
		
		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("4");
		
		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("£ 520.00");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("I CONFIRM THESE GOODS ARE NOT HAZARDOUS");
		
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("I CONFIRM THESE GOODS DO NOT REQUIRE A LICENCE");
		
		row = sheet.createRow(++rownum);
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("SIGNATURE: _________________");
		
		row = sheet.createRow(++rownum);
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("PRINT NAME: _________________");
		
		// Auto size the column widths
		for(int columnIndex = 0; columnIndex < 4; columnIndex++) {
		     sheet.autoSizeColumn(columnIndex);
		}
		
		try {
			FileOutputStream out = new FileOutputStream(new File("//Users//vinod/Desktop//test.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
