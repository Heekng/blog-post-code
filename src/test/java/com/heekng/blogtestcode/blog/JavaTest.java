package com.heekng.blogtestcode.blog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest {

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
