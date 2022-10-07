package com.theten52.tools;

import com.theten52.tools.network.core.utils.XiaPiResultPrint;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class HttpHelper {

    private static final CloseableHttpClient HTTP_CLIENT = HttpClients.createDefault();

    public static void main(String[] args) {
        HttpGet request = new HttpGet("https://id.xiapibuy.com/api/v4/item/get?itemid=7532028281&shopid=255365082");

        request.setHeader("Authority", "id.xiapibuy.com");

        request.setHeader("Authority", "id.xiapibuy.com");
        request.setHeader("Accept", "application/json");
        request.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        request.setHeader("Af-Ac-Enc-Dat",
                "AAcyLjMuMi00AAABg6KbzLkAAAt3AjgAAAAAAAAAALUc1tdMRs02nQ5dQFSXIt8fbDAlHnebwZdYqiBEdzxkJQALjpcqlWoElPRl6ekEWeJsUpuvL22hC1PiYRJZ36dqg4ZTFan4BhkoZlKy8SvL2FIvkZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBEhS2KCgHp4jNwxcsPJwhLGldGsV4rtQXDuXVa0gGlHmPBMGvHAtmtoj69TvUcwnbNAeMTr8qNkfxF9H24aZXvgUMsyHhEXNKoXTQBm1KHLFUrLni5ioX/ooVKxEmyKW3UW+QQ6pjMKk4isCGWw9ufZRIxMPWHatc3DJxrLbxnaL+fxXNIy7mvkK63w3LxpgTWyrFKlyeg2pnxy4dU+D+JXOHVeeJNvqYso4XqTBJlvEjgWfNNLiT5e1wPvI/KL073xtxDWHC58kjywRwzXXhW1Fx4u2YAcw9BtP2J3gkf9mFirCBwj5OCqLM+pe9xRdl/jf0909IHtxuTs1+zBMZrQEmSA138OeJlMLraFMKanP+fxXNIy7mvkK63w3LxpgTbqtk5bkLrnO1UkTuNtgFDDAlsFLDIzfdYGNDP9z6GA1FPaagc6LImu8N37nBs9tfHrlw/6ct3lIVioO4oGp0Io0lgOU43nBVeMA4HAnVeQh3bVwOLt/RI4rzca3TMq5N9OsQWNKd7aK4naP4MzWp+LlfWvg918A4oQrZShpuPnM=");
        request.setHeader("Cache-Control", "no-cache");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Cookie",
                "__LOCALE__null=ID; csrftoken=IUa1G5wDTLALFCXpc3LNWIhlptdXzKsF; SPC_IA=-1; SPC_EC=-; REC_T_ID=d06064c0-43d1-11ed-8fb1-32adf6bbba30; SPC_T_ID=\"UIdSkwL+/Z5q4QLMbKmWKwJidaILly0xabeZUOSpKkkBaNtfk74pV+acFFdEqYcXCfM33QN4ygkRmpJ/p/l+eb+KH8lRD/JbbwQimtF5JtM=\"; SPC_U=-; SPC_T_IV=\"PwcO+6Q1kWpTGcjgl+xjrQ==\"; SPC_R_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_R_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_SI=XBs0YwAAAABSQ1ljTmZhN4z0sQAAAAAAMktKUkhROXo=; SPC_F=w2eGKKuwx6ZNTcNCxI0ajnf2bAzE8wKB; REC_T_ID=d05e1e06-43d1-11ed-83a2-2cea7fa8ac47; _QPWSDCXHZQA=542ee6dc-c41f-4c4d-a8ca-e48abdf086f2; SPC_R_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_R_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_SI=XBs0YwAAAABSQ1ljTmZhN4z0sQAAAAAAMktKUkhROXo=; SPC_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_T_IV=NnExdE4xcjQ4ejFGeEFiZg==");
        request.setHeader("Pragma", "no-cache");
        request.setHeader("Referer",
                "https://id.xiapibuy.com/Scarlett-Whitening-Exclusive-5-Item-i.255365082.7532028281?sp_atk=d441db14-33e6-41f6-a382-190dd7c52a6f&xptdk=d441db14-33e6-41f6-a382-190dd7c52a6f");
        request.setHeader("Sec-Ch-Ua", "\"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"");
        request.setHeader("Sec-Ch-Ua-Mobile", "?0");
        request.setHeader("Sec-Ch-Ua-Platform", "\"macOS\"");
        request.setHeader("Sec-Fetch-Dest", "empty");
        request.setHeader("Sec-Fetch-Mode", "cors");
        request.setHeader("Sec-Fetch-Site", "same-origin");
        request.setHeader("User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
        request.setHeader("X-Api-Source", "pc");
        request.setHeader("X-Csrftoken", "IUa1G5wDTLALFCXpc3LNWIhlptdXzKsF");
        request.setHeader("X-Requested-With", "XMLHttpRequest");
        request.setHeader("X-Shopee-Language", "id");
        request.setHeader("X-Sz-Sdk-Version", "2.3.2-4");
        //request.header("X-Forwarded-For", "203.0.113.195");


        execute(request);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        execute(request);
    }

    private static void execute(HttpGet request) {
        try (CloseableHttpResponse rep = HTTP_CLIENT.execute(request)) {
            StatusLine statusLine = rep.getStatusLine();
            if (statusLine.getStatusCode() >= 200 && statusLine.getStatusCode() < 300) {
                HttpEntity entity = rep.getEntity();
                String s = EntityUtils.toString(entity);
                Header[] allHeaders = rep.getAllHeaders();
                Map<String, List<String>> headers = Arrays.stream(allHeaders).collect(groupingBy(Header::getName, mapping(Header::getValue, toList())));

                XiaPiResultPrint.print(statusLine.getStatusCode(), null, headers, null, s);
            } else {
                System.out.println("httpclient请求失败：" + statusLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
