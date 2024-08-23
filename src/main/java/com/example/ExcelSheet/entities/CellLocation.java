package com.example.ExcelSheet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class CellLocation {
    private Integer row;
    private Integer column;
}
