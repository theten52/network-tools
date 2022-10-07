package com.theten52.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemCommandUtils {
    /**
     * 执行系统命令.
     * <p>
     * 这和操作系统相关，不同操作系统支持的命令是不同的。
     *
     * @param cmdParts 系统命令
     * @return 命令返回值
     */
    public static String execCmd(String[] cmdParts) {
        try {
            ProcessBuilder process = new ProcessBuilder(cmdParts);
            Process p = process.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }

            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException("命令执行发生错误：", e);
        }
    }
}
