package com.theten52.tools.network;

import cn.hutool.core.io.IoUtil;
import com.theten52.tools.network.core.utils.XiaPiResultPrint;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * 使用jdk8可以访问成功，使用jdk11不能访问成功。很奇怪。
 */
public class URLConnectionTest {
    /**
     * step1:未添加任何请求头。
     * 最简单的请求方式，可以拿到正常结果。有一部分可能到403。
     * 拿到403之后重试即可（间隔1秒）。
     * <p>
     * step2：添加浏览器中的请求头后。
     * 暂时未发现请求403的情况。
     */
    @Test
    public void testGetInputStream() {
        InputStream in = null;
        try {
            String urlStr = "https://id.xiapibuy.com/api/v4/item/get?itemid=7532028281&shopid=255365082";
            //连接
            URL url = new URL(urlStr);
            URLConnection uc = url.openConnection();

            uc.setRequestProperty("Authority", "id.xiapibuy.com");
            uc.setRequestProperty("Accept", "application/json");
            uc.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
            uc.setRequestProperty("Af-Ac-Enc-Dat",
                    "AAcyLjMuMi00AAABg6KbzLkAAAt3AjgAAAAAAAAAALUc1tdMRs02nQ5dQFSXIt8fbDAlHnebwZdYqiBEdzxkJQALjpcqlWoElPRl6ekEWeJsUpuvL22hC1PiYRJZ36dqg4ZTFan4BhkoZlKy8SvL2FIvkZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBEhS2KCgHp4jNwxcsPJwhLGldGsV4rtQXDuXVa0gGlHmPBMGvHAtmtoj69TvUcwnbNAeMTr8qNkfxF9H24aZXvgUMsyHhEXNKoXTQBm1KHLFUrLni5ioX/ooVKxEmyKW3UW+QQ6pjMKk4isCGWw9ufZRIxMPWHatc3DJxrLbxnaL+fxXNIy7mvkK63w3LxpgTWyrFKlyeg2pnxy4dU+D+JXOHVeeJNvqYso4XqTBJlvEjgWfNNLiT5e1wPvI/KL073xtxDWHC58kjywRwzXXhW1Fx4u2YAcw9BtP2J3gkf9mFirCBwj5OCqLM+pe9xRdl/jf0909IHtxuTs1+zBMZrQEmSA138OeJlMLraFMKanP+fxXNIy7mvkK63w3LxpgTbqtk5bkLrnO1UkTuNtgFDDAlsFLDIzfdYGNDP9z6GA1FPaagc6LImu8N37nBs9tfHrlw/6ct3lIVioO4oGp0Io0lgOU43nBVeMA4HAnVeQh3bVwOLt/RI4rzca3TMq5N9OsQWNKd7aK4naP4MzWp+LlfWvg918A4oQrZShpuPnM=");
            uc.setRequestProperty("Cache-Control", "no-cache");
            uc.setRequestProperty("Content-Type", "application/json");
            uc.setRequestProperty("Cookie",
                    "__LOCALE__null=ID; csrftoken=IUa1G5wDTLALFCXpc3LNWIhlptdXzKsF; SPC_IA=-1; SPC_EC=-; REC_T_ID=d06064c0-43d1-11ed-8fb1-32adf6bbba30; SPC_T_ID=\"UIdSkwL+/Z5q4QLMbKmWKwJidaILly0xabeZUOSpKkkBaNtfk74pV+acFFdEqYcXCfM33QN4ygkRmpJ/p/l+eb+KH8lRD/JbbwQimtF5JtM=\"; SPC_U=-; SPC_T_IV=\"PwcO+6Q1kWpTGcjgl+xjrQ==\"; SPC_R_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_R_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_SI=XBs0YwAAAABSQ1ljTmZhN4z0sQAAAAAAMktKUkhROXo=; SPC_F=w2eGKKuwx6ZNTcNCxI0ajnf2bAzE8wKB; REC_T_ID=d05e1e06-43d1-11ed-83a2-2cea7fa8ac47; _QPWSDCXHZQA=542ee6dc-c41f-4c4d-a8ca-e48abdf086f2; SPC_R_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_R_T_IV=NnExdE4xcjQ4ejFGeEFiZg==; SPC_SI=XBs0YwAAAABSQ1ljTmZhN4z0sQAAAAAAMktKUkhROXo=; SPC_T_ID=4mAFB0S2/gNd40FTVGJ+gmCyzeE/FYWXs4vCmr59Hn8qk8jHU8GHRDDrziSwccQZeJnt0sC5wxqb8JHV93TMRb58edlr/a1/TCkKbCKGgDqt5P38qPJyFwXXrorwjXcobZj7pD8Ha0aeksTaYkmO0PwBywTwy8c/egaYOR1SQic=; SPC_T_IV=NnExdE4xcjQ4ejFGeEFiZg==");
            uc.setRequestProperty("Pragma", "no-cache");
            uc.setRequestProperty("Referer",
                    "https://id.xiapibuy.com/Scarlett-Whitening-Exclusive-5-Item-i.255365082.7532028281?sp_atk=d441db14-33e6-41f6-a382-190dd7c52a6f&xptdk=d441db14-33e6-41f6-a382-190dd7c52a6f");
            uc.setRequestProperty("Sec-Ch-Ua", "\"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"");
            uc.setRequestProperty("Sec-Ch-Ua-Mobile", "?0");
            uc.setRequestProperty("Sec-Ch-Ua-Platform", "\"macOS\"");
            uc.setRequestProperty("Sec-Fetch-Dest", "empty");
            uc.setRequestProperty("Sec-Fetch-Mode", "cors");
            uc.setRequestProperty("Sec-Fetch-Site", "same-origin");
            uc.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
            uc.setRequestProperty("X-Api-Source", "pc");
            uc.setRequestProperty("X-Csrftoken", "IUa1G5wDTLALFCXpc3LNWIhlptdXzKsF");
            uc.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            uc.setRequestProperty("X-Shopee-Language", "id");
            uc.setRequestProperty("X-Sz-Sdk-Version", "2.3.2-4");

            //获取读入流
            in = uc.getInputStream();
            String result = IoUtil.read(in).toString();

            Map<String, List<String>> headerFields = uc.getHeaderFields();

            String statusLine = uc.getHeaderField(null);
            String[] statusLineArr = statusLine.split(" ");
            String statusCode = statusLineArr[1];

            XiaPiResultPrint.print(Integer.parseInt(statusCode), null, headerFields, null, result);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
