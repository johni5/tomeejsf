package com.del.tomeejsf.web;

import com.del.tomeejsf.db.City;
import com.del.tomeejsf.server.CityManager;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by DodolinEL
 * date: 03.06.2024
 */
@ViewScoped
@ManagedBean
public class IndexController {

    private static final Logger log = Logger.getLogger(IndexController.class);

    @Inject
    private CityManager cityManager;

    private List<City> rows;
    private String name;
    private Long selectedId;
    private String tab1 = "Привет";
    private String tab2 = "Мир";

    public IndexController() {
    }

    public String getTab1() {
        return tab1;
    }

    public String getTab2() {
        return tab2;
    }

    public List<City> getRows() {
        if (rows == null) {
            rows = cityManager.getList();
        }
        return rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Long selectedId) {
        this.selectedId = selectedId;
    }

    public void reset() {
        rows = null;
    }

    public void add() {
        if (name != null && name.trim().length() > 0) {
            cityManager.add(name);
            reset();
            name = null;
        }
    }

    public void delete() {
        if (selectedId != null) {
            try {
                cityManager.delete(selectedId);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            reset();
        }
    }

}
