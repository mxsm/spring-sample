package com.github.mxsm;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author mxsm
 * @Date 2019/8/10 19:50
 * description:
 */
public class Execel {

    private static final String SQL_APPLY = "INSERT INTO bio_isolation_apply(\"id\", \"process_instance_id\", \"approve_process_instance_id\", \"task_instance_id\", \"user_id\", \"user_name\", \"approve_user_id\", \"approve_user_name\", \"company_id\", \"company_name\", \"org_id\", \"org_name\", \"position\", \"user_type_code\", \"user_type_name\", \"destination_id\", \"destination_name\", \"isolation_start_time\", \"start_point_id\", \"start_point_name\", \"approve_status\", \"remark\", \"create_user\", \"create_time\", \"modify_user\", \"modify_time\", \"tenant_id\", \"app_id\", \"deleted\", \"process_status\", \"approve_time\") VALUES (%s, '%s', '%s', '', 1159443286204166145, '%s', 1151888325801005057, '张芳菱', 1143681326958694401, '扬翔股份', 0, '', '教练', '0', NULL, %s, '%s', '%s', %s, '%s', 1, NULL, '1155668306427498497', '%s', '1155668306427498497', '%s', 1143681147589283841, 300, 'f', 0, '%s');\n";

    private static final String SQL_ISOLATION = "INSERT INTO bio_exit_entry (\"id\", \"process_instance_id\", \"task_instance_id\", \"user_id\", \"user_name\", \"isolation_start_time\", \"isolation_end_time\", \"isolation_entry_time\", \"isolation_exit_time\", \"isolation_center_id\", \"isolation_center_name\", \"bracelet_number\", \"bracelet_status\", \"arranged\", \"step_executed\", \"create_user\", \"create_time\", \"modify_user\", \"modify_time\", \"tenant_id\", \"deleted\", \"app_id\", \"process_status\") VALUES (%s, '%s', NULL, 1144435606304399361, '%s', '%s', '%s', '%s', '%s', %s, '%s', NULL, 0, 'f', 1, '1151888411578716162', '%s', '1144435606304399361', '%s', 1143681147589283841, 'f', 300, 0);\n";
    //FileInputStream fis = new FileInputStream(new File("C:\\Users\\mxsm\\Desktop\\gggg\\期中英语同学成绩 70份.xlsx"));
    public static void main(String[] args) throws Exception{

        /*String sql = String.format(SQL_APPLY,"2253226415698583553","b69aeb78-ac5e-test-aa69-fae42ad0a1d1",
                "1a58c890-ac5e-test-aa69-fae42ad0a1d1","罗金兰","1158346492387852290","团结二场,团结二场生产区","2019-06-22 16:51:00",
                "1151884220298936322","总部隔离1区,总部隔离1区隔离楼","2019-06-22 16:52:58","2019-06-22 16:57:19","2019-06-22 16:52:58");*/

       /* String  sql = String.format(SQL_ISOLATION,"2255679350072868865","9af7e0f9-b1af-test-abb4-da29186e4b24","陆映仙","2019-06-29 11:20:03","2019-06-29 11:21:03","2019-06-29 11:20:03","2019-06-29 11:21:03",
                "1151884220298936322","总部隔离1区隔离楼","2019-06-29 11:20:03","2019-06-29 11:21:00");*/
       // System.out.println(sql);
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\mxsm\\Desktop\\2019年5-8月份总部隔离中心隔离人员信息汇总表(2).xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(1);
        int size = sheet.getLastRowNum();

        int[] hour = new int[]{9,10,11,14};

       String[] sqlApply = new String[size];
       String[] sqlIsolation = new String[size];
       Map<String,String> key = new HashMap<>(size);
        Map<String,String> keyStart = new HashMap<>(size);

        for(int i = 1; i <= size; ++i) {
            String processIntanceId = "test_"+UUID.randomUUID().toString();
            String id = i+"";
            Row row = sheet.getRow(i);
            String userName = row.getCell(1).getStringCellValue();
            String startPointName = row.getCell(3).getStringCellValue();
            if(StringUtils.isEmpty(keyStart.get(startPointName))){
                keyStart.put(startPointName,""+i);
            }
            String startPointId = keyStart.get("startPointName");
            String destinationName = row.getCell(4).getStringCellValue();
            if(StringUtils.isEmpty(key.get(destinationName))){
                key.put(destinationName,""+i);
            }
            String destinationId = key.get(destinationName);
            String time = DateFormatUtils.format(row.getCell(6).getDateCellValue(),"yyyy-MM-dd "+ hour[((int)Math.random()*4)] +":30:00");

            String sqlApplyItem =  String.format(SQL_APPLY,i,processIntanceId,
                    processIntanceId,userName,destinationId,destinationName,time,
                    startPointId,startPointName,time,time,time);

            String sqlIsItem = String.format(SQL_ISOLATION,i,processIntanceId,userName,time,time,time,time,
                    startPointId,startPointName,time,time);

            sqlApply[i-1] = sqlApplyItem;
            sqlIsolation[i-1] = sqlIsItem;
            System.out.println(i);
        }
        File file = new File("C:\\Users\\mxsm\\Desktop\\人员数据.sql");

        FileWriter fw=new FileWriter(file);
        //写入中文字符时会出现乱码
        BufferedWriter  bw = new BufferedWriter(fw);
        //BufferedWriter  bw=new BufferedWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8")));

        for(String arr:sqlApply){
            if(!StringUtils.isEmpty(arr)){
                bw.write(arr);
            }
        }
        bw.write("\n\n");
        for(String arr:sqlIsolation){
            if(!StringUtils.isEmpty(arr)){
                bw.write(arr);
            }
        }
        bw.close();
        fw.close();

    }
}
