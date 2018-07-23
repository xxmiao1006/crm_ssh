package com.Alice.web.action;

import com.Alice.domain.Customer;
import com.Alice.domain.Dict;
import com.Alice.domain.PageBean;
import com.Alice.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    public Customer getModel() {
        return customer;
    }


    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //属性驱动的方式
    //当前页
    private Integer pageCode=1;
    public void setPageCode(Integer pageCode) {
        if(pageCode==null){
            pageCode=1;
        }
        this.pageCode = pageCode;
    }

    //每显示的数据条数
    private Integer pageSize = 2;
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    
    /**
     * 分页查询的方法
     * @return
     */
    public String findByPage(){
        // 调用service业务层
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        // 拼接查询的条件
        String cust_name = customer.getCust_name();
        if(cust_name != null && !cust_name.trim().isEmpty()){
            // 说明，客户的名称输入值了
            criteria.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
        }

        // 拼接客户的级别
        Dict level = customer.getLevel();
        if(level != null && !level.getDict_id().trim().isEmpty()){
            // 说明，客户的级别肯定选择了一个级别
            criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
        }

        // 客户的来源
        Dict source = customer.getSource();
        if(source != null && !source.getDict_id().trim().isEmpty()){
            // 说明，客户的级别肯定选择了一个级别
            criteria.add(Restrictions.eq("source.dict_id", source.getDict_id()));
        }

        // 查询
        PageBean<Customer> page = customerService.findByPage(pageCode,pageSize,criteria);
        // 压栈
        ValueStack vs = ActionContext.getContext().getValueStack();
        // 栈顶是map<"page",page对象>
        vs.set("page", page);
        return "page";
    }

    public void testgit(){
        
    }
    
}
