package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    @GetMapping("")
    public String makeDictionary (@RequestParam(required = false) String eng, Model model) {
        if (eng == null) {
            model.addAttribute("eng", eng);
            return "dictionary";
        }
        List<String> engList = new ArrayList<>();
        engList.add("Mouse");
        engList.add("Cat");
        engList.add("Dog");
        model.addAttribute("eng", eng);
        int index = engList.indexOf(eng);

        List<String> vieList = new ArrayList<>();
        vieList.add("Chuột");
        vieList.add("Mèo");
        vieList.add("Chó");

        String result = vieList.get(index);
        model.addAttribute("result", result);
        return "dictionary";
    }
}
