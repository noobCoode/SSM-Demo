package Util;

import com.alibaba.fastjson.JSONObject;

public class ResultPackage {
    private int code;
    private String msg;
    private String des;
    private JSONObject res;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public JSONObject getRes() {
        return res;
    }

    public void setRes(JSONObject res) {
        this.res = res;
    }

    private ResultPackage(int code, String msg, String des, JSONObject res){
        this.code=code;
        this.msg=msg;
        this.des=des;
        this.res=res;
    }

    private static ResultPackage successPackage(JSONObject info){
        return new ResultPackage(0,"SUCCESS","无",info);
    }

    private static ResultPackage failPackage(int code,String des,JSONObject info){
        return new ResultPackage(code,"FAIL",des,info);
    }

     public static ResultPackage generateResult(int code,String des,JSONObject res){
        if(code==0){
             return ResultPackage.successPackage(res);
        }else{
            return ResultPackage.failPackage(code,des,res);
        }
     }
}
