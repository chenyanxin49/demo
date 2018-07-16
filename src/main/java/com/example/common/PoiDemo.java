package com.example.common;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.domain.FXbhB;
import com.example.domain.WpStsB;
import com.example.serivce.IPoiDemoService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("importExcel")
public class PoiDemo {

    private final Logger Log = LoggerFactory.getLogger(PoiDemo.class);

    @Autowired
    private IPoiDemoService poiDemoService;

    /**
     * 批量区域数据导入
     */
    public String batchImport(File file, String fileFileName) throws IOException {
//    public String batchImport(File file, String fileFileName, String fileContentType) throws IOException {
//        Log.info("文件类型=" + fileContentType);
        List<FXbhB> stsS = new ArrayList<>();
        Log.info("文件名=" + fileFileName);

        Workbook workbook = null;
        Sheet sheet = null;
        if (fileFileName.endsWith(".xls")) {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } else if (fileFileName.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(new FileInputStream(file));
        }

        if (workbook != null) {
            sheet = workbook.getSheetAt(0);
        }
        // 读取经纬度
//        List<String> list = PoiDemo.readFileByLines("C:\\Users\\lenvo\\Desktop\\new 2.txt");

        int num = 0;
        Date date = new Date();
        Long tcd = null;
        String villNm = null;
        // 3、 读取sheet中每一行
        if (sheet != null) {
            for (Row row : sheet) {
                // 一行数据 对应 一个区域对象
                if (row.getRowNum() == 0) {
                    // 第1行 跳过
                    continue;
                }
//                int i = (int) row.getCell(0).getNumericCellValue();
                // 跳过空行
//                if (row.getCell(0) == null) {
//                        || StringUtils.isBlank(row.getCell(0).getStringCellValue())) {
//                    continue;
//                }

//                if (list != null) {
//                    String s = list.get(index);
//                    String[] lglt = s.split(",");
//                    String lgtd = lglt[0].substring(0, 10);
//                    String lttd = lglt[1].substring(0, 9);
//                    System.out.println("lgtd = " + lgtd + "lttd = " + lttd);
                    FXbhB sb = new FXbhB();

                Cell ttcd = row.getCell(0);
                if (ttcd != null){
                    tcd = (long) ttcd.getNumericCellValue();
                }
                    sb.setTowncd(String.valueOf(tcd));

                Cell vnm = row.getCell(1);
                if (vnm != null){
                    villNm = vnm.getStringCellValue();
                }
                    sb.setVillnm(villNm);
                    sb.setXbh(row.getCell(2).getStringCellValue());
                    sb.setArea(row.getCell(3).getNumericCellValue());
                    sb.setStcd(String.valueOf((int) row.getCell(4).getNumericCellValue()));
                    sb.setUseType(String.valueOf((int) row.getCell(5).getNumericCellValue()));
                    sb.setForOwn(String.valueOf((int) row.getCell(6).getNumericCellValue()));
                    sb.setForUse(String.valueOf((int) row.getCell(7).getNumericCellValue()));
                    sb.setTreeOwn(String.valueOf((int) row.getCell(8).getNumericCellValue()));
                    sb.setTreeUse(String.valueOf((int) row.getCell(9).getNumericCellValue()));
                Cell cell = row.getCell(10);
                String v = null;
                if (cell != null){
                    v = cell.getStringCellValue();
                }
                    sb.setTreeOwner(v);
                int year = (int) row.getCell(11).getNumericCellValue();
                if (year == 0){
                    year = 2017;
                }
                sb.setFoundYear(String.valueOf(year));
                sb.setModtm(date);
//                    sb.setLgtd(Double.parseDouble(lgtd));
//                    sb.setLttd(Double.parseDouble(lttd));
//                System.out.println("file = [" + sb );
                num++ ;
//                if (num == 2){
//                    return null;
//                }
                    stsS.add(sb);
//                }

            }
            // 调用业务层
            poiDemoService.saveBatch(stsS);
        }
        return null;
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static List<String> readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        List<String> list = new ArrayList<>();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
                line++;
                list.add(tempString);
            }
            reader.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
        }
    }

}
