package com.qihoo360os.controller;

import com.github.pagehelper.PageInfo;
import com.qihoo360os.common.MybatisPageWrapper;
import com.qihoo360os.common.PageWrapper;
import com.qihoo360os.entity.RealHoaxes;
import com.qihoo360os.model.TpRealHoaxes;
import com.qihoo360os.service.RealHoaxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by i-hexiuyu on 2017/6/27.
 */

@Controller
@RequestMapping("/real-hoaxes")
public class RealHoaxesController {

    public static final int  NAVIGATEPAGES = 5 ;

    @Autowired
    private RealHoaxesService realHoaxesService;

    private int navigatePages = NAVIGATEPAGES;

    @RequestMapping(value = "with-jpa", method = RequestMethod.GET)
    public String getRealHoaxesByPageable(Model model,  @PageableDefault(value = 20) Pageable pageable){
        PageWrapper<RealHoaxes> page = new PageWrapper<>(realHoaxesService.findAll(pageable), "/real-hoaxes");
        model.addAttribute("hoaxes", page.getContent());
        model.addAttribute("page", page);
        return "/content/jpa";
    }

    @RequestMapping("with-mybatis")
    public String findUserPageFromMybatis(Model model, MybatisPageWrapper pageWrapper) {
        pageWrapper.startPage();
        List<TpRealHoaxes> hoaxes = realHoaxesService.selectAll();
        PageInfo pageInfo = pageWrapper.buildPageInfo(hoaxes);
        model.addAttribute("hoaxes", hoaxes);
        model.addAttribute("page", pageInfo);
        //status 200 /404 /500 ,msg , result(Object , JSON), SIZE , PROXY


        return "content/mybatis";
    }
}
