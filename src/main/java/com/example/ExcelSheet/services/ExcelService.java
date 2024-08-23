package com.example.ExcelSheet.services;


import com.example.ExcelSheet.entities.Cell;
import com.example.ExcelSheet.entities.CellLocation;
import com.example.ExcelSheet.entities.ExcelSheet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class ExcelService {
    private static ExcelService INSTANCE;
    private ExcelService(){

    }

    public static ExcelService getInstance(){
        if(isNull(INSTANCE)){
            synchronized (ExcelService.class){
                INSTANCE = new ExcelService();
            }
        }
        return INSTANCE;
    }

    public Cell setCell(Cell cell, int row, int column, ExcelSheet excelSheet){

        if(row >= excelSheet.getRowSize() || column >= excelSheet.getColumnSize()) throw new RuntimeException("Dimensions are out of bound.");

        Map<Integer, Cell> rowGrid = excelSheet.getGrid().getOrDefault(row, new HashMap<>());

        rowGrid.put(column, cell);

        excelSheet.getGrid().put(row,rowGrid);

        return cell;
    }

    public Cell getCell(int row, int column, ExcelSheet excelSheet){

        if(row >= excelSheet.getRowSize() || column >= excelSheet.getColumnSize()) throw new RuntimeException("Dimensions are out of bound.");

        Map<Integer, Cell> rowGrid = excelSheet.getGrid().getOrDefault(row, null);

        if(isNull(rowGrid) || isNull(rowGrid.get(column))){
            return new Cell().setColor('w').setValue(0);
        }

        return rowGrid.get(column);
    }

    public Cell addCellsValue(List<CellLocation> cells, ExcelSheet excelSheet, int targetRow, int targetColumn){

        Cell targetCell = getCell(targetRow,targetColumn,excelSheet);

        for(CellLocation cellLocation : cells){
            Cell cell = getCell(cellLocation.getRow(), cellLocation.getColumn(),excelSheet);
            targetCell.setValue(targetCell.getValue() + cell.getValue());
        }

        setCell(targetCell,targetRow,targetColumn,excelSheet);

        return targetCell;
    }

}
