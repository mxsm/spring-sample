package com.github.mxsm;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author mxsm
 * @Date 2019/8/10 19:50
 * description:
 */
public class Execel {

    public static void main(String[] args) throws Exception{


        FileInputStream fis = new FileInputStream(new File("C:\\Users\\mxsm\\Desktop\\gggg\\少儿医保学校缴费人员名单 高中 3573人.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int size = sheet.getLastRowNum();

        FileInputStream fis1 = new FileInputStream(new File("C:\\Users\\mxsm\\Desktop\\gggg\\高三（21）班 学生信息统计表.xlsx"));
        XSSFWorkbook workbook1 = new XSSFWorkbook(fis1);
        XSSFSheet sheet1 = workbook1.getSheetAt(0);
        int size1 = sheet1.getLastRowNum();

        for(int i = 3; i < 51;++i){
            Row row = sheet1.getRow(i);
            String name = row.getCell(1).getStringCellValue();
            for(int j = 1; j < size; ++j){
                Row row1 = sheet.getRow(j);
                String name1 = row1.getCell(0).getStringCellValue();
                if(StringUtils.equals(StringUtils.trim(name),StringUtils.trim(name1))){
                    //证件号码
                    row.createCell(2).setCellValue(row1.getCell(3).getStringCellValue());
                    //所在年级
                    row.createCell(3).setCellValue(row1.getCell(6)==null?"":row1.getCell(6).getStringCellValue());
                    //所在班
                    row.createCell(4).setCellValue(row1.getCell(7)==null?"":row1.getCell(7).getStringCellValue());
                    //监护人1姓名
                    row.createCell(5).setCellValue(row1.getCell(8)==null?"":row1.getCell(8).getStringCellValue());
                    //监护人1证件号码
                    row.createCell(6).setCellValue(row1.getCell(9)==null?"":row1.getCell(9).getStringCellValue());
                    //监护人1手机号码
                    row.createCell(7).setCellValue(row1.getCell(10)==null?"":row1.getCell(10).getStringCellValue());
                    //监护人2姓名
                    row.createCell(8).setCellValue(row1.getCell(11)==null?"":row1.getCell(11).getStringCellValue());
                    //监护人2证件号码
                    row.createCell(9).setCellValue(row1.getCell(12)==null?"":row1.getCell(12).getStringCellValue());
                    //监护人2手机号码
                    row.createCell(10).setCellValue(row1.getCell(13)==null?"":row1.getCell(13).getStringCellValue());
                    break;
                }
            }

        }

        workbook1.write(new FileOutputStream(new File("C:\\Users\\mxsm\\Desktop\\gggg\\高三21班学生信息统计表.xlsx")));


        /*for(int i = 2; i <= size; ++i) {
            Row row = sheet.getRow(i);
            String stName = row.getCell(1).getStringCellValue();
            for(int j = 2; j <= size1; ++j) {
                Row row1 = sheet1.getRow(j);
                String stName1 = row1.getCell(2).getStringCellValue();
                if(StringUtils.equals(stName1, stName)) {

                    row.createCell(22).setCellValue(-(row.getCell(2).getNumericCellValue()-row1.getCell(3).getNumericCellValue()));
                    row.createCell(23).setCellValue(-(row.getCell(5).getNumericCellValue()-row1.getCell(4).getNumericCellValue()));
                    row.createCell(24).setCellValue(-(row.getCell(8).getNumericCellValue()-row1.getCell(5).getNumericCellValue()));
                    row.createCell(25).setCellValue(-(row.getCell(10).getNumericCellValue()-row1.getCell(6).getNumericCellValue()));
                    row.createCell(26).setCellValue(-(row.getCell(13).getNumericCellValue()-row1.getCell(7).getNumericCellValue()));
                    row.createCell(27).setCellValue(-(row.getCell(16).getNumericCellValue()-row1.getCell(8).getNumericCellValue()));
                    row.createCell(28).setCellValue(-(row.getCell(19).getNumericCellValue()-row1.getCell(11).getNumericCellValue()));
                    row.createCell(29).setCellValue(-(row.getCell(20).getNumericCellValue()-row1.getCell(13).getNumericCellValue()));
                    row.createCell(30).setCellValue(-(row.getCell(21).getNumericCellValue()-row1.getCell(12).getNumericCellValue()));
                    break;
                }
            }
        }
        workbook.write(new FileOutputStream(new File("C:\\Users\\mxsm\\Desktop\\gggg\\入学日语同学成绩 70份1.xlsx")));*/
    }
}
