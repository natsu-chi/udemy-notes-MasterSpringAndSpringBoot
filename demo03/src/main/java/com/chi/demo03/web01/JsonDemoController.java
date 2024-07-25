package com.chi.demo03.web01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonDemoController {

    @GetMapping(path = "/getjsondemo/str")
    public String getJsonDemoStr() {
        return "ok";
    }

    @GetMapping("/getjsondemo/bean")
    public JsonDemo getJsonDemo() {
        return new JsonDemo(200, "ok");
    }

    // Path Parameters
    @GetMapping("/getjsondemo/{name}")
    public JsonDemo getJsonDemoPath(@PathVariable String name) {
        return new JsonDemo(200, "ok." + name);
    }
}

