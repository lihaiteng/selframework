package com.lht.framework;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date 2018/10/16 0016
 */

public class Contacts {
    public static Map<String,String> targetActivitys =  new LinkedHashMap<>();
    static {
        targetActivitys.put("UI", "/ui/main");
        targetActivitys.put("四大组件", "/fourcomponent/main");
    }
}
