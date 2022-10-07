package com.theten52.tools.network;

import cn.hutool.core.util.StrUtil;
import com.roxstudio.utils.CUrl;
import com.theten52.tools.network.core.utils.CurlUtils;
import com.theten52.tools.network.core.utils.XiaPiResultPrint;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaCurlPlayTest {

    @Test
    void customUserAgentAndHeaders() {
        CUrl cUrl = JavaCurlPlay.customUserAgentAndHeaders();
        assertEquals(200, cUrl.getHttpCode());
    }

    @Test
    void test_xiapiApi() {
        String url = "https://id.xiapibuy.com/api/v4/item/get?itemid=7532028281&shopid=255365082";

        Map<String, String> headers = new HashMap<>();

        headers.put("Authority", "id.xiapibuy.com");
        headers.put("Accept", "application/json");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Af-Ac-Enc-Dat",
                "AAcyLjMuMi00AAABg6KbzLkAAAt3AjgAAAAAAAAAALUc1tdMRs02nQ5dQFSXIt8fbDAlHnebwZdYqiBEdzxkJQALjpcqlWoElPRl6ekEWeJsUpuvL22hC1PiYRJZ36dqg4ZTFan4BhkoZlKy8SvL2FIvkZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBEhS2KCgHp4jNwxcsPJwhLGldGsV4rtQXDuXVa0gGlHmPBMGvHAtmtoj69TvUcwnbNAeMTr8qNkfxF9H24aZXvgUMsyHhEXNKoXTQBm1KHLFUrLni5ioX/ooVKxEmyKW3UW+QQ6pjMKk4isCGWw9ufZRIxMPWHatc3DJxrLbxnaL+fxXNIy7mvkK63w3LxpgTWyrFKlyeg2pnxy4dU+D+JXOHVeeJNvqYso4XqTBJlvEjgWfNNLiT5e1wPvI/KL073xtxDWHC58kjywRwzXXhW1Fx4u2YAcw9BtP2J3gkf9mFirCBwj5OCqLM+pe9xRdl/jf0909IHtxuTs1+zBMZrQEmSA138OeJlMLraFMKanP+fxXNIy7mvkK63w3LxpgTbqtk5bkLrnO1UkTuNtgFDDAlsFLDIzfdYGNDP9z6GA1FPaagc6LImu8N37nBs9tfHrlw/6ct3lIVioO4oGp0Io0lgOU43nBVeMA4HAnVeQh3bVwOLt/RI4rzca3TMq5N9OsQWNKd7aK4naP4MzWp+LlfWvg918A4oQrZShpuPnM=");
        headers.put("Cache-Control", "no-cache");
        headers.put("Content-Type", "application/json");
        headers.put("Cookie",
                "__LOCALE__null=ID; csrftoken=IUa1G5wDTLALFCXpc3LNWIhlptdXzKsF; SPC_IA=-1; SPC_EC=-; REC_T_ID=d06064c0-43d1-11ed-8fb1-32adf6bbba30; SPC_T_ID=\"UIdSkwL+/Z5q4QLMbKmWKwJidaILly0xabeZUOSpKkkBaNtfk74pV+acFFdEqYcXCfM33QN4ygkRmpJ/p/l+eb+KH8lRD/JbbwQimtF5JtM=\"; SPC_U=-; SPC_T_IV=\"PwcO+6Q1kWpTGcjgl+xjrQ==\"; SPC_R_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_R_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_SI=XBs0YwAAAABSQ1ljTmZhN4z0sQAAAAAAMktKUkhROXo=; SPC_F=w2eGKKuwx6ZNTcNCxI0ajnf2bAzE8wKB; REC_T_ID=d05e1e06-43d1-11ed-83a2-2cea7fa8ac47; _QPWSDCXHZQA=542ee6dc-c41f-4c4d-a8ca-e48abdf086f2; SPC_R_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_R_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_SI=XBs0YwAAAABSQ1ljTmZhN4z0sQAAAAAAMktKUkhROXo=; SPC_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_T_IV=NnExdE4xcjQ4ejFGeEFiZg==");
        headers.put("Pragma", "no-cache");
        headers.put("Referer",
                "https://id.xiapibuy.com/Scarlett-Whitening-Exclusive-5-Item-i.255365082.7532028281?sp_atk=d441db14-33e6-41f6-a382-190dd7c52a6f&xptdk=d441db14-33e6-41f6-a382-190dd7c52a6f");
        headers.put("Sec-Ch-Ua", "\"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"");
        headers.put("Sec-Ch-Ua-Mobile", "?0");
        headers.put("Sec-Ch-Ua-Platform", "\"macOS\"");
        headers.put("Sec-Fetch-Dest", "empty");
        headers.put("Sec-Fetch-Mode", "cors");
        headers.put("Sec-Fetch-Site", "same-origin");
        headers.put("User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
        headers.put("X-Api-Source", "pc");
        headers.put("X-Csrftoken", "IUa1G5wDTLALFCXpc3LNWIhlptdXzKsF");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("X-Shopee-Language", "id");
        headers.put("X-Sz-Sdk-Version", "2.3.2-4");

        CUrl cUrl = JavaCurlPlay.exec(url, headers);

        String result = cUrl.getStdout(CUrl.UTF8, "获取返回值失败");

        Map<String, List<String>> responseHeaders = cUrl.getResponseHeaders().get(0).stream()
                .filter(i -> StrUtil.isNotBlank(i[0]))
                .collect(Collectors.groupingBy(i -> i[0], Collectors.mapping(i -> i[1], Collectors.toList())));

        XiaPiResultPrint.print(cUrl.getHttpCode(), null, responseHeaders, null, result);

        assertEquals(200, cUrl.getHttpCode());
    }

    @Test
    void exec() {
        String curlFromPostman = "curl --location --request GET 'https://id.xiapibuy.com/api/v4/item/get?itemid=4656131375&shopid=59763733' \\\n" +
                "--header 'authority: id.xiapibuy.com' \\\n" +
                "--header 'accept: application/json' \\\n" +
                "--header 'accept-language: en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7' \\\n" +
                "--header 'af-ac-enc-dat: AAcyLjMuMi00AAABg6IB9VoAAAxPAlcAAAAAAAAAALUc1tfPtx2eNZ+lQGEPXp3+N/SdzqNmxlp1L4tff1r27p8SwpcqlWoElPRl6ekEWeJsUptHCecgZgZUJNkMdyN9VJJ4Fcmn7nW9/iudAovi3Q4KeZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBdpYoBoaFxN4DV/pDl++L3/+NBeKB3wKlJvciBdWBBvaaeijPYf2G85HzJCJhO1xsKL1Rr43EU9rxBiNpNsgWiwTNue0ItFTg/V6S7yZ8b+URul/bNcp2Sur50wYMwSDikzRUuI9VU/LDpdQRLTm64iSmZ5ThVbxHE3bdSJ9U0k5djSR7fl8kZiNFp11d12JqI4GTqcIATPt0rYY/lg4GZoZ/6ktmA7MUhEIUj6kljFqZodbQEboXldfnVQFaMWIRrUq2io6kjRkGnw5JC7ja0YFovT2tvG0p7cDHKgUGL93c/eepLj1lWtbHvNydwzvOa8ZStWbkuVsfU1NJsDNWgQw2vl6G5BYjnlVUlNQzjfl60IFyefQS4QYdAcZKZtV5I4GTqcIATPt0rYY/lg4GZj+Nb4u1WHdUbCpXPApg4mao52Taa8i2RDDJAlpz1hDHJ3sXY0pNMunSQQvtExUbtN8KGuKS7t75OG7HfrT1pgMwhI+YiNH/GP07SAnecP+UZMBWDhT2yZm1nTpH6VAmUXk2o2vAiFhae2cy1xcnWzIzd2M3mBXX19lEIVCN2i+VJsmnz6s86WzMSRw/5y6a0g==' \\\n" +
                "--header 'cache-control: no-cache' \\\n" +
                "--header 'content-type: application/json' \\\n" +
                "--header 'cookie: SPC_SI=3hs0YwAAAABjZENnSjgzZ5bfrQAAAAAAaHBRWEJ0QWQ=; SPC_F=hBrQhw0KNoxgTaQfmckmMB4htCvkC4Dh; REC_T_ID=76a50dcf-43ba-11ed-b7d1-2cea7fac4cc4; SPC_R_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_R_T_IV=R2JwaXZIQk5OemlSRm9pcA==; SPC_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_T_IV=R2JwaXZIQk5OemlSRm9pcA==; csrftoken=TJGpFeZ9UnzPHqi40XFrP6mR6GflBl9k; _gcl_au=1.1.543085384.1664870366; _med=refer; __LOCALE__null=ID; SPC_R_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_R_T_IV=R2JwaXZIQk5OemlSRm9pcA==; SPC_SI=3hs0YwAAAABjZENnSjgzZ5bfrQAAAAAAaHBRWEJ0QWQ=; SPC_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_T_IV=R2JwaXZIQk5OemlSRm9pcA==' \\\n" +
                "--header 'pragma: no-cache' \\\n" +
                "--header 'referer: https://id.xiapibuy.com/Wardah-UV-Shield-Essential-Sunscreen-Gel-SPF-30-PA-40-ml-i.59763733.4656131375?sp_atk=b8bd5424-60fe-4e23-8c87-412b464083d1&xptdk=b8bd5424-60fe-4e23-8c87-412b464083d1' \\\n" +
                "--header 'sec-ch-ua: \"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"' \\\n" +
                "--header 'sec-ch-ua-mobile: ?0' \\\n" +
                "--header 'sec-ch-ua-platform: \"macOS\"' \\\n" +
                "--header 'sec-fetch-dest: empty' \\\n" +
                "--header 'sec-fetch-mode: cors' \\\n" +
                "--header 'sec-fetch-site: same-origin' \\\n" +
                "--header 'sz-token: false||MTAwMDI=' \\\n" +
                "--header 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36' \\\n" +
                "--header 'x-api-source: pc' \\\n" +
                "--header 'x-csrftoken: TJGpFeZ9UnzPHqi40XFrP6mR6GflBl9k' \\\n" +
                "--header 'x-requested-with: XMLHttpRequest' \\\n" +
                "--header 'x-shopee-language: id' \\\n" +
                "--header 'x-sz-sdk-version: 2.3.2-4'";

        String curlFromChrome = "curl 'https://id.xiapibuy.com/api/v4/item/get?itemid=4656131375&shopid=59763733' \\\n" +
                "  -H 'authority: id.xiapibuy.com' \\\n" +
                "  -H 'accept: application/json' \\\n" +
                "  -H 'accept-language: zh-CN,zh-TW;q=0.9,zh;q=0.8,en-US;q=0.7,en;q=0.6' \\\n" +
                "  -H 'af-ac-enc-dat: AAcyLjMuMi00AAABg7EGjYMAAAxqAl0AAAAAAAAAALUc1tfqbJnquBjued3SPfDPNjZczvNNpH8ViyJmvxJ0bBPDqZcqlWoElPRl6ekEWeJsUptHCecgZgZUJNkMdyN9VJJ4Fcmn7nW9/iudAovi3Q4KeZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBq33VS+JVwnZ0HZWVGjz0oP+NBeKB3wKlJvciBdWBBvaaeijPYf2G85HzJCJhO1xsu7KKtg+IfFmuwykkfhJDjR2bU6BiP4jbbVh1cX3MKN0734doRzrCsZdk/6poJelfmVG2rUT03+NpNuFFxwWbIq+H8FsUC1SsOYA7uQssm6UlVhQnezi7GN9B49To0imbwzU6ZAIWKr3Tsiwkxq+NZB8hRld2WqENNTV9bukfQJwRul/bNcp2Sur50wYMwSDikzRUuI9VU/LDpdQRLTm64vGVFtzkzh3gjuLxgwquIESRZr8EptQTXXHI8QHpIBMd8cK6D+mS+izuW4fUEsbihmJFJkfOAnBywenZjD51w1BpGoHGvTBYivEZkbKzdr3CwzU6ZAIWKr3Tsiwkxq+NZBYm5PkcTch/SjQhPcsffZqfgIsuafgATPq8Uo4cqq7ZYeSCB+mwNST62/azLCJvzRryBkGqp2S6ViIMDM/xlofpdRoO+1stSFfsgxQ/QhMqhkWt0Sybvjx5xWkhiT5NjZY0NKdgbIimpnHd5HDrpP3ISU9CGiXXdY2/Gg2klBRMPyZ1BaM9cKQ3ySAPn6+ZjA==' \\\n" +
                "  -H 'content-type: application/json' \\\n" +
                "  -H 'cookie: __LOCALE__null=ID; SPC_R_T_ID=ALV16yYYrJ954Cnd/qwq4ci/BJ9pEqXfZiOmxynSt3Fo/sBMtsXLmlfIV4vsCMvSB3suRczaBlCwhX00guo3dchuKO97Sjtk9V3yqqDwhv3Dtd8e6iLj2pjfYSi2aPImipqa47kYl7y/OO8pWfPg3j4ae9hGX5Q5pehCLg+Y2JU=; SPC_R_T_IV=RDB0YWZuaDdoYzlUQjl4TQ==; SPC_T_ID=ALV16yYYrJ954Cnd/qwq4ci/BJ9pEqXfZiOmxynSt3Fo/sBMtsXLmlfIV4vsCMvSB3suRczaBlCwhX00guo3dchuKO97Sjtk9V3yqqDwhv3Dtd8e6iLj2pjfYSi2aPImipqa47kYl7y/OO8pWfPg3j4ae9hGX5Q5pehCLg+Y2JU=; SPC_T_IV=RDB0YWZuaDdoYzlUQjl4TQ==; SPC_F=jCpKTv12KM6sXu0MdxxNCPdZ1f0NVTPC; REC_T_ID=db8d158c-43c7-11ed-a908-9440c93f746c; _gcl_au=1.1.2039763134.1664876118; csrftoken=TVdf0bEKtUAwodW82Xrs1lMkocbjUjMR; _QPWSDCXHZQA=a9e781f2-3192-47b2-df32-66b9f8b03504; SPC_SI=qlY9YwAAAABhODRVSHp0WE4qNAAAAAAAQnlic1hUUm8=' \\\n" +
                "  -H 'referer: https://id.xiapibuy.com/Wardah-UV-Shield-Essential-Sunscreen-Gel-SPF-30-PA-40-ml-i.59763733.4656131375?sp_atk=b8bd5424-60fe-4e23-8c87-412b464083d1&xptdk=b8bd5424-60fe-4e23-8c87-412b464083d1' \\\n" +
                "  -H 'sec-ch-ua: \"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Yandex\";v=\"22\"' \\\n" +
                "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
                "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
                "  -H 'sec-fetch-dest: empty' \\\n" +
                "  -H 'sec-fetch-mode: cors' \\\n" +
                "  -H 'sec-fetch-site: same-origin' \\\n" +
                "  -H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.114 YaBrowser/22.9.1.1081 Yowser/2.5 Safari/537.36' \\\n" +
                "  -H 'x-api-source: pc' \\\n" +
                "  -H 'x-csrftoken: TVdf0bEKtUAwodW82Xrs1lMkocbjUjMR' \\\n" +
                "  -H 'x-requested-with: XMLHttpRequest' \\\n" +
                "  -H 'x-shopee-language: id' \\\n" +
                "  --compressed";

        String curlFromCharles = "curl -H \"Host: id.xiapibuy.com\" -H \"Cookie: __LOCALE__null=ID; SPC_R_T_ID=ALV16yYYrJ954Cnd/qwq4ci/BJ9pEqXfZiOmxynSt3Fo/sBMtsXLmlfIV4vsCMvSB3suRczaBlCwhX00guo3dchuKO97Sjtk9V3yqqDwhv3Dtd8e6iLj2pjfYSi2aPImipqa47kYl7y/OO8pWfPg3j4ae9hGX5Q5pehCLg+Y2JU=; SPC_R_T_IV=RDB0YWZuaDdoYzlUQjl4TQ==; SPC_T_ID=ALV16yYYrJ954Cnd/qwq4ci/BJ9pEqXfZiOmxynSt3Fo/sBMtsXLmlfIV4vsCMvSB3suRczaBlCwhX00guo3dchuKO97Sjtk9V3yqqDwhv3Dtd8e6iLj2pjfYSi2aPImipqa47kYl7y/OO8pWfPg3j4ae9hGX5Q5pehCLg+Y2JU=; SPC_T_IV=RDB0YWZuaDdoYzlUQjl4TQ==; SPC_SI=5ho0YwAAAABwYTcwNFVsamdtsAAAAAAAeUVRUUE0VjA=; SPC_F=jCpKTv12KM6sXu0MdxxNCPdZ1f0NVTPC; REC_T_ID=db8d158c-43c7-11ed-a908-9440c93f746c; _gcl_au=1.1.2039763134.1664876118; csrftoken=TVdf0bEKtUAwodW82Xrs1lMkocbjUjMR; _QPWSDCXHZQA=a9e781f2-3192-47b2-df32-66b9f8b03504\" -H \"sec-ch-ua: \\\"Chromium\\\";v=\\\"104\\\", \\\" Not A;Brand\\\";v=\\\"99\\\", \\\"Yandex\\\";v=\\\"22\\\"\" -H \"sec-ch-ua-mobile: ?0\" -H \"x-sz-sdk-version: 2.3.2-4\" -H \"content-type: application/json\" -H \"accept: application/json\" -H \"x-shopee-language: id\" -H \"x-requested-with: XMLHttpRequest\" -H \"af-ac-enc-dat: AAcyLjMuMi00AAABg6KA2rMAAAxxAl0AAAAAAAAAALUc1tfqbJnquBjued3SPfDPNjZcwE5Y9CZDRAouDOTxYI6c0JcqlWoElPRl6ekEWeJsUptHCecgZgZUJNkMdyN9VJJ4Fcmn7nW9/iudAovi3Q4KeZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBq33VS+JVwnZ0HZWVGjz0oP+NBeKB3wKlJvciBdWBBvaaeijPYf2G85HzJCJhO1xsu7KKtg+IfFmuwykkfhJDjR2bU6BiP4jbbVh1cX3MKN0734doRzrCsZdk/6poJelfmVG2rUT03+NpNuFFxwWbIq+H8FsUC1SsOYA7uQssm6UlVhQnezi7GN9B49To0imbwzU6ZAIWKr3Tsiwkxq+NZB8hRld2WqENNTV9bukfQJwRul/bNcp2Sur50wYMwSDikzRUuI9VU/LDpdQRLTm64vGVFtzkzh3gjuLxgwquIESRZr8EptQTXXHI8QHpIBMd8cK6D+mS+izuW4fUEsbihmJFJkfOAnBywenZjD51w1BpGoHGvTBYivEZkbKzdr3CwzU6ZAIWKr3Tsiwkxq+NZBYm5PkcTch/SjQhPcsffZqfgIsuafgATPq8Uo4cqq7ZYeSCB+mwNST62/azLCJvzRryBkGqp2S6ViIMDM/xlofpdRoO+1stSFfsgxQ/QhMqhkWt0Sybvjx5xWkhiT5NjZY0NKdgbIimpnHd5HDrpP3ISU9CGiXXdY2/Gg2klBRMPyZ1BaM9cKQ3ySAPn6+ZjA==\" -H \"x-api-source: pc\" -H \"user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.114 YaBrowser/22.9.1.1081 Yowser/2.5 Safari/537.36\" -H \"x-csrftoken: TVdf0bEKtUAwodW82Xrs1lMkocbjUjMR\" -H \"sec-ch-ua-platform: \\\"macOS\\\"\" -H \"sec-fetch-site: same-origin\" -H \"sec-fetch-mode: cors\" -H \"sec-fetch-dest: empty\" -H \"referer: https://id.xiapibuy.com/Wardah-UV-Shield-Essential-Sunscreen-Gel-SPF-30-PA-40-ml-i.59763733.4656131375?sp_atk=b8bd5424-60fe-4e23-8c87-412b464083d1&xptdk=b8bd5424-60fe-4e23-8c87-412b464083d1\" -H \"accept-language: zh-CN,zh-TW;q=0.9,zh;q=0.8,en-US;q=0.7,en;q=0.6\" --compressed \"https://id.xiapibuy.com/api/v4/item/get?itemid=4656131375&shopid=59763733\"";

        String curl = curlFromChrome;

        String[] opts = CurlUtils.resolver(curl);

        CUrl cUrl = JavaCurlPlay.exec(opts);

        String result = cUrl.getStdout(CUrl.UTF8, "获取返回值失败");

        Map<String, List<String>> responseHeaders = cUrl.getResponseHeaders().get(0).stream()
                .filter(i -> StrUtil.isNotBlank(i[0]))
                .collect(Collectors.groupingBy(i -> i[0], Collectors.mapping(i -> i[1], Collectors.toList())));

        XiaPiResultPrint.print(cUrl.getHttpCode(), null, responseHeaders, null, result);

        assertEquals(200, cUrl.getHttpCode());
    }
}