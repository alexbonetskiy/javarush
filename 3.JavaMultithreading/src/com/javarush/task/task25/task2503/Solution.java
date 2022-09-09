package com.javarush.task.task25.task2503;

/* 
Свой enum
*/

import java.util.Arrays;

public class Solution {
    /**
     * Output:
     * <p/>
     * Available Amount
     * Account Number
     * Bank Name
     * --------------------
     * Available Amount
     * Bank Name
     */
    public static void main(String[] args) {

        Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName);
        System.out.println(Arrays.toString(Column.getRealOrder()));
        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }
        System.out.println(Arrays.toString(Column.getRealOrder()));
        System.out.println("--------------------");
        Column.AccountNumber.hide();
        System.out.println(Arrays.toString(Column.getRealOrder()));
        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }
    }
}
