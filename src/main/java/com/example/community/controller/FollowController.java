package com.example.community.controller;

import com.example.community.entity.Event;
import com.example.community.entity.User;
import com.example.community.event.EventProducer;
import com.example.community.service.FollowService;
import com.example.community.util.CommunityConstant;
import com.example.community.util.CommunityUtil;
import com.example.community.util.HostHolder;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FollowController implements CommunityConstant {

    @Autowired
    private FollowService followService;

    @Autowired
    private HostHolder hostHolder;

//    @Autowired
//    private EventProducer eventProducer;

    @PostMapping("/follow")
    @ResponseBody
    public String follow(int entityType, int entityId) {
        User user = hostHolder.getUser();

        followService.follow(user.getId(), entityType, entityId);

        //触发关注事件
//        Event event = new Event()
//                .setTopic(TOPIC_FOLLOW)
//                .setUserId(hostHolder.getUser().getId())
//                .setEntityType(entityType)
//                .setEntityId(entityId)
//                .setEntityUserId(entityId);
//        eventProducer.fireEvent(event);

        return CommunityUtil.getJSONString(0, "已关注");
    }

    @RequestMapping(path = "/unfollow", method = RequestMethod.POST)
    @ResponseBody
    public String unfollow(int entityType, int entityId) {
        User user = hostHolder.getUser();

        followService.unfollow(user.getId(), entityType, entityId);

        return CommunityUtil.getJSONString(0, "已取消关注!");
    }


}
