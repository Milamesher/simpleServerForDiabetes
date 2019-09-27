package com.diabetes.simpleserver.DAO;


public interface Dao<Id, Entity> {

    Entity getById(Id id);

    void save(Entity entity);

}