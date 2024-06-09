package com.del.tomeejsf.server;

import com.del.tomeejsf.db.City;

import java.util.List;

public interface CityManager {

    City add(String name);

    List<City> getList();

    void delete(Long id);

}
