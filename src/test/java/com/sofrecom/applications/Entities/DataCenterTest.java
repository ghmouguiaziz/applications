package com.sofrecom.applications.Entities;

import com.sofrecom.applications.entities.DataCenter;
import com.sofrecom.applications.entities.Resources;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterTest {
     private DataCenter datacenter;

    @BeforeEach
    void setup(){
        datacenter = new DataCenter();
    }

    @Test
    void getIdDataCenter() {
        int id = 1;
        datacenter.setIdDataCenter(id);
        assertEquals(id, datacenter.getIdDataCenter());
    }

    @Test
    void getResources() {
        Resources resources1 = new Resources();
        Resources resources2 = new Resources();
        List<Resources> resources = List.of(resources1,resources2);
        datacenter.setResources(resources);
        assertEquals(resources,datacenter.getResources());


    }
}
