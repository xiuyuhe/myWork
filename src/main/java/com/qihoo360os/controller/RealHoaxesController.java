package com.qihoo360os.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qihoo360os.common.PageWrapper;
import com.qihoo360os.entity.RealHoaxes;
import com.qihoo360os.entity.RealHoaxesMB;
import com.qihoo360os.mapper.RealHoaxesMapper;
import com.qihoo360os.repository.RealHoaxesRepository;
import com.qihoo360os.service.RealHoaxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private RealHoaxesMapper realHoaxesMapper;
    private int navigatePages = NAVIGATEPAGES;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getRealHoaxesByPageable(Model model,  @PageableDefault(value = 20) Pageable pageable){
        PageWrapper<RealHoaxes> page = new PageWrapper<>(realHoaxesService.findAll(pageable), "/real-hoaxes");
        model.addAttribute("hoaxes", page.getContent());
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "mybatis", method = RequestMethod.GET)
    public void getRealHoaxesByPageableMB(){
        List<RealHoaxesMB> realHoaxes = realHoaxesMapper.findAll();
        System.out.println("");
    }
    @RequestMapping("mybatis/page")
    public String findUserPageFromMybatis(Model model, Integer page, Integer size) {
        page = page == null ? 1 : page;
        size = size == null ? 20: size;
        PageHelper.startPage(page, size);
        List<RealHoaxesMB> hoaxes = realHoaxesMapper.findAll();
        PageInfo pageInfo = new PageInfo(hoaxes, navigatePages);
        model.addAttribute("hoaxes", hoaxes);
        model.addAttribute("page", pageInfo);
        return "mybatis";
    }
}
