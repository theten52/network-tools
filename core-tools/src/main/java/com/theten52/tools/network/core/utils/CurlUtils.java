package com.theten52.tools.network.core.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CurlUtils {
    /**
     * this code copy and update from {@link com.roxstudio.utils.CUrl.Util}
     */
    private final static class Util {
        public static <K, V, M extends Map<K, V>> M mapPut(M map, Object... keyValuePairs) {
            if ((keyValuePairs.length & 1) != 0)
                throw new IllegalArgumentException("the number of keyValuePairs arguments must be odd");
            for (int i = 0, n = keyValuePairs.length; i < n; i += 2) {
                map.put((K) keyValuePairs[i], (V) keyValuePairs[i + 1]);
            }
            return map;
        }
    }

    /**
     * this code copy and update from {@link com.roxstudio.utils.CUrl#optMap}
     */
    private static final Map<String, Integer> optMap = Util.mapPut(new LinkedHashMap<String, Integer>(),
            "-E", 32,
            "--cert", 32,                    // <certificate[:password]> Client certificate file and password
            "--compressed", 1,                // Request compressed response (using deflate or gzip)
            "--connect-timeout", 2,        // SECONDS  Maximum time allowed for connection
            "-b", 3,
            "--cookie", 3,                    // STRING/FILE  Read cookies from STRING/FILE (H)
            "-c", 4,
            "--cookie-jar", 4,                // FILE  Write cookies to FILE after operation (H)
            "-d", 5,
            "--data", 5,                    // DATA	 HTTP POST data (H)
            "--data-ascii", 5,                // DATA	 HTTP POST ASCII data (H)
            "--data-raw", 51,                // DATA	 HTTP POST raw data (H)
            "--data-binary", 52,            // DATA	 HTTP POST binary data (H)
            "--data-urlencode", 53,        // DATA	 HTTP POST data url encoded (H)
            "-D", 6,
            "--dump-header", 6,            // FILE  Write the headers to FILE
            "-F", 7,
            "--form", 7,                    // CONTENT  Specify HTTP multipart POST data (H)
            "--form-string", 71,            // STRING  Specify HTTP multipart POST data (H)
            "-G", 8,
            "--get", 8,                    // Send the -d data with a HTTP GET (H)
            "-H", 10,
            "--header", 10,                // LINE   Pass custom header LINE to server (H)
            "-I", 11,
            "--head", 11,                    // Show document info only
//			"--ignore-content-length", 12, // Ignore the HTTP Content-Length header
            "-k", 31,
            "--insecure", 31,                // Allow insecure server connections when using SSL
            "-L", 13,
            "--location", 13,                // Follow redirects (H)
            "-m", 14,
            "--max-time", 14,                // SECONDS  Maximum time allowed for the transfer
//			"--no-keepalive", 15, 			// Disable keepalive use on the connection
            "-o", 16,
            "--output", 16,                // FILE   Write to FILE instead of stdout
            "-x", 17,
            "--proxy", 17,                    // [PROTOCOL://]HOST[:PORT]  Use proxy on given port
            "-U", 18,
            "--proxy-user", 18,            // USER[:PASSWORD]  Proxy user and password
            "-e", 19,
            "--referer", 19,                // Referer URL (H)
            "--retry", 20,                    // NUM   Retry request NUM times if transient problems occur
            "--retry-delay", 21,            // SECONDS  Wait SECONDS between retries
            "--retry-max-time", 22,        // SECONDS  Retry only within this period
            "-s", 23,
            "--silent", 23,                // Silent mode (don't output anything)
            "--stderr", 24,                // FILE   Where to redirect stderr (use "-" for stdout)
            "-u", 28,
            "--user", 28,                    // USER[:PASSWORD]  Server user and password
            "--url", 25,                    // URL	   URL to work with
            "-A", 26,
            "--user-agent", 26,            // STRING  Send User-Agent STRING to server (H)
            "-X", 27,
            "--request", 27,                // COMMAND  Specify request command to use
            "--x-max-download", 29,            // BYTES Maximum bytes allowed for the download
            "--x-tags", 30,                    // DATA extra key-value pairs, storage only
            "", 0 // placeholder
    );

    /**
     * 解析 postman、Chrome、Charles 导出的curl.
     *
     * @param curl postman、Chrome 或 Charles 导出的curl.
     * @return 可以参数的数组
     */
    public static String[] resolver(String curl) {
        if (curl == null || "".equals(curl)) {
            throw new IllegalArgumentException("curl can't be empty!");
        }

        List<String> opts = new ArrayList<>();//记录所有的curl参数选项（包括字符串“curl”）。
        List<Character> currentOptCharArray = new ArrayList<>();//记录当前处理的参数选项的字符集合。

        char spaceDelimiter = ' ';//空格分隔符。postman、Chrome、Charles 都会将其用作分隔符。
        char singleQuoteDelimiter = '\'';//单引号分隔符。postman、Chrome 会将其用作分隔符。
        char doubleQuoteDelimiter = '"';//双引号分隔符。Charles 会将其用作分隔符。

        //当前使用的分割符，它可以为空格单引号或者双引号。当单引号出现时，它匹配下一个单引号，两单引号之间的空格不能作为分隔符。双引号同理。
        char currentDelimiter = spaceDelimiter;

        char previousChar = ' ';//上一个字符，如果上一个字符时‘\’,则当前字符为分隔符时也不结束当前opt的处理，而是将这个分隔符当成普通字符处理

        char[] charCurl = curl.toCharArray();

        for (char c : charCurl) {
            //当前不活跃的分隔符，当“当前使用的分隔符currentDelimiter”为spaceDelimiter时，其为singleQuoteDelimiter。否则相反。
            char[] anotherDelimiterChar = getAnotherDelimiterChar(currentDelimiter, spaceDelimiter, singleQuoteDelimiter, doubleQuoteDelimiter);

            //当前字符为分隔符时，可能为某个参数选择的开始或结束部分。
            //这里不区分是参数选项的开始或结束部分，统一将其作为一个参数选项放到最终结果中。
            if (currentDelimiter == c && previousChar != '\\') {
                String opt = currentOptCharArray.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());

                opts.add(opt);
                currentOptCharArray.clear();

            } else if (checkCurCharIsAnotherDelimiterChar(c, anotherDelimiterChar)) {
                if (currentOptCharArray.isEmpty()) {
                    currentDelimiter = c;
                } else {
                    currentOptCharArray.add(c);
                }
            } else {
                currentOptCharArray.add(c);
            }
            previousChar = c;
        }


        opts = opts.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .map(s -> s.replaceAll("\\\\\n", ""))
                .filter(i -> i.length() > 0)
                .collect(Collectors.toList());

        List<String> needRemove = new ArrayList<>();

        String previousOpt = "";

        for (String opt : opts) {
            if (previousOpt.startsWith("-") && optMap.containsKey(previousOpt)) {
                //保留
            } else if (opt.startsWith("http")) {
                //保留
            } else if (opt.startsWith("-") && optMap.containsKey(opt)) {
                //保留
            } else {
                //移除
                needRemove.add(opt);
            }
            previousOpt = opt;
        }

        opts.removeIf(needRemove::contains);

        return opts.toArray(new String[0]);
    }

    private static boolean checkCurCharIsAnotherDelimiterChar(char c, char[] antherDelimiterChar) {
        return c == antherDelimiterChar[0] || c == antherDelimiterChar[1];
    }

    private static char[] getAnotherDelimiterChar(char c, char spaceDelimiter, char singleQuoteDelimiter, char doubleQuoteDelimiter) {
        if (c == spaceDelimiter) {
            return new char[]{singleQuoteDelimiter, doubleQuoteDelimiter};
        } else if (c == singleQuoteDelimiter) {
            return new char[]{spaceDelimiter, doubleQuoteDelimiter};
        } else {
            return new char[]{spaceDelimiter, singleQuoteDelimiter};
        }
    }
}
