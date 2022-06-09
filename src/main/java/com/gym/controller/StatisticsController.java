package com.gym.controller;

import com.gym.po.BookInfo;
import com.gym.service.BookInfoService;
import com.gym.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StatisticsController {

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private TypeInfoService typeInfoService;

    @GetMapping("statisticIndex")
    public String statistics(Model model){
        //根据图书类型查询图书数量
        List<BookInfo> list = bookInfoService.getBookCountByType();
        model.addAttribute("list",list);
        return "count/statisticIndex";
    }
}
