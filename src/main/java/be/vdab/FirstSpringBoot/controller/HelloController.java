package be.vdab.FirstSpringBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String sayHello (){
        return "Beste startpagina";
    }

    @RequestMapping("/hello")
    public String sayHello2 (){
        return "Beste startpagina ooit";
    }


}
