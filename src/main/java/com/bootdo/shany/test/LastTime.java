package com.bootdo.shany.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LastTime {

	static int AllTime[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
		int year = Integer.parseInt((String) nowTime.subSequence(0, 4));
		int month = Integer.parseInt((String) nowTime.subSequence(5, 7));
		int day = Integer.parseInt((String) nowTime.subSequence(8, 10));
		if(year==2017){
			int num=change2017(month,day);
			System.out.println(num);
			System.out.println(5051-num);
			//5051=14*365-2*31+3
		}
		else if(year==2018){
			int num=change2018(month,day);
			System.out.println(num);
			System.out.println(5051-num);
		}
		int aa=14*365-2*31+3;
		System.out.println(aa);
	}
	
	public static int change2017(int month,int day){
		int num_Time=0;
		for(int i=month-1;i<12;i++){
			num_Time+=AllTime[i];
		}
		for(int i=0;i<6;i++){
			num_Time+=AllTime[i];
		}
		return num_Time-day;	
	}
	
	public static int change2018(int month,int day){
		int num_Time=0;
		for(int i=month-1;i<6;i++){
			num_Time+=AllTime[i];
		}
		return num_Time-day;	
	}
	
}
