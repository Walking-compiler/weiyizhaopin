package org.glimmer.utils;

import java.util.ArrayList;
import java.util.List;

public class StringToUnits {
    public static List<String> stringToList(String input) {
        List<String> list = new ArrayList<>();
        if (input != null && !input.isEmpty()) {
            String[] array = input.split(",");
            for (String str : array) {
                list.add(str.trim()); // 去除字符串两端的空格并添加到列表中
            }
        }
        return list;
    }
}
