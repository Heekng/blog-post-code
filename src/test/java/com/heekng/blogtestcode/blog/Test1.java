package com.heekng.blogtestcode.blog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

//@SpringBootTest
public class Test1 {

    @Test
    void javaReplaceDotTest1() throws Exception {
        String url = "aaa.bbb.ccc.ddd";

        String replaceUrl = url.replaceFirst(".", "gg");

        Assertions.assertThat(replaceUrl).isEqualTo("aaaggbbb.ccc.ddd");
    }

    @Test
    void javaReplaceDotTest2() throws Exception {
        String url = "aaa.bbb.ccc.ddd";

        String replaceUrl = url.replaceFirst("[.]", "gg");

        System.out.println("replaceUrl = " + replaceUrl);
        Assertions.assertThat(replaceUrl).isEqualTo("aaaggbbb.ccc.ddd");
    }

}
