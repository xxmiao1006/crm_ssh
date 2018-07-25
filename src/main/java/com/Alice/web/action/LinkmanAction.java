package com.Alice.web.action;

import com.Alice.domain.Customer;
import com.Alice.domain.Linkman;
import com.Alice.domain.PageBean;
import com.Alice.service.LinkmanService;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author Alice
 * @date 2018-07-2018/7/25/025-16:26
 */
public class LinkmanAction extends BaseAction implements ModelDriven<Linkman> {
    private  Linkman linkman = new Linkman();
    public Linkman getModel() {
        return linkman;
    }

    private LinkmanService linkmanService;
    public void setLinkmanService(LinkmanService linkmanService) {
        this.linkmanService = linkmanService;
    }

    public String findByPage(){
        //获得离线查询对象
        DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
        //获取联系人名称
        String lkm_name = linkman.getLkm_name();
        if(lkm_name!=null && lkm_name.trim().isEmpty()){
            criteria.add(Restrictions.like("lkm_name","%"+lkm_name+"%"));
        }
        //获取客户
        Customer customer = linkman.getCustomer();
        if (customer != null &&customer.getCust_id()!=null) {
            criteria.add(Restrictions.eq("customer.cust_id",customer.getCust_id()));
        }


        PageBean<Linkman> page = linkmanService.findByPage(this.getPageCode(),this.getPageSize(),criteria);
        this.set("page",page);
        return "page";
    }
}
