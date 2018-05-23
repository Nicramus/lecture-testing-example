package com.globallogic.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
    @RequestMapping("/homepage")
    public String hello() {
        return "<HTML><BODY><i>This is <b>SDP Vehicle Shop api</b> web application. Hello !!!</i></BODY></HTML>";
    }
}
