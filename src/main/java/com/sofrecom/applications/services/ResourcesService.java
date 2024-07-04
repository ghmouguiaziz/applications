package com.sofrecom.applications.services;


import com.sofrecom.applications.entities.Availablity;
import com.sofrecom.applications.entities.DataCenter;
import com.sofrecom.applications.entities.Resources;
import com.sofrecom.applications.entities.TypeResource;

import com.sofrecom.applications.repositories.DataCenterRepo;
import com.sofrecom.applications.repositories.ResourcesRepo;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ResourcesService implements IResourcesService {

    private final ResourcesRepo resourcesrepo;

    private final DataCenterRepo datacenterrepo;

    public ResourcesService(ResourcesRepo resourcesrepo, DataCenterRepo datacenterrepo) {
        this.resourcesrepo = resourcesrepo;
        this.datacenterrepo = datacenterrepo;
    }

    @Override
    public String addResources(Resources e, int id) {
        DataCenter dc= datacenterrepo.findById(id).get();
        e.setDatacenter(dc);
        resourcesrepo.save(e);
        return "added";
    }
    @Override
    public String updateResources(Resources dc ,int id) {

        Resources dc1 = resourcesrepo.findById(id).get();
        dc1.setType(dc.getType());
        dc1.setName(dc.getName());
        dc1.setBcRam(dc.getBcRam());
        dc1.setBcVcpu(dc.getBcVcpu());
        dc1.setHypothesys(dc.getHypothesys());
        dc1.setBcNgRam(dc.getBcNgRam());
        dc1.setBcNgVcpu(dc.getBcNgVcpu());
        dc1.setIcVcpu(dc.getIcVcpu());
        dc1.setIcRam(dc.getIcRam());
        dc1.setCapaStorage(dc.getCapaStorage());
        dc1.setPerfStorage(dc.getPerfStorage());
        dc1.setHypothesys(dc.getHypothesys());

        resourcesrepo.saveAndFlush(dc1);
        return "updated";
    }

    @Override
    public String deleteResources(int id) {

        resourcesrepo.deleteById(id);
        return "deleted";
    }
    @Override
    public List<Resources> getAllResources() {

        return resourcesrepo.findAll();
    }
    @Override
    public Resources getResourcesById(int id) {

        return resourcesrepo.findById(id).orElse(null);
    }

    @Override
    public List <Resources> findByType(TypeResource t, int id, Availablity a){
        return resourcesrepo.findByTypeAndDatacenter_IdDataCenterAndAndAvailablity(t , id, a);
    }
}
