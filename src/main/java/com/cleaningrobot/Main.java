package com.cleaningrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@ComponentScan()
@Controller
public class Main extends SpringBootServletInitializer
{

    @RequestMapping(value = "/")
    public static String loadHomePage()
    {
        return "/site/home";

    } // end method loadHomePage

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Main.class);

    } // end method configure

    public static void main (String[] args)
    {
        SpringApplication.run(Main.class, args);

    } // end main

} // end class Main
