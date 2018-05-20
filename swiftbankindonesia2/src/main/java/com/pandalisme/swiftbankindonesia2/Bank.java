package com.pandalisme.swiftbankindonesia2;

/**
 * Created by AHMAD KARTUBI on 21/05/2018.
 * PANDALISME.COM || kartubi1@gmail.com
 */
public class Bank {

    private String mCode, mName, mId;

    public Bank(){

    }

    public Bank(String id, String name, String code){
        this.mId = id;
        this.mCode = code;
        this.mName = name;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }
}
