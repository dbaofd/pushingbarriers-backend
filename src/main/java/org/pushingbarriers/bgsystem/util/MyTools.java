package org.pushingbarriers.bgsystem.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyTools {
    public static String md5Password(String password) {
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }

    public static List<String> getThisWeekDates() {
        Date date = new Date();
        List<String> thisWeekDates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // set the first day in a week, here we set MONDAY as the first one.
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        for (int i = 0; i < cal.getFirstDayOfWeek() + 6 - day + 1; i++) {
            thisWeekDates.add(sdf.format(cal.getTime()));
            cal.add(Calendar.DATE, 1);
        }
        return thisWeekDates;
    }

    public static List<String> getNextWeekDates(){
        List<String> nextWeekDates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(getNextWeekMonday());
        // set the first day in a week, here we set MONDAY as the first one.
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        for (int i = 0; i < 7; i++) {
            nextWeekDates.add(sdf.format(cal.getTime()));
            cal.add(Calendar.DATE, 1);
        }
        return nextWeekDates;
    }

    public static Date getLastWeekSunday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday());
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date getThisWeekMonday() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // set the first day in a week, here we set MONDAY as the first one.
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // get the day of this Date in this week
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if(day==1){//cal.get(Calendar.DAY_OF_WEEK) if the day is Sunday, the returned value is 1, 2 for Monday
            //7 for Saturday. cal.getFirstDayOfWeek() is 2, if the day is Sunday, 2-1=1, then bug occurs when get this week Monday.
            //so set day value to 8 can solve the problem.
            day=8;
        }
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static Date getThisWeekSunday() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // set the first day in a week, here we set MONDAY as the first one.
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // get the day of this Date in this week
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if(day==1){
            day=8;
        }
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() + 6 - day);
        return cal.getTime();
    }

    public static Date getNextWeekMonday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday());
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

    public static Date getNextWeekTuesday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday());
        cal.add(Calendar.DATE, 8);
        return cal.getTime();
    }

    public static Date getNextWeekWednesday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday());
        cal.add(Calendar.DATE, 9);
        return cal.getTime();
    }

    public static Date getNextWeekThursday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday());
        cal.add(Calendar.DATE, 10);
        return cal.getTime();
    }

    public static Date getNextWeekFriday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday());
        cal.add(Calendar.DATE, 11);
        return cal.getTime();
    }

    public static Date getNextWeekSunday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekSunday());
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

    public static ResponseEntity<FileSystemResource> exportImg(String imgPath, String imgName) {
        if(imgName!=null) {
            File file = new File(imgPath, imgName);
            if (file.exists()) {
                if (file == null) {
                    return null;
                }
                HttpHeaders headers = new HttpHeaders();
                headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
                headers.add("Content-Disposition", "attachment; filename=" + file.getName());
                headers.add("Pragma", "no-cache");
                headers.add("Expires", "0");
                headers.add("Last-Modified", new Date().toString());
                headers.add("ETag", String.valueOf(System.currentTimeMillis()));
                return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream")).body(new FileSystemResource(file));

            }
        }
        return null;
    }

    public static void saveImg(MultipartFile img, String imgPath, String imgName){
        try {
            //获取输出流
            OutputStream os=new FileOutputStream(imgPath+imgName);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=img.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteImg(String imgPath, String imgName){
        File file = new File(imgPath+imgName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("delete " + imgPath+imgName + " successfully!");
            } else {
                System.out.println("delete" + imgPath+imgName + " failed!");
            }
        } else {
            System.out.println(imgPath+imgName + " doesn't exist!！");
        }
    }
}
