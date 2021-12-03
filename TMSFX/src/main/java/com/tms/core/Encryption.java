package com.tms.core;

import org.apache.commons.codec.digest.DigestUtils;

public class Encryption {

    public static String MD5Hash(String str) {
        return DigestUtils.md5Hex(DigestUtils.md5Hex((str))).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(MD5Hash("u"));
    }
}
