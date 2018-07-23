package com.Alice.web.action;

import com.Alice.domain.Dict;
import com.Alice.service.DictService;
import com.Alice.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DictAction extends ActionSupport implements ModelDriven<Dict> {
    private Dict dict = new Dict();
    public Dict getModel() {
        return dict;
    }

    private DictService dictService;
    public void setDictService(DictService dictService) {
        this.dictService = dictService;
    }

    /**
     * 通过字段来查询级别，来源等
     * @return
     */
    public String findByCode(){
        //调用业务层
        List<Dict> list = dictService.findByCode(dict.getDict_type_code());
        //转成json类型
        String jsonString = FastJsonUtil.toJSONString(list);
        //获得response对象
        HttpServletResponse response = ServletActionContext.getResponse();
        //写出
        FastJsonUtil.write_json(response,jsonString);

        return NONE;
    }
}
