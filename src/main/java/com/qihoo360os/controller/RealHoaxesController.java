package com.qihoo360os.controller;

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

import java.util.List;

/**
 * Created by i-hexiuyu on 2017/6/27.
 */

@Controller
@RequestMapping("/real-hoaxes")
public class RealHoaxesController {

    @Autowired
    private RealHoaxesService realHoaxesService;

    @Autowired
    private RealHoaxesMapper realHoaxesMapper;

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
}
