package com.sofrecom.applications.controller;



import com.sofrecom.applications.entities.Availablity;
import com.sofrecom.applications.entities.Resources;
import com.sofrecom.applications.entities.TypeResource;
import com.sofrecom.applications.services.IDataCenterService;
import com.sofrecom.applications.services.IResourcesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {
    //////////////////////////////////DataCenter///////////////////////////////////////////////
    private final IDataCenterService idatacenterservice;

    public Controller(IDataCenterService idatacenterservice, IResourcesService iresourcesservice) {
        this.idatacenterservice = idatacenterservice;
        this.iresourcesservice = iresourcesservice;
    }

    @PostMapping("/addDataCenter")
    public String addDataCenter(@RequestBody int id){
        return idatacenterservice.addDataCenter(id);
    }
    //////////////////////////////////Resources///////////////////////////////////////////////

    private final IResourcesService iresourcesservice;

    @PostMapping("/addResources/{id}")
    public String addResources(@RequestBody Resources e, @PathVariable int id){
        return iresourcesservice.addResources(e,id);
    }
    @PutMapping("/updateResources/{id}")
    public String updateResources(@RequestBody Resources e,@PathVariable int id){
        return iresourcesservice.updateResources(e,id);
    }


    @DeleteMapping("/deleteResources/{id}")
    public String deleteResources(@PathVariable int id) {

        return  iresourcesservice.deleteResources(id);
    }
    @GetMapping("/getResourcesById/{id}")
    public Resources getResourcesById(@PathVariable int id){

        return iresourcesservice.getResourcesById(id);
    }
    @GetMapping("/getAllResources")
    public List<Resources> getAllResources(){

        return iresourcesservice.getAllResources();
    }

    @GetMapping("/findByType/{type}/{id}/{a}")
    public List<Resources> findByType(@PathVariable TypeResource type, @PathVariable int id, @PathVariable Availablity a){
        return iresourcesservice.findByType(type,id,a);
    }

    }
