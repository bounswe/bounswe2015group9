package org.bounswe2015.group9.universal_access.daos.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.bounswe2015.group9.universal_access.daos.IBaseDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseDao<T, PK extends Serializable> implements IBaseDao<T, PK> {

    Logger logger = LoggerFactory.getLogger(BaseDao.class);

    protected Class<T> entityClass;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public BaseDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public PK create(T t) {
        return (PK) this.sessionFactory.getCurrentSession().save(t);
    }

    public T read(PK id) {
        return (T) this.sessionFactory.getCurrentSession().get(entityClass, id);
    }

    public T merge(T t) {
        return (T) this.sessionFactory.getCurrentSession().merge(t);
    }

    public void update(T t) {
        this.sessionFactory.getCurrentSession().update(t);
    }


    public void delete(T t) {
        t = (T) this.sessionFactory.getCurrentSession().merge(t);
        this.sessionFactory.getCurrentSession().delete(t);
    }

    public void deleteById(PK id){
        T t = this.read(id);
        if(t!=null){
            getCurrentSession().delete(t);
        }
    }

    public List<T> getAll() {
        final Criteria crit = sessionFactory.getCurrentSession().createCriteria(entityClass);
        return crit.list();
    }



    public List<T> readList(PK id) {
        List <T> list  = (List<T>)sessionFactory.getCurrentSession().get(entityClass,id);

        return list;
    }

    @Override
    public T readByProperty(String propertyStr, Object propertyVal){
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(Restrictions.eq(propertyStr, propertyVal));
        Object result = criteria.uniqueResult();
        return result==null?null:(T)result;
    }

    @Override
    public List<T> readListByProperty(String propertyStr, Object propertyVal){
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(Restrictions.eq(propertyStr, propertyVal));
        Object result = criteria.uniqueResult();
        List <T> list  = (List<T>)criteria.list();
        return list;
    }

    @Override
    public List<T> readyListByIdList(List<Integer> ids) {
        if (ids != null && ids.size() > 0) {
            Criteria criteria = getCurrentSession().createCriteria(entityClass);
            criteria.add(Restrictions.in("id", ids));
            List <T> list  = (List<T>)criteria.list();
            return list;
        } else {
            return new ArrayList<T>();
        }
    }

    @Override
    public int count() {

        return ((Long)getCurrentSession().createQuery("SELECT count(*) FROM " + entityClass.getSimpleName()).uniqueResult()).intValue();
    }
}

