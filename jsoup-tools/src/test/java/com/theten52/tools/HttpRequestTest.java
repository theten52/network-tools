package com.theten52.tools;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

/**
 * TODO
 *
 * @author wangjin
 * @date 2022/10/4
 */
class HttpRequestTest {

    @Test
    void url() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.create();
        request.url("https://id.xiapibuy.com/api/v4/item/get?itemid=7532028281&shopid=255365082");
        request.header("Authority", "id.xiapibuy.com");
        request.header("Accept", "application/json");
        request.header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        request.header("Af-Ac-Enc-Dat",
                "AAcyLjMuMi00AAABg6KbzLkAAAt3AjgAAAAAAAAAALUc1tdMRs02nQ5dQFSXIt8fbDAlHnebwZdYqiBEdzxkJQALjpcqlWoElPRl6ekEWeJsUpuvL22hC1PiYRJZ36dqg4ZTFan4BhkoZlKy8SvL2FIvkZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBEhS2KCgHp4jNwxcsPJwhLGldGsV4rtQXDuXVa0gGlHmPBMGvHAtmtoj69TvUcwnbNAeMTr8qNkfxF9H24aZXvgUMsyHhEXNKoXTQBm1KHLFUrLni5ioX/ooVKxEmyKW3UW+QQ6pjMKk4isCGWw9ufZRIxMPWHatc3DJxrLbxnaL+fxXNIy7mvkK63w3LxpgTWyrFKlyeg2pnxy4dU+D+JXOHVeeJNvqYso4XqTBJlvEjgWfNNLiT5e1wPvI/KL073xtxDWHC58kjywRwzXXhW1Fx4u2YAcw9BtP2J3gkf9mFirCBwj5OCqLM+pe9xRdl/jf0909IHtxuTs1+zBMZrQEmSA138OeJlMLraFMKanP+fxXNIy7mvkK63w3LxpgTbqtk5bkLrnO1UkTuNtgFDDAlsFLDIzfdYGNDP9z6GA1FPaagc6LImu8N37nBs9tfHrlw/6ct3lIVioO4oGp0Io0lgOU43nBVeMA4HAnVeQh3bVwOLt/RI4rzca3TMq5N9OsQWNKd7aK4naP4MzWp+LlfWvg918A4oQrZShpuPnM=");
        request.header("Cache-Control", "no-cache");
        request.header("Content-Type", "application/json");
        request.header("Cookie",
                "__LOCALE__null=ID; csrftoken=IUa1G5wDTLALFCXpc3LNWIhlptdXzKsF; SPC_IA=-1; SPC_EC=-; REC_T_ID=d06064c0-43d1-11ed-8fb1-32adf6bbba30; SPC_T_ID=\"UIdSkwL+/Z5q4QLMbKmWKwJidaILly0xabeZUOSpKkkBaNtfk74pV+acFFdEqYcXCfM33QN4ygkRmpJ/p/l+eb+KH8lRD/JbbwQimtF5JtM=\"; SPC_U=-; SPC_T_IV=\"PwcO+6Q1kWpTGcjgl+xjrQ==\"; SPC_R_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_R_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_SI=XBs0YwAAAABSQ1ljTmZhN4z0sQAAAAAAMktKUkhROXo=; SPC_F=w2eGKKuwx6ZNTcNCxI0ajnf2bAzE8wKB; REC_T_ID=d05e1e06-43d1-11ed-83a2-2cea7fa8ac47; _QPWSDCXHZQA=542ee6dc-c41f-4c4d-a8ca-e48abdf086f2; SPC_R_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_R_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_SI=XBs0YwAAAABSQ1ljTmZhN4z0sQAAAAAAMktKUkhROXo=; SPC_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_T_IV=NnExdE4xcjQ4ejFGeEFiZg==");
        request.header("Pragma", "no-cache");
        request.header("Referer",
                "https://id.xiapibuy.com/Scarlett-Whitening-Exclusive-5-Item-i.255365082.7532028281?sp_atk=d441db14-33e6-41f6-a382-190dd7c52a6f&xptdk=d441db14-33e6-41f6-a382-190dd7c52a6f");
        request.header("Sec-Ch-Ua", "\"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"");
        request.header("Sec-Ch-Ua-Mobile", "?0");
        request.header("Sec-Ch-Ua-Platform", "\"macOS\"");
        request.header("Sec-Fetch-Dest", "empty");
        request.header("Sec-Fetch-Mode", "cors");
        request.header("Sec-Fetch-Site", "same-origin");
        request.header("User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
        request.header("X-Api-Source", "pc");
        request.header("X-Csrftoken", "IUa1G5wDTLALFCXpc3LNWIhlptdXzKsF");
        request.header("X-Requested-With", "XMLHttpRequest");
        request.header("X-Shopee-Language", "id");
        request.header("X-Sz-Sdk-Version", "2.3.2-4");
        //request.header("X-Forwarded-For", "203.0.113.195");

        HttpResponse execute = request.execute();
//        Thread.sleep(1000L);
//        execute = request.execute();

        printResp(execute);
    }

    private void printResp(HttpResponse resp) {
        System.out.println("url:" + resp.getUrl());
        System.out.println("resp_status_code:" + resp.getStatusCode());
        System.out.println("resp_content_type:" + resp.getContentType());
        Map<String, String> cookies = resp.getCookies();
        cookies.forEach((k, v) -> System.out.println("resp_cookies:" + "k[" + k + "]v[" + v + "]"));

        Map<String, String> headers = resp.getHeaders();
        headers.forEach((k, v) -> System.out.println("resp_headers:" + "k[" + k + "]v[" + v + "]"));

        System.out.println("resp_result:" + resp.getHtml());
    }
}