package com.tcs.tcsserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TcsServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(TcsServerApplication.class)
                .run(args);
    }
}
