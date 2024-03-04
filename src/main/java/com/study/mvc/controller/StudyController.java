package com.study.mvc.controller;

import com.study.mvc.model.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StudyController {

    // MVC
    @GetMapping("/hello")
    public String helloPage(Model model) {
        HelloModel helloModel = HelloModel.builder()
                .name1("1")
                .name2("2")
                .name3("3")
                .build();
        model.addAttribute("helloModel", helloModel);
        return "hello";
    }

//    @GetMapping("/hello")
//    public ModelAndView helloPage() {
//        Map<String, Object> map = new HashMap<>();
//        model.put("name", "김상현");
//        return new ModelAndView("/hello", model);
//    }

    // REST
    @GetMapping("/test")
    @ResponseBody
    public Map<String, Object> testPage() {
        Map<String, Object> testObj = new HashMap<>();
        testObj.put("age", 32);
        return testObj;
    }
}
