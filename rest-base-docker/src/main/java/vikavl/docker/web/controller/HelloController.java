package vikavl.docker.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value="/hello", method= RequestMethod.POST)
    public String hello(@RequestParam(name = "name") String name){
        return "Hello, " + name + "!";
    }
}
