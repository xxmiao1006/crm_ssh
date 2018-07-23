package com.Alice.web.action;

import com.Alice.domain.User;
import com.Alice.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    public User getModel() {
        return user;
    }

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 注册的方法
     * @return
     */
    public String regist(){
        userService.save(user);
        return LOGIN;
    }

    /**
     * 检查用户名是否已经注册
     * @return
     */
    public String checkCode(){
        //调用业务层查询
        User u = userService.checkCode(user.getUser_code());
        //获取response
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            if(u!=null){
                //查询到用户。用户名存在
                writer.print("no");
            }else {
                //不存在，可以注册
                writer.print("yes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return NONE;
    }

    public String login(){
        User existUser = userService.login(user);
        // 判断，登录名或者密码错误了
        if(existUser == null){
            return LOGIN;
        }else{
            ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
            // 登录成功
            return "loginOK";
        }
    }

    /**
     * 退出功能
     * @return
     */
    public String exit(){
        ServletActionContext.getRequest().getSession().removeAttribute("existUser");
        return LOGIN;
    }
}
