package com.theten52.tools;

import reactor.core.publisher.Flux;
import reactor.netty.ByteBufFlux;
import reactor.netty.http.client.HttpClient;

/**
 * TODO
 *
 * @author wangjin
 * @date 2022/10/5
 */
public class NettyClient {
    public static void main(String[] args) {
        String url = "https://id.xiapibuy.com/api/v4/item/get?itemid=7532028281&shopid=255365082";
        HttpClient.create()             // Prepares an HTTP client ready for configuration
            .baseUrl("https://id.xiapibuy.com/")
            .port(443)  // Obtains the server's port and provides it as a port to which this
            // client should connect
            .get()               // Specifies that POST method will be used
            .uri("/api/v4/item/get?itemid=7532028281&shopid=255365082")   // Specifies the path
            .responseContent()    // Receives the response body
            .aggregate()
            .asString()
            .log("http-client")
            .block();
    }
}
