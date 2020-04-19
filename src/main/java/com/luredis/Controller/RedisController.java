package com.luredis.Controller;

import com.luredis.Entity.User;
import com.luredis.Utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public boolean redisset(@RequestParam(name = "key") String key,
                            @RequestParam(name = "value") String value) {
        User user = new User();
        user.setId(1010);
        user.setUsername("JiaoJiao");

        if (redisUtil.hasKey(key)) {
            System.out.println(key + " hasKey!");
            return true;
        } else {
            return redisUtil.set(key, user);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User redisget(String key) {
        User user = (User)redisUtil.get(key);
        return user;
    }

    @RequestMapping(value = "/getExpir", method = RequestMethod.GET)
    public long redisExpir(@RequestParam(name = "key") String key) {
        return redisUtil.getExpire(key);
    }

    @RequestMapping(value = "/setExpir", method = RequestMethod.POST)
    public boolean setExpir(@RequestParam(name = "key") String key,
                            @RequestParam(name = "timeout") long timeout) {
        return redisUtil.expire(key, timeout);
    }
}
