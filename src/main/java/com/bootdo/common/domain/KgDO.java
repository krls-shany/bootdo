package com.bootdo.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * KgDO
 * @Date 2019年9月19日 15:08:53
 */
public class KgDO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String resultCode;
    private String resultMessage;
    private Date createTime;
    private String result;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "KgDO [createTime=" + createTime + ", result=" + result + ", resultCode=" + resultCode
                + ", resultMessage=" + resultMessage + "]";
    }

    public KgDO(String resultCode, String resultMessage, Date createTime, String result) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.createTime = createTime;
        this.result = result;
    }

    public KgDO() {
    }
    
}