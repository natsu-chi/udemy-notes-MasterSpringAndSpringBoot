package com.chi.demo02.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello") // 路由
    @ResponseBody // 讓內容原樣返回 (純文字)
    public String sayHelloString() {
        return "Hello! What are you learning today?</strong>";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody // 讓內容原樣返回
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<head>");
        sb.append("<body>");
        sb.append("<strong>");
        sb.append("Hello! What are you learning today?");
        sb.append("</strong>");
        sb.append("</body>");
        sb.append("</head>");
        return sb.toString();
    }

    @RequestMapping("say-hello-jsp") // 最前面的 "/" 可加可不加
    public String sayHelloJsp() {
        return "sayHello";
    }

    // @RequestParam 接住 name 變數
    // ModelMap 是 Spring MVC 用來綁定（映射） RequestParam 的方法之一
    // 類似於 Php 中 compact 的功能
    @RequestMapping("say-hello-param")
    public String sayHelloWithReqParam(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        return "sayHelloWithReqParam";
    }
}
