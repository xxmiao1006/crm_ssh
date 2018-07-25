package com.Alice.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Alice
 * @date 2018-07-2018/7/25/025-16:44
 */
public class BaseAction extends ActionSupport {
    //属性驱动的方式
    //当前页
    private Integer pageCode=1;
    public void setPageCode(Integer pageCode) {
        if(pageCode==null){
            pageCode=1;
        }
        this.pageCode = pageCode;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    //每显示的数据条数
    private Integer pageSize = 2;
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPageCode() {
        return pageCode;
    }

    /**
     * 压栈的方法
     * @param key
     * @param o
     */
    public void set(String key,Object o ){
        ActionContext.getContext().getValueStack().set(key,o);
    }


    public void push(Object o){
        ActionContext.getContext().getValueStack().push(o);
    }



}
