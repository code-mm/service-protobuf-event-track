package com.shuangyangad.event.track;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.HttpUtils;

import java.net.URI;
import java.util.UUID;
public class HttpUtils {

    public static HttpResponse doPost(HttpPost post, GeneratedMessageV3 message) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        String requestUrl = post.getURI().toString();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(message.toByteArray());
        InputStreamEntity inputStreamEntity = new InputStreamEntity(inputStream);
        post.setEntity(inputStreamEntity);

        post.addHeader("Content-Type", "application/x-protobuf");
        for (Header header : post.getAllHeaders()) {
            System.out.println(header.getName() + ":" + header.getValue());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("curl -XPOST ");
        for (Header header : post.getAllHeaders()) {
            sb.append(" -H \"").append(header.getName()).append(":").append(header.getValue()).append("\"");
        }

        String jsonBody = JsonFormat.printToString(message);
        jsonBody = jsonBody.replace("\"", "\\\"");
        sb.append(" -d \"").append(jsonBody).append("\"");
        sb.append(" ").append(requestUrl);

        System.out.println(sb.toString());
        return httpclient.execute(post);
    }
}