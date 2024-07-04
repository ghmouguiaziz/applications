package com.sofrecom.applications.Entities;

import com.sofrecom.applications.entities.Availablity;
import com.sofrecom.applications.entities.DataCenter;
import com.sofrecom.applications.entities.Resources;
import com.sofrecom.applications.entities.TypeResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

class ResourcesTest {

    private Resources resources;
    @BeforeEach
    void setup(){
        resources=new Resources();
    }

    @Test
    void getIdResources() {
        int id= 1;
        resources.setIdResources(id);
        assertEquals(id,resources.getIdResources());

    }

    @Test
    void getName() {
        String name = "name";
        resources.setName(name);
        assertEquals(name,resources.getName());
    }

    @Test
    void getBcVcpu() {
        int bcvcpu=4;
        resources.setBcVcpu(bcvcpu);
        assertEquals(bcvcpu,resources.getBcVcpu());
    }

    @Test
    void getBcRam() {
        int bcram=3;
        resources.setBcRam(bcram);
        assertEquals(bcram,resources.getBcRam());
    }

    @Test
    void getBcNgVcpu() {
        int bcngvcpu= 3;
        resources.setBcNgVcpu(bcngvcpu);
        assertEquals(bcngvcpu,resources.getBcNgVcpu());
    }

    @Test
    void getBcNgRam() {
        int bcngram=4;
        resources.setBcNgRam(bcngram);
        assertEquals(bcngram,resources.getBcNgRam());
    }

    @Test
    void getIcVcpu() {
        int icvcpu=4;
        resources.setIcVcpu(icvcpu);
        assertEquals(icvcpu,resources.getIcVcpu());
    }

    @Test
    void getIcRam() {
        int icram=4;
        resources.setIcRam(icram);
        assertEquals(icram,resources.getIcRam());
    }

    @Test
    void getPerfStorage() {
        int perfstorage=4;
        resources.setPerfStorage(perfstorage);
        assertEquals(perfstorage,resources.getPerfStorage());
    }

    @Test
    void getCapaStorage() {
        int capastorage=4;
        resources.setCapaStorage(capastorage);
        assertEquals(capastorage,resources.getCapaStorage());
    }

    @Test
    void getHypothesys() {
        String hypothesys="hypo";
        resources.setHypothesys(hypothesys);
        assertEquals(hypothesys,resources.getHypothesys());
    }

    @Test
    void getType() {
        TypeResource type = TypeResource.CURRAPPLOCALPAAS;
        resources.setType(type);
        assertEquals(type,resources.getType());
    }

    @Test
    void getAvailablity() {
        Availablity availablity= Availablity.AVAILABLE;
        resources.setAvailablity(availablity);
        assertEquals(availablity,resources.getAvailablity());
    }

    @Test
    void getDatacenter() {
        DataCenter dataCenter=new DataCenter();
        resources.setDatacenter(dataCenter);
        assertEquals(dataCenter,resources.getDatacenter());
    }
}
