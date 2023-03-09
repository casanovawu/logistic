package com.suzz.platform.util;

/**
 * @author subo
 * @date 2022/5/20 0:42
 **/
public class LangContent {

    private static ThreadLocal<String> LANG_LOCAL = new ThreadLocal<>();

    public static void setLang(String lang) {
        LANG_LOCAL.set(lang);
    }

    public static String getLang(){
       return LANG_LOCAL.get();
    }
    public static void cleanLang(){
        LANG_LOCAL.remove();
    }
}
