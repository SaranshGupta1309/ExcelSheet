package com.example.ExcelSheet.helper;

public class CellHelper {

    public static int columnNumber(String column){
        int ans = 0;
        int right = column.length() - 1;
        int curr = 0;

        while(right >= 0){
            ans += (column.charAt(right) - 'A' + 1)*Math.pow(26, curr);
            curr++;
            right--;
        }
        return ans;
    }
}
