package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public final class ExcelUtility {

    private ExcelUtility() {
    }

    public static Object[][] getData(
            String filePath,
            String sheetName) {

        try (
            FileInputStream input =
                    new FileInputStream(filePath);

            Workbook workbook =
                    WorkbookFactory.create(input)
        ) {

            Sheet sheet =
                    workbook.getSheet(sheetName);

            if (sheet == null) {

                throw new IllegalArgumentException(
                        "Sheet not found: "
                                + sheetName);
            }

            DataFormatter formatter =
                    new DataFormatter();

            int firstDataRow =
                    sheet.getFirstRowNum() + 1;

            int lastDataRow =
                    sheet.getLastRowNum();

            int columns =
                    sheet.getRow(
                            sheet.getFirstRowNum())
                            .getLastCellNum();

            java.util.List<Object[]> rows =
                    new java.util.ArrayList<>();

            for (int r = firstDataRow;
                 r <= lastDataRow;
                 r++) {

                Row row =
                        sheet.getRow(r);

                if (row == null ||
                        row.getCell(0) == null ||
                        formatter.formatCellValue(
                                row.getCell(0))
                                .isBlank()) {

                    continue;
                }

                Object[] data =
                        new Object[columns];

                for (int c = 0;
                     c < columns;
                     c++) {

                    Cell cell =
                            row.getCell(c);

                    data[c] =
                            cell == null
                                    ? ""
                                    : formatter
                                        .formatCellValue(cell);
                }

                rows.add(data);
            }

            return rows.toArray(
                    new Object[0][]);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to read Excel file: "
                            + filePath,
                    e);
        }
    }
}