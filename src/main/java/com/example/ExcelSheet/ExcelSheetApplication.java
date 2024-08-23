package com.example.ExcelSheet;

import com.example.ExcelSheet.entities.Cell;
import com.example.ExcelSheet.entities.CellLocation;
import com.example.ExcelSheet.entities.ExcelSheet;
import com.example.ExcelSheet.helper.CellHelper;
import com.example.ExcelSheet.services.ExcelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ExcelSheetApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ExcelSheetApplication.class, args);
		ExcelService excelService = ExcelService.getInstance();

		ExcelSheet excelSheet = new ExcelSheet(100,100);

		Cell cell1 = new Cell().setBold(true).setColor('b').setValue(5);
		Cell cell2 = new Cell().setBold(true).setColor('w').setValue(10);

		excelService.setCell(cell1,0,0,excelSheet);
		excelService.setCell(cell2,1,0,excelSheet);

		System.out.println(excelService.getCell(0,0,excelSheet));

		List cellsForAddition = List.of(new CellLocation(0,0), new CellLocation(1,0));

		System.out.println(excelService.addCellsValue(cellsForAddition,excelSheet,2,0));
		System.out.println(CellHelper.columnNumber("XXBX"));
	}

}
