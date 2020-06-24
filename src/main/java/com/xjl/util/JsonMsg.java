package com.xjl.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:xjl
 * @date:2020/5/24 22:11
 */
public class JsonMsg {
    private  int code;
    private  String msg;
    private Map<String,Object> extendInfo=new HashMap<String, Object>();

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

    public Map<String, Object> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Map<String, Object> extendInfo) {
        this.extendInfo = extendInfo;
    }
    public  static  JsonMsg success(){
        JsonMsg res=new JsonMsg();
        res.setCode(100);
        res.setMsg("操作成功!");
        return  res;
    }
    public  static  JsonMsg fail(){
        JsonMsg res=new JsonMsg();
        res.setCode(200);
        res.setMsg("操作失败!");
        return  res;
    }

    public JsonMsg addInfo(String key,Object object){
        this.extendInfo.put(key, object);
        return  this;
    }
}