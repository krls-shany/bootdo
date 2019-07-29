package com.bootdo.common.utils;

/**
 * ShanyUtils
 */
public class ShanyUtils {

    /**
     * 是否是QQ号
     * @param id 要检测的号码
     * @return
     */
    public static Boolean isQQ(String id) {
        if (id.matches("^[1-9][0-9]{4,11}$"))
            return true;
        return false;
    }

    /**
     * 是否是手机号
     * @param phone 要检测的号码
     * @return
     */
    public static Boolean isPhone(String phone) {
        if (phone.matches("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$"))
            return true;
        return false;
    }

    /**
     * 是否是中国非法身份证
     * @param id  要检测的证件号
     * @return
     */
    public static Boolean isIDCard(String id) {
        if (id.matches("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$"))
            return true;
        return false;
    }

    
    public static void main(String[] args) {
        System.out.println(isQQ("0803881823"));
    }

}