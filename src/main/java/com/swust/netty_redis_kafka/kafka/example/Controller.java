/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.swust.netty_redis_kafka.kafka.example;

import com.alibaba.fastjson.JSON;
import com.swust.netty_redis_kafka.entity.Position;
import com.swust.netty_redis_kafka.kafka.common.Bar1;
import com.swust.netty_redis_kafka.kafka.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary Russell
 * @since 2.2.1
 */
@RestController
public class Controller {
    @Autowired
    private KafkaTemplate<Object, Object> template;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping(path = "/send/foo")
    public void sendFoo(String what) {
        this.template.send("foos", new Foo1(what));
    }

    @PostMapping(path = "/send/bar")
    public void sendBar(String what) {
        this.template.send("bars", new Bar1(what));
    }

    @PostMapping(path = "/send/position")
    public void sendBar(@RequestBody Position position) {
        this.template.send("position", position);
    }

    @PostMapping(path = "/get/position")
    public String getPosition() {
        String position = JSON.toJSONString( redisTemplate.opsForValue().get("position"));
        this.template.send("position", position);
        return position;
    }

    @PostMapping(path = "/send/unknown")
    public void sendUnknown(String what) {
        this.template.send("bars", what);
    }

}
