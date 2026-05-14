package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class Lab8Application {

    public static void main(String[] args) {

        readExcel("laborator8_input.xlsx");

        copyExcelWithAverage(
                "laborator8_input.xlsx",
                "laborator8_output2.xlsx"
        );

        copyExcelWithFormula(
                "laborator8_input.xlsx",
                "laborator8_output3.xlsx"
        );
    }

    public static void readExcel(String fileName) {

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                for (Cell cell : row) {

                    if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    }

                    else if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + "\t");
                    }
                }

                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
    public static void copyExcelWithAverage(String inputFileName, String outputFileName) {

        try (FileInputStream fis = new FileInputStream(inputFileName);
             Workbook inputWorkbook = new XSSFWorkbook(fis);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Rezultate");

            for (int i = 0; i <= inputSheet.getLastRowNum(); i++) {
                Row inputRow = inputSheet.getRow(i);
                if (inputRow == null) continue;

                Row outputRow = outputSheet.createRow(i);

                int lastCell = inputRow.getLastCellNum();

                for (int j = 0; j < lastCell; j++) {
                    Cell inputCell = inputRow.getCell(j);
                    Cell outputCell = outputRow.createCell(j);

                    if (inputCell == null) continue;

                    switch (inputCell.getCellType()) {
                        case STRING:
                            outputCell.setCellValue(inputCell.getStringCellValue());
                            break;
                        case NUMERIC:
                            outputCell.setCellValue(inputCell.getNumericCellValue());
                            break;
                        default:
                            outputCell.setCellValue("");
                    }
                }

                Cell mediaCell = outputRow.createCell(lastCell);

                if (i == 0) {
                    mediaCell.setCellValue("Media");
                } else {
                    double nota1 = inputRow.getCell(lastCell - 3).getNumericCellValue();
                    double nota2 = inputRow.getCell(lastCell - 2).getNumericCellValue();
                    double nota3 = inputRow.getCell(lastCell - 1).getNumericCellValue();

                    mediaCell.setCellValue((nota1 + nota2 + nota3) / 3.0);
                }
            }

            for (int i = 0; i < 10; i++) {
                outputSheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(outputFileName)) {
                outputWorkbook.write(fos);
            }

            System.out.println("Fisierul " + outputFileName + " a fost creat corect.");

        } catch (IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }

    public static void copyExcelWithFormula(String inputFileName,
                                            String outputFileName) {

        try (FileInputStream fis = new FileInputStream(inputFileName);
             Workbook inputWorkbook = new XSSFWorkbook(fis);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Rezultate");

            for (int i = 0; i <= inputSheet.getLastRowNum(); i++) {

                Row inputRow = inputSheet.getRow(i);
                if (inputRow == null) continue;

                Row outputRow = outputSheet.createRow(i);

                int lastCell = inputRow.getLastCellNum();

                for (int j = 0; j < lastCell; j++) {

                    Cell inputCell = inputRow.getCell(j);
                    Cell outputCell = outputRow.createCell(j);

                    if (inputCell == null) continue;

                    switch (inputCell.getCellType()) {

                        case STRING:
                            outputCell.setCellValue(
                                    inputCell.getStringCellValue()
                            );
                            break;

                        case NUMERIC:
                            outputCell.setCellValue(
                                    inputCell.getNumericCellValue()
                            );
                            break;

                        default:
                            outputCell.setCellValue("");
                    }
                }

                Cell formulaCell = outputRow.createCell(lastCell);

                if (i == 0) {
                    formulaCell.setCellValue("Media");
                }

                else {
                    int excelRow = i + 1;

                    String formula =
                            "AVERAGE(D" + excelRow +
                                    ":F" + excelRow + ")";

                    formulaCell.setCellFormula(formula);
                }
            }

            for (int i = 0; i < 10; i++) {
                outputSheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos =
                         new FileOutputStream(outputFileName)) {

                outputWorkbook.write(fos);
            }

            System.out.println(
                    "Fisierul " + outputFileName +
                            " a fost creat."
            );

        } catch (IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}