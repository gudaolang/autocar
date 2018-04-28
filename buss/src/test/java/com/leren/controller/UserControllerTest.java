package com.leren.controller;

import com.leren.BussApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author lee
 * @Date:22/02/2018
 */
@SpringBootTest(classes = BussApplication.class)
public class UserControllerTest extends BaseJunitTest {

    private MockMvc mvc;

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Before
    public void setUp() {
//        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void getUserList() throws Exception {
        RequestBuilder request = null;
        request = get("/list");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void postUser() throws Exception {
        RequestBuilder request = null;
        request = post("").param("userName", "xiaolee").param("password", "pwd").param("userCode", "我是小龙");
        mvc.perform(request)
                .andExpect(status().isOk()).andDo(print());

        request = get("/list");
        mvc.perform(request)
                .andExpect(status().isOk()).andDo(print());
    }

//    @Test
//    public void testSave() {
//        userRepository.save(new ShopEmp(UUID.randomUUID().toString(), "xiaoming", "222", null));
//    }

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("key", "100");
        Assert.assertEquals("200", stringRedisTemplate.opsForValue().get("key"));
    }
}
