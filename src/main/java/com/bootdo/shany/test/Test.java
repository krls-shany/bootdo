package com.bootdo.shany.test;

import com.bootdo.shany.util.AudioUtil;

import java.util.Calendar;

public class Test{

//    public static void testAudioUtil(){
//        AudioUtil.audioPlayer("我是山羊");
//    }
//
//    public static void main(String[] args) {
//        testAudioUtil();
//    }
//
//
//
//    public static void main(String args[]){
//        String ss="Êý¾Ý×Öµä";
//        ss=new String(ss.getBytes("utf-8"),"UTF-8");
//        System.out.println(ss);
//
//    }


    public static void main(String ... args){
//        int a=Integer.parseInt("1");
//        System.out.println(a);
//        new StringBuffer("asdsa").reverse();
//        new String("as".getBytes("utf-8"),"gbk");
//        Calendar cal=Calendar.getInstance();
//        cal.get(Calendar.YEAR);
//        throw new Exception(e);
//
//        try{
//
//        }catch (Exception e){
//        }
        getLastTime();
    }

    public static String getLastTime(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(2021,12,24);
        System.out.println("time="+calendar.getTime());
        return null;
    }

}