package com.Alice.dao;

import com.Alice.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Alice
 * @date 2018-07-2018/7/25/025-14:46
 * 以后所有的Dao的实现类都可以继承BaseDaoImpl，增删该查分页方法不用在编写
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{


    private Class clazz;
    public BaseDaoImpl(){
        //this表示子类 c表示 CustomerDaoImpl的class对象
        Class c = this.getClass();
        //获取继承的父类BaseDaoImpl<Customer>
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType){
            ParameterizedType ptype = (ParameterizedType) type;
            Type[] types = ptype.getActualTypeArguments();
            this.clazz= (Class) types[0];
        }
    }

    /**
     * 添加
     * @param t
     */
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    /**
     * 删除
     * @param t
     */
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    /**
     * 修改
     * @param t
     */
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    /**
     * 通过主键查询
     * @param id
     * @return
     */
    public T findById(Long id) {
        return (T) this.getHibernateTemplate().get(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
    }

    /**
     * 分页
     * @param pageCode
     * @param pageSize
     * @param criteria
     * @return
     */
    public PageBean<T> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        //创建分页的对象
        PageBean<T> page = new PageBean<T>();
        //一个一个设置
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);

        criteria = criteria.setProjection(Projections.rowCount());
        List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
        if (list != null&&list.size()>0) {
            int totalCount = list.get(0).intValue();
            //总记录数
            page.setTotalCount(totalCount);
        }
        //清楚sql
        criteria.setProjection(null);

        List<T> beanList = (List<T>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode - 1 )* pageSize, pageSize);
        //每页显示的数据
        page.setBeanList(beanList);
        return page;
    }
}
