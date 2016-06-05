package com.cleaningrobot.dao.daointerface;

import java.util.List;

public interface ServiceInterface<Entity>
{

    public void create(Entity entity);

    public Entity retrieve (int id);
    public List<Entity> retrieveAll();

    public void update(Entity entity);

    public void delete(int id);
    public void deleteAll();

} // end interface ServiceInterface
