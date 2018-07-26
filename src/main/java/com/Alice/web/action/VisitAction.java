package com.Alice.web.action;

import com.Alice.domain.PageBean;
import com.Alice.domain.User;
import com.Alice.domain.Visit;
import com.Alice.service.VisitService;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author Alice
 * @date 2018/7/26/026-11:18
 */
@Controller(value = "visitAction")
public class VisitAction extends BaseAction implements ModelDriven<Visit> {


    private Visit visit = new Visit();
    public Visit getModel() {
        return visit;
    }

    @Resource(name = "visitService")
    private VisitService visitService;

    //属性驱动的方式获取参数
    private String beginDate;
    private String endDate;
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public String findByPage(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
        //添加查询条件 每个用户查询自己的拜访记录
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
        if (user == null) {
            return LOGIN;
        }

        //添加接受的条件
        if (endDate != null && !endDate.trim().isEmpty()) {
            criteria.add(Restrictions.le("visit_time",endDate));
        }

        if (beginDate != null && !beginDate.trim().isEmpty()) {
            criteria.add(Restrictions.ge("visit_time",beginDate));
        }



        criteria.add(Restrictions.eq("user.user_id",user.getUser_id()));

        //调用service
        PageBean<Visit> page = visitService.findByPage(this.getPageCode(),this.getPageSize(),criteria);
        this.set("page",page);
        return "page";
    }

    public String save(){
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
        visit.setUser(user);
        visitService.save(visit);
        return "save";
    }

}
