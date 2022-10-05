package com.theten52.tools;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.InputStream;
import java.util.Map;

/**
 * 响应对象包装类
 *
 * @author Administrator
 */
public class HttpResponse {

    private Response response;

    private int statusCode;

    private String urlLink;

    private String htmlValue;

    private String titleName;

    private Object jsonValue;

    public HttpResponse(Response response) {
        super();
        this.response = response;
        this.statusCode = response.statusCode();
        this.urlLink = response.url().toExternalForm();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getTitle() {
        if (titleName == null) {
            synchronized (this) {
                titleName = Jsoup.parse(getHtml()).title();
            }
        }
        return titleName;
    }

    public String getHtml() {
        if (htmlValue == null) {
            synchronized (this) {
                htmlValue = response.body();
            }
        }
        return htmlValue;
    }

    public Map<String, String> getCookies() {
        return response.cookies();
    }

    public Map<String, String> getHeaders() {
        return response.headers();
    }

    public byte[] getBytes() {
        return response.bodyAsBytes();
    }

    public String getContentType() {
        return response.contentType();
    }

    public void setCharset(String charset) {
        this.response.charset(charset);
    }

    public String getUrl() {
        return urlLink;
    }

    public InputStream getStream() {
        return response.bodyStream();
    }
}
