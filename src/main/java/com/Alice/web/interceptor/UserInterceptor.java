package com.Alice.web.interceptor;


import com.Alice.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * @author Alice
 * @date 2018/7/26/026-13:29
 */
public class UserInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        // 获取session
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
        if(user == null){
            return "login";
        }
        // 执行下一个拦截器
        return actionInvocation.invoke();
    }
}
