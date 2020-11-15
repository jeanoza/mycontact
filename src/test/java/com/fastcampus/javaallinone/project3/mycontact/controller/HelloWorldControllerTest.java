package com.fastcampus.javaallinone.project3.mycontact.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {
    @Autowired
    private HelloWorldController helloWorldController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld(){
//        System.out.println("test");
        System.out.println(helloWorldController.helloWorld());

        assertThat(helloWorldController.helloWorld()).isEqualTo("HelloWorld");
    }

    @Test
    void mockMvcTest() throws Exception {
        //mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();

        mockMvc.perform(get("/api/helloWorld"))
        .andExpect(status().isOk())// status 가 200성공 인지 알려줌;
        .andExpect(content().string(containsString("HelloWorld")));
    }
}