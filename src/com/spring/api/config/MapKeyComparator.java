package com.spring.api.config;

import java.util.Comparator;

/**
 * 对map进行key排序
 * @author Administrator
 *
 */
public class MapKeyComparator implements Comparator<Double>{

    @Override
    public int compare(Double str1, Double str2) {

        return str1.compareTo(str2);
    }
}