package Util;

import com.alibaba.fastjson.JSONObject;

public class ResultSetUtil {
    public static JSONObject result(String res,String msg){
        JSONObject result=new JSONObject();
        result.put("result",res);
        result.put("msg",msg);
        return result;
    }
}
