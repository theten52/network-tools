package com.theten52.tools.network.core.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

import java.util.List;
import java.util.Map;

public class XiaPiResultPrint {
    public static void print(int respCode, String respContentType, Map<String, List<String>> headers,
                             Map<String, List<String>> cookie, String result) {
        printEquals();
        printCode(respCode);
        printLine();
        printContentType(respContentType);
        printLine();
        printHeader(headers);
        printLine();
        printCookie(cookie);
        printLine();
        printResult(result);
        printEquals();
    }

    private static void printContentType(String respContentType) {
        System.out.println("resp_content_type:" + respContentType);
    }

    private static void printCookie(Map<String, List<String>> cookie) {
        System.out.println("cookie:");
        printMap(cookie);
    }

    private static void printHeader(Map<String, List<String>> headers) {
        System.out.println("header:");
        printMap(headers);
    }

    private static void printMap(Map<String, List<String>> map) {
        if (CollUtil.isNotEmpty(map)) {
            map.forEach((k, v) -> System.out.println("k[" + k + "]v[" + v + "]"));
        }
    }

    private static void printLine() {
        System.out.println("----------------------------");
    }

    private static void printEquals() {
        System.out.println("==================================================");
    }

    private static void printCode(int respCode) {
        System.out.println("resp_status_code:" + respCode);
    }

    private static void printResult(String result) {
        if (StrUtil.isNotBlank(result) && result.contains("\"error\":90309999")) {
            System.err.println("HTTP Response:❌" + result);
        } else {
            System.out.println("HTTP Response:✅" + result);
        }
    }
}
