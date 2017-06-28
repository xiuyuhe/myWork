package com.qihoo360os.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by i-hexiuyu on 2017/6/28.
 *
 * url param like : http://www.xx.com/path?size=20?page=1
 */
public class MybatisPageWrapper<T>{
    /**
     *  分页 起始页： 默认1
     */
    private final static Integer PAGEDEFAULT = 1;
    /**
     * 分页 每页条数： 默认20
     */
    private final static Integer SIZEDEFAULT = 20;
    /**
     *  分页 导航条显示长度： 默认5
     */
    private static final int  NAVIGATEPAGESDEFAULT = 5 ;

    private Integer page = PAGEDEFAULT;
    private Integer size = SIZEDEFAULT;
    private Integer defaultNavigatePages = NAVIGATEPAGESDEFAULT;

    public MybatisPageWrapper() {
    }

    public MybatisPageWrapper(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public void startPage(){
        PageHelper.startPage(this.getPage(), this.getSize());
    }

    public PageInfo<T> buildPageInfo(List<T> list){
        return new PageInfo<T>(list, defaultNavigatePages);
    }

    public PageInfo<T> buildPageInfo(List<T> list, int navigatePages){
        return new PageInfo<T>(list, navigatePages);
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
