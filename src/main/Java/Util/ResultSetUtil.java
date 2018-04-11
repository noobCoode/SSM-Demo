package Util;

import com.alibaba.fastjson.JSONObject;

public class ResultSetUtil {
    public static JSONObject result(String res){
        JSONObject result=new JSONObject();
        result.put("result",res);
        return result;
    }
}
