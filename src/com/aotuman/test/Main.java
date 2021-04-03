package com.aotuman.test;

import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());


        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aaa","aaa");
        System.out.println(ClassLayout.parseInstance(hashMap).toPrintable());
    }
}
