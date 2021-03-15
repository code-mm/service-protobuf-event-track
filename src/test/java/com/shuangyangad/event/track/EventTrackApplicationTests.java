package com.shuangyangad.event.track;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventTrackApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        try {
            URI uri = new URI("http", null, "127.0.0.1", 8080, "/demo/test", "", null);
            HttpPost request = new HttpPost(uri);
            MessageUserLogin.MessageUserLoginRequest.Builder builder = MessageUserLogin.MessageUserLoginRequest.newBuilder();
            builder.setUsername("tom");
            builder.setPassword("123456");
            HttpResponse response = HttpUtils.doPost(request, builder.build());
            MessageUserLogin.MessageUserLoginResponse messageUserLoginResponse = MessageUserLogin.MessageUserLoginResponse.parseFrom(response.getEntity().getContent());
            System.err.println(messageUserLoginResponse.getAccessToken());
        } catch (Exception e) {

        }
    }

}
