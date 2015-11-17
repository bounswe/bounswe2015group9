package org.bounswe2015.group9.universal_access.daos;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Transactional
public interface IBaseDao<Entity, Key extends Serializable> {

    Session getCurrentSession();

    Key create(Entity t);

    Entity read(Key id);

    Entity merge(Entity t);

    void update(Entity t);

    void delete(Entity t);

    void deleteById(Key id);

    public List<Entity> getAll();

    public List<Entity> readList(Key id);

    public Entity readByProperty(String propertyStr, Object propertyVal);

    public List<Entity> readListByProperty(String propertyStr, Object propertyVal);

    public List<Entity> readyListByIdList(List<Integer> ids);

    public int count();
}