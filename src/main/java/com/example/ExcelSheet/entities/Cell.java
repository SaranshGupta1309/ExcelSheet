package com.example.ExcelSheet.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Cell {
    private Integer value;
    private char color;
    private boolean isBold;
}
