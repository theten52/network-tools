package com.theten52.tools;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurlTest {
    static String[] cmdParts1 = {
            "curl", "--location", "--request", "GET", "https://id.xiapibuy.com/api/v4/item/get?itemid=4656131375&shopid=59763733"
            , "--header", "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.167 YaBrowser/22.7.3.796 Yowser/2.5 Safari/537.36"
            , "--header", "X-Forwarded-For: 10.139.253.111"
    };

    static String[] cmdParts2 = {
            "curl", "--location", "--request", "GET", "https://www.baidu.com"
    };

    public static void main(String[] args) {
        String[] strings = processOriginCurl(originalCurl);
        for (String str : strings) {
            if (str.startsWith("http") || str.startsWith("--header") || str.startsWith("-H")) {
                System.out.println(str + " ");
            } else {
                System.out.print(str + " ");
            }
        }
        System.out.println();
        String s = execCmdParts(strings);
        if (s == null || StringUtils.isNotBlank(s) || s.contains("\"error\":90309999")) {
            System.out.println("❌：" + s);
        } else {
            System.out.println("✅：" + s);
        }
    }

    private static String originalCurl = "curl 'https://id.xiapibuy.com/api/v4/item/get?itemid=4656131375&shopid=59763733' \\\n" +
            "  -H 'authority: id.xiapibuy.com' \\\n" +
            "  -H 'accept: application/json' \\\n" +
            "  -H 'accept-language: en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7' \\\n" +
            "  -H 'af-ac-enc-dat: AAcyLjMuMi00AAABg6IB9VoAAAxPAlcAAAAAAAAAALUc1tfPtx2eNZ+lQGEPXp3+N/SdzqNmxlp1L4tff1r27p8SwpcqlWoElPRl6ekEWeJsUptHCecgZgZUJNkMdyN9VJJ4Fcmn7nW9/iudAovi3Q4KeZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBdpYoBoaFxN4DV/pDl++L3/+NBeKB3wKlJvciBdWBBvaaeijPYf2G85HzJCJhO1xsKL1Rr43EU9rxBiNpNsgWiwTNue0ItFTg/V6S7yZ8b+URul/bNcp2Sur50wYMwSDikzRUuI9VU/LDpdQRLTm64iSmZ5ThVbxHE3bdSJ9U0k5djSR7fl8kZiNFp11d12JqI4GTqcIATPt0rYY/lg4GZoZ/6ktmA7MUhEIUj6kljFqZodbQEboXldfnVQFaMWIRrUq2io6kjRkGnw5JC7ja0YFovT2tvG0p7cDHKgUGL93c/eepLj1lWtbHvNydwzvOa8ZStWbkuVsfU1NJsDNWgQw2vl6G5BYjnlVUlNQzjfl60IFyefQS4QYdAcZKZtV5I4GTqcIATPt0rYY/lg4GZj+Nb4u1WHdUbCpXPApg4mao52Taa8i2RDDJAlpz1hDHJ3sXY0pNMunSQQvtExUbtN8KGuKS7t75OG7HfrT1pgMwhI+YiNH/GP07SAnecP+UZMBWDhT2yZm1nTpH6VAmUXk2o2vAiFhae2cy1xcnWzIzd2M3mBXX19lEIVCN2i+VJsmnz6s86WzMSRw/5y6a0g==' \\\n" +
            "  -H 'cache-control: no-cache' \\\n" +
            "  -H 'content-type: application/json' \\\n" +
            "  -H 'cookie: SPC_SI=3hs0YwAAAABjZENnSjgzZ5bfrQAAAAAAaHBRWEJ0QWQ=; SPC_F=hBrQhw0KNoxgTaQfmckmMB4htCvkC4Dh; REC_T_ID=76a50dcf-43ba-11ed-b7d1-2cea7fac4cc4; SPC_R_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_R_T_IV=R2JwaXZIQk5OemlSRm9pcA==; SPC_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_T_IV=R2JwaXZIQk5OemlSRm9pcA==; csrftoken=TJGpFeZ9UnzPHqi40XFrP6mR6GflBl9k; _gcl_au=1.1.543085384.1664870366; _med=refer; __LOCALE__null=ID' \\\n" +
            "  -H 'pragma: no-cache' \\\n" +
            "  -H 'referer: https://id.xiapibuy.com/Wardah-UV-Shield-Essential-Sunscreen-Gel-SPF-30-PA-40-ml-i.59763733.4656131375?sp_atk=b8bd5424-60fe-4e23-8c87-412b464083d1&xptdk=b8bd5424-60fe-4e23-8c87-412b464083d1' \\\n" +
            "  -H 'sec-ch-ua: \"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"' \\\n" +
            "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
            "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "  -H 'sec-fetch-dest: empty' \\\n" +
            "  -H 'sec-fetch-mode: cors' \\\n" +
            "  -H 'sec-fetch-site: same-origin' \\\n" +
            "  -H 'sz-token: false||MTAwMDI=' \\\n" +
            "  -H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36' \\\n" +
            "  -H 'x-api-source: pc' \\\n" +
            "  -H 'x-csrftoken: TJGpFeZ9UnzPHqi40XFrP6mR6GflBl9k' \\\n" +
            "  -H 'x-requested-with: XMLHttpRequest' \\\n" +
            "  -H 'x-shopee-language: id' \\\n" +
            "  -H 'x-sz-sdk-version: 2.3.2-4' \\\n" +
            "  --compressed";

    private static String postmanCurl = "curl --location --request GET 'https://id.xiapibuy.com/api/v4/item/get?itemid=4656131375&shopid=59763733' \\\n" +
            "--header 'authority: id.xiapibuy.com' \\\n" +
            "--header 'accept: application/json' \\\n" +
            "--header 'accept-language: en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7' \\\n" +
            "--header 'af-ac-enc-dat: AAcyLjMuMi00AAABg6FROpEAAAxNAlcAAAAAAAAAALUc1tfPtx2eNZ+lQGEPXp3+N/Sd7x5uc+Su7cAene+kmuo5I5cqlWoElPRl6ekEWeJsUptHCecgZgZUJNkMdyN9VJJ4Fcmn7nW9/iudAovi3Q4KeZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBdpYoBoaFxN4DV/pDl++L3/+NBeKB3wKlJvciBdWBBvaaeijPYf2G85HzJCJhO1xsu7KKtg+IfFmuwykkfhJDjQTNue0ItFTg/V6S7yZ8b+URul/bNcp2Sur50wYMwSDikzRUuI9VU/LDpdQRLTm64iSmZ5ThVbxHE3bdSJ9U0k5djSR7fl8kZiNFp11d12JqI4GTqcIATPt0rYY/lg4GZoZ/6ktmA7MUhEIUj6kljFqZodbQEboXldfnVQFaMWIRrUq2io6kjRkGnw5JC7ja0YFovT2tvG0p7cDHKgUGL93c/eepLj1lWtbHvNydwzvOa8ZStWbkuVsfU1NJsDNWgQw2vl6G5BYjnlVUlNQzjfl60IFyefQS4QYdAcZKZtV5I4GTqcIATPt0rYY/lg4GZj+Nb4u1WHdUbCpXPApg4mZ9oqHNx6IiMU8cE40c458vJ3sXY0pNMunSQQvtExUbtN8KGuKS7t75OG7HfrT1pgMwhI+YiNH/GP07SAnecP+UZMBWDhT2yZm1nTpH6VAmUXk2o2vAiFhae2cy1xcnWzIzd2M3mBXX19lEIVCN2i+VJsmnz6s86WzMSRw/5y6a0g==' \\\n" +
            "--header 'cache-control: no-cache' \\\n" +
            "--header 'content-type: application/json' \\\n" +
            "--header 'cookie: _gcl_au=1.1.1840652981.1664857785; __LOCALE__null=ID; _med=refer; csrftoken=oMhuB0OBgpKqQ7C20e73g2ca00YbnoS6; SPC_IA=-1; SPC_EC=-; REC_T_ID=ee246ab6-439e-11ed-b432-7225fb1efecf; SPC_T_ID=\"yGzjXLDcorZya0Xnb7jH5IBeeL98nBTzCTY4/trAjocNRigjPXNEBsvkGDUoVeZbYT9150ohs/K1NOXuLFrEm6xZXU0S510jxtwTvUKUrAA=\"; SPC_U=-; SPC_T_IV=\"Ya9UwiCPwlFhNQxuDmeDAg==\"; REC_T_ID=ee20d14a-439e-11ed-9705-9440c93f3434; SPC_R_T_ID=7ws+HLHYrgi1JyfWD8JaC/KGcBJcklh4Z5FOKyuKWYPJU18krbP8mSB58LxmWanME2Z4x6TZrbWL2NkZYVp5ZCX10oQdqQoZo/VWIRrcqaQrkn6hJFtPI2vKD27pPMSt4hHe/Y/53FY8TznPTSA4oGFEAqS8NDHSKqKPtTnzwx0=; SPC_R_T_IV=N1JSNEZZZDRoREN1bHdmRw==; SPC_T_ID=7ws+HLHYrgi1JyfWD8JaC/KGcBJcklh4Z5FOKyuKWYPJU18krbP8mSB58LxmWanME2Z4x6TZrbWL2NkZYVp5ZCX10oQdqQoZo/VWIRrcqaQrkn6hJFtPI2vKD27pPMSt4hHe/Y/53FY8TznPTSA4oGFEAqS8NDHSKqKPtTnzwx0=; SPC_T_IV=N1JSNEZZZDRoREN1bHdmRw==; SPC_SI=vhs0YwAAAABtczN6MzlkcfzTqAAAAAAAM2lGQXN4eGY=; SPC_F=eqIkQMCvOacgrOpUOQb07oMditTUFFEC; _QPWSDCXHZQA=0d4b4b22-c88e-44a5-a0d3-51d331f692b5; cto_bundle=Ah5RXF9mRVAxSk81MzFkbGl6WSUyQjROWHZlMUVoVTBOdXJTaTA1UUJYVWo2OVhTclJSS2pmTFkyajU1R2tCUHA0Q2tRNGFONTF3RWJVMlJBTGl5YlBuUnV3NG9yVUZocUpVdmFWSGxST3BOcTlYS3NOc3NTa2JOd25TUnh3MExidk9xQ0JGYUk4dlNhdGJVdXlmMHEyQkJZMTVLNHlBJTJCRlJlMDIwRks2UXNreHhQS3FsV1k1NFNmTkN1JTJCczZMdTBKOG9HYTczQ2ljNWEyZHNuVU5RWSUyRiUyRnYyRmhlUSUzRCUzRA; SPC_R_T_ID=7ws+HLHYrgi1JyfWD8JaC/KGcBJcklh4Z5FOKyuKWYPJU18krbP8mSB58LxmWanME2Z4x6TZrbWL2NkZYVp5ZCX10oQdqQoZo/VWIRrcqaQrkn6hJFtPI2vKD27pPMSt4hHe/Y/53FY8TznPTSA4oGFEAqS8NDHSKqKPtTnzwx0=; SPC_R_T_IV=N1JSNEZZZDRoREN1bHdmRw==; SPC_SI=vhs0YwAAAABtczN6MzlkcfzTqAAAAAAAM2lGQXN4eGY=; SPC_T_ID=7ws+HLHYrgi1JyfWD8JaC/KGcBJcklh4Z5FOKyuKWYPJU18krbP8mSB58LxmWanME2Z4x6TZrbWL2NkZYVp5ZCX10oQdqQoZo/VWIRrcqaQrkn6hJFtPI2vKD27pPMSt4hHe/Y/53FY8TznPTSA4oGFEAqS8NDHSKqKPtTnzwx0=; SPC_T_IV=N1JSNEZZZDRoREN1bHdmRw==' \\\n" +
            "--header 'pragma: no-cache' \\\n" +
            "--header 'referer: https://id.xiapibuy.com/Wardah-UV-Shield-Essential-Sunscreen-Gel-SPF-30-PA-40-ml-i.59763733.4656131375?sp_atk=b8bd5424-60fe-4e23-8c87-412b464083d1&xptdk=b8bd5424-60fe-4e23-8c87-412b464083d1' \\\n" +
            "--header 'sec-ch-ua: \"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"' \\\n" +
            "--header 'sec-ch-ua-mobile: ?0' \\\n" +
            "--header 'sec-ch-ua-platform: \"macOS\"' \\\n" +
            "--header 'sec-fetch-dest: empty' \\\n" +
            "--header 'sec-fetch-mode: cors' \\\n" +
            "--header 'sec-fetch-site: same-origin' \\\n" +
            "--header 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36' \\\n" +
            "--header 'x-api-source: pc' \\\n" +
            "--header 'x-csrftoken: oMhuB0OBgpKqQ7C20e73g2ca00YbnoS6' \\\n" +
            "--header 'x-requested-with: XMLHttpRequest' \\\n" +
            "--header 'x-shopee-language: id' \\\n" +
            "--header 'x-sz-sdk-version: 2.3.2-4'";

    private static String charlesUrl = "curl -H \"Host: id.xiapibuy.com\" -H \"Cookie: __LOCALE__null=ID; SPC_R_T_ID=ALV16yYYrJ954Cnd/qwq4ci/BJ9pEqXfZiOmxynSt3Fo/sBMtsXLmlfIV4vsCMvSB3suRczaBlCwhX00guo3dchuKO97Sjtk9V3yqqDwhv3Dtd8e6iLj2pjfYSi2aPImipqa47kYl7y/OO8pWfPg3j4ae9hGX5Q5pehCLg+Y2JU=; SPC_R_T_IV=RDB0YWZuaDdoYzlUQjl4TQ==; SPC_T_ID=ALV16yYYrJ954Cnd/qwq4ci/BJ9pEqXfZiOmxynSt3Fo/sBMtsXLmlfIV4vsCMvSB3suRczaBlCwhX00guo3dchuKO97Sjtk9V3yqqDwhv3Dtd8e6iLj2pjfYSi2aPImipqa47kYl7y/OO8pWfPg3j4ae9hGX5Q5pehCLg+Y2JU=; SPC_T_IV=RDB0YWZuaDdoYzlUQjl4TQ==; SPC_SI=5ho0YwAAAABwYTcwNFVsamdtsAAAAAAAeUVRUUE0VjA=; SPC_F=jCpKTv12KM6sXu0MdxxNCPdZ1f0NVTPC; REC_T_ID=db8d158c-43c7-11ed-a908-9440c93f746c; _gcl_au=1.1.2039763134.1664876118; csrftoken=TVdf0bEKtUAwodW82Xrs1lMkocbjUjMR; _QPWSDCXHZQA=a9e781f2-3192-47b2-df32-66b9f8b03504\" -H \"sec-ch-ua: \\\"Chromium\\\";v=\\\"104\\\", \\\" Not A;Brand\\\";v=\\\"99\\\", \\\"Yandex\\\";v=\\\"22\\\"\" -H \"sec-ch-ua-mobile: ?0\" -H \"x-sz-sdk-version: 2.3.2-4\" -H \"content-type: application/json\" -H \"accept: application/json\" -H \"x-shopee-language: id\" -H \"x-requested-with: XMLHttpRequest\" -H \"af-ac-enc-dat: AAcyLjMuMi00AAABg6KA2rMAAAxxAl0AAAAAAAAAALUc1tfqbJnquBjued3SPfDPNjZcwE5Y9CZDRAouDOTxYI6c0JcqlWoElPRl6ekEWeJsUptHCecgZgZUJNkMdyN9VJJ4Fcmn7nW9/iudAovi3Q4KeZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBq33VS+JVwnZ0HZWVGjz0oP+NBeKB3wKlJvciBdWBBvaaeijPYf2G85HzJCJhO1xsu7KKtg+IfFmuwykkfhJDjR2bU6BiP4jbbVh1cX3MKN0734doRzrCsZdk/6poJelfmVG2rUT03+NpNuFFxwWbIq+H8FsUC1SsOYA7uQssm6UlVhQnezi7GN9B49To0imbwzU6ZAIWKr3Tsiwkxq+NZB8hRld2WqENNTV9bukfQJwRul/bNcp2Sur50wYMwSDikzRUuI9VU/LDpdQRLTm64vGVFtzkzh3gjuLxgwquIESRZr8EptQTXXHI8QHpIBMd8cK6D+mS+izuW4fUEsbihmJFJkfOAnBywenZjD51w1BpGoHGvTBYivEZkbKzdr3CwzU6ZAIWKr3Tsiwkxq+NZBYm5PkcTch/SjQhPcsffZqfgIsuafgATPq8Uo4cqq7ZYeSCB+mwNST62/azLCJvzRryBkGqp2S6ViIMDM/xlofpdRoO+1stSFfsgxQ/QhMqhkWt0Sybvjx5xWkhiT5NjZY0NKdgbIimpnHd5HDrpP3ISU9CGiXXdY2/Gg2klBRMPyZ1BaM9cKQ3ySAPn6+ZjA==\" -H \"x-api-source: pc\" -H \"user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.114 YaBrowser/22.9.1.1081 Yowser/2.5 Safari/537.36\" -H \"x-csrftoken: TVdf0bEKtUAwodW82Xrs1lMkocbjUjMR\" -H \"sec-ch-ua-platform: \\\"macOS\\\"\" -H \"sec-fetch-site: same-origin\" -H \"sec-fetch-mode: cors\" -H \"sec-fetch-dest: empty\" -H \"referer: https://id.xiapibuy.com/Wardah-UV-Shield-Essential-Sunscreen-Gel-SPF-30-PA-40-ml-i.59763733.4656131375?sp_atk=b8bd5424-60fe-4e23-8c87-412b464083d1&xptdk=b8bd5424-60fe-4e23-8c87-412b464083d1\" -H \"accept-language: zh-CN,zh-TW;q=0.9,zh;q=0.8,en-US;q=0.7,en;q=0.6\" --compressed \"https://id.xiapibuy.com/api/v4/item/get?itemid=4656131375&shopid=59763733\"";

    private static String[] processCharlesUrl(String curlText) {

        String[] s = Arrays.stream(curlText.split(" -H ")).filter(StringUtils::isNotBlank).toArray(String[]::new);
        List<String> list = new ArrayList<>();
        for (String s1 : s) {
            String str = s1.trim();
            if (str.startsWith("curl")) {
                list.add("curl");

                continue;
            }
            if (str.contains("--compressed")) {
                String[] split = str.split("--compressed");
                if (split.length != 2) {
                    throw new IllegalArgumentException("解析程序无法解析字符串：" + str);
                } else {
                    list.add("-H");
                    list.add(split[0].trim());
                    list.add("--compressed");
                    String url = split[1].trim();
                    list.add(url.substring(1, url.length() - 2));
                }
                continue;
            }
            list.add("-H");
            list.add(str);
        }
        // 添加一个header："--header", "X-Forwarded-For: 10.139.253.111"
//        list.add("-H");
//        list.add("'X-Forwarded-For: 101.228.149.121'");

        return list.toArray(new String[0]);
    }

    private static String[] processPostmanCurl(String curlText) {

        String[] s = Arrays.stream(curlText.split("\\\n")).filter(StringUtils::isNotBlank).toArray(String[]::new);
        List<String> list = new ArrayList<>();
        for (String s1 : s) {
            String str = s1.trim();
            if (str.startsWith("curl")) {
                list.add("curl");
                //"--location", "--request", "GET",
                list.add("--location");
                list.add("--request");
                list.add("GET");
                if (str.endsWith("\\")) {
//                    list.add(str.substring(4, str.length() - 2).trim());
                    //去除单引号
                    String trim = str.substring(30, str.length() - 2).trim();
                    if (trim.startsWith("'") && trim.endsWith("'")) {
                        list.add(trim.substring(1, trim.length() - 2));
                    } else {
                        list.add(trim);
                    }
                } else {
                    list.add(str.substring(30).trim());
                }
                continue;
            }
            if (str.startsWith("--header")) {
                list.add("--header");
                if (str.endsWith("\\")) {
                    list.add(str.substring(8, str.length() - 2).trim());
                } else {
                    list.add(str.substring(8).trim());
                }
                continue;
            }
        }
        // 添加一个header："--header", "X-Forwarded-For: 10.139.253.111"
        list.add("--header");
        list.add("'X-Forwarded-For: 10.139.253.111'");

        return list.toArray(new String[0]);
    }

    private static String[] processOriginCurl(String curlText) {

        String[] s = Arrays.stream(curlText.split("\\\n")).filter(StringUtils::isNotBlank).toArray(String[]::new);
        List<String> list = new ArrayList<>();
        for (String s1 : s) {
            String str = s1.trim();
            if (str.startsWith("curl")) {
                list.add("curl");
                //"--location", "--request", "GET",
                list.add("--location");
                list.add("--request");
                list.add("GET");
                if (str.endsWith("\\")) {
//                    list.add(str.substring(4, str.length() - 2).trim());
                    //去除单引号
                    String trim = str.substring(4, str.length() - 2).trim();
                    if (trim.startsWith("'") && trim.endsWith("'")) {
                        list.add(trim.substring(1, trim.length() - 2));
                    } else {
                        list.add(trim);
                    }
                } else {
                    list.add(str.substring(4).trim());
                }
                continue;
            }
            if (str.startsWith("-H")) {
                list.add("--header");
                if (str.endsWith("\\")) {
                    list.add(str.substring(2, str.length() - 2).trim());
                } else {
                    list.add(str.substring(2).trim());
                }
                continue;
            }
            // 添加一个header："--header", "X-Forwarded-For: 10.139.253.111"
            list.add("--header");
            list.add("'X-Forwarded-For: 10.139.253.111'");
            if (str.endsWith("\\")) {
                list.add(str.substring(0, str.length() - 2).trim());
            } else {
                list.add(str.trim().trim());
            }
        }
        return list.toArray(new String[0]);
    }


    public static String execCmdParts(String[] cmdParts) {
        ProcessBuilder process = new ProcessBuilder(cmdParts);
        Process p;
        try {
            p = process.start();
            Thread.sleep(1000L);
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}