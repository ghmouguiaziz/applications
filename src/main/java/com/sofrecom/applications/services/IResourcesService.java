package com.sofrecom.applications.services;



import com.sofrecom.applications.entities.Availablity;
import com.sofrecom.applications.entities.Resources;
import com.sofrecom.applications.entities.TypeResource;

import java.util.List;

public interface IResourcesService {
    public String addResources(Resources af, int id);
    public String updateResources(Resources a ,int id);
    public String deleteResources(int id);
    public List<Resources> getAllResources();
    public Resources getResourcesById(int id);
    public List <Resources> findByType(TypeResource t, int id , Availablity a);
}
