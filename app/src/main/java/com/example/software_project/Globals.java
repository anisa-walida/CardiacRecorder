package com.example.software_project;

import android.content.SharedPreferences;
import android.util.Log;

public class Globals {
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPrefEditor;

    public static class ErrorManagement{
        public static enum ET{ERROR, WARNING, INFO};
        public static void LOG(String msg, ET type){
            if (type == ET.ERROR){
                Log.e("_LOG_", msg.toString());
            }else if (type == ET.INFO){
                Log.i("_LOG_", msg.toString());
            }if (type == ET.WARNING){
                Log.w("_LOG_", msg.toString());
            }
        }

        public static void ELOG(Exception e){
            Log.e("__TAG__",e.getClass().getName()+":"+e.getCause());
        }
    }
}
