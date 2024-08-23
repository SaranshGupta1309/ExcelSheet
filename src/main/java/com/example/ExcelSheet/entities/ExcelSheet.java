package com.example.ExcelSheet.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)

public class ExcelSheet {
    private Map<Integer, Map<Integer, Cell>>grid;
    private int rowSize;
    private int columnSize;

    public ExcelSheet(int rowSize, int columnSize){
        this.grid = new HashMap<>();
        this.rowSize = rowSize;
        this.columnSize = columnSize;
    }

}
