package org.pushingbarriers.bgsystem.util;

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

    public static Date getThisWeekMonday() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // set the first day in a week, here we set MONDAY as the first one.
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // get the day of this Date in this week
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static Date getNextWeekMonday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday());
        cal.add(Calendar.DATE, 7);
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
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() + 6 - day);
        return cal.getTime();
    }

    public static Date getNextWeekSunday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekSunday());
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

}
