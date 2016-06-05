package com.cleaningrobot.dao.daointerface;

import java.util.List;

public interface DAOInterface <Entity>
{
    public void create(Entity entity);

    public Entity retrieve(int id);
    public List<Entity> retrieveAll();

    public void update(Entity entity);

    public void delete(Entity entity);
    public void deleteAll();

} // end interface DAOInterface
