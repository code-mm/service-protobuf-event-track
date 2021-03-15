package com.shuangyangad.event.track;

import com.shuangyangad.mta.event.EventRequest;
import com.shuangyangad.mta.event.EventResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TrackController {
    @RequestMapping(value = "/track", produces = "application/x-protobuf")
    @ResponseBody
    public EventResponse getPersonProto(@RequestBody EventRequest request) {
        String event = request.getEvent();
        log.info("event : {}", event);
        EventResponse.Builder builder = EventResponse.newBuilder();
        builder.setCode(0);
        builder.setMessage("success");
        return builder.build();
    }
}
