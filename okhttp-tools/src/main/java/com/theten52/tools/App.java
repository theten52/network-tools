package com.theten52.tools;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://id.xiapibuy.com/api/v4/item/get?itemid=4656131375&shopid=59763733")
                .get()
                .addHeader("authority", "id.xiapibuy.com")
                .addHeader("accept", "application/json")
                .addHeader("accept-language", "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7")
                .addHeader("af-ac-enc-dat", "AAcyLjMuMi00AAABg6IB9VoAAAxPAlcAAAAAAAAAALUc1tfPtx2eNZ+lQGEPXp3+N/SdzqNmxlp1L4tff1r27p8SwpcqlWoElPRl6ekEWeJsUptHCecgZgZUJNkMdyN9VJJ4Fcmn7nW9/iudAovi3Q4KeZFjs4yw8pGWNnYQjtmnppZkfx9s4w5mdq+xn6n9CtBqjYL9eKtscmx0v9UESe7UD5Fjs4yw8pGWNnYQjtmnppaeKwVmxFcF4ObDBrVINAKBdpYoBoaFxN4DV/pDl++L3/+NBeKB3wKlJvciBdWBBvaaeijPYf2G85HzJCJhO1xsKL1Rr43EU9rxBiNpNsgWiwTNue0ItFTg/V6S7yZ8b+URul/bNcp2Sur50wYMwSDikzRUuI9VU/LDpdQRLTm64iSmZ5ThVbxHE3bdSJ9U0k5djSR7fl8kZiNFp11d12JqI4GTqcIATPt0rYY/lg4GZoZ/6ktmA7MUhEIUj6kljFqZodbQEboXldfnVQFaMWIRrUq2io6kjRkGnw5JC7ja0YFovT2tvG0p7cDHKgUGL93c/eepLj1lWtbHvNydwzvOa8ZStWbkuVsfU1NJsDNWgQw2vl6G5BYjnlVUlNQzjfl60IFyefQS4QYdAcZKZtV5I4GTqcIATPt0rYY/lg4GZj+Nb4u1WHdUbCpXPApg4mao52Taa8i2RDDJAlpz1hDHJ3sXY0pNMunSQQvtExUbtN8KGuKS7t75OG7HfrT1pgMwhI+YiNH/GP07SAnecP+UZMBWDhT2yZm1nTpH6VAmUXk2o2vAiFhae2cy1xcnWzIzd2M3mBXX19lEIVCN2i+VJsmnz6s86WzMSRw/5y6a0g==")
                .addHeader("cache-control", "no-cache")
                .addHeader("content-type", "application/json")
                .addHeader("cookie", "SPC_SI=3hs0YwAAAABjZENnSjgzZ5bfrQAAAAAAaHBRWEJ0QWQ=; SPC_F=hBrQhw0KNoxgTaQfmckmMB4htCvkC4Dh; REC_T_ID=76a50dcf-43ba-11ed-b7d1-2cea7fac4cc4; SPC_R_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_R_T_IV=R2JwaXZIQk5OemlSRm9pcA==; SPC_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_T_IV=R2JwaXZIQk5OemlSRm9pcA==; csrftoken=TJGpFeZ9UnzPHqi40XFrP6mR6GflBl9k; _gcl_au=1.1.543085384.1664870366; _med=refer; __LOCALE__null=ID; SPC_R_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_R_T_IV=R2JwaXZIQk5OemlSRm9pcA==; SPC_SI=3hs0YwAAAABjZENnSjgzZ5bfrQAAAAAAaHBRWEJ0QWQ=; SPC_T_ID=/7xldhXHanp7KBghEVJaVfZNOWvxE6a7hGDnZ8M5m6k0/yXnnIcviXNEezwCMbGxwN42Sb070I6W8TQ7e5g1mRrie1RJYZFZs0Zdo3dPgrCtMOTN/KRYAXtIh/6cn+7S6b18kfT8dumaS0NIo/VdQ4uRS6KlVPNwxhSI754fQyA=; SPC_T_IV=R2JwaXZIQk5OemlSRm9pcA==")
                .addHeader("pragma", "no-cache")
                .addHeader("referer", "https://id.xiapibuy.com/Wardah-UV-Shield-Essential-Sunscreen-Gel-SPF-30-PA-40-ml-i.59763733.4656131375?sp_atk=b8bd5424-60fe-4e23-8c87-412b464083d1&xptdk=b8bd5424-60fe-4e23-8c87-412b464083d1")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"macOS\"")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-site", "same-origin")
                .addHeader("sz-token", "false||MTAwMDI=")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")
                .addHeader("x-api-source", "pc")
                .addHeader("x-csrftoken", "TJGpFeZ9UnzPHqi40XFrP6mR6GflBl9k")
                .addHeader("x-requested-with", "XMLHttpRequest")
                .addHeader("x-shopee-language", "id")
                .addHeader("x-sz-sdk-version", "2.3.2-4")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}
