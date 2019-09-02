package com.xtt.manager.web;

import com.alibaba.fastjson.JSON;
import com.xtt.common.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Author xuett
 * @Date 2019/9/2 10:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class HelloControllerTest extends ControllerTest {

    @Test
    public void hello() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/hello")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void hello1() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .get("/hello1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .param("name", "xtt")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void hello2() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("name", "xtt");
        httpHeaders.add("age", "29");
        mvc.perform(MockMvcRequestBuilders
                .post("/hello2")
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void hello3() throws Exception {
        User user = User.builder().name("XTT").age(29).build();

        mvc.perform(MockMvcRequestBuilders
                .post("/hello3")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JSON.toJSONString(user))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
