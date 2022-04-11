package com.example.shop;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer { //TODO зачем? :) и зачем выносить настройки логов в отдельный конфиг?

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShopApplication.class);
    }

}
