package com.sofrecom.applications.Controller;



import com.sofrecom.applications.entities.Availablity;
import com.sofrecom.applications.entities.Resources;
import com.sofrecom.applications.entities.TypeResource;
import com.sofrecom.applications.controller.Controller;
import com.sofrecom.applications.services.IDataCenterService;
import com.sofrecom.applications.services.IResourcesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ControllerTest {

    @Mock
    private IResourcesService resourcesService;

    @Mock
    private IDataCenterService dataCenterService;

    @InjectMocks
    private Controller controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addResources() {
        Resources resources = new Resources();
        int id = 1;
        when(resourcesService.addResources(resources, id)).thenReturn("Resources added successfully");
        assertEquals("Resources added successfully", controller.addResources(resources, id));
    }

    @Test
    void updateResources() {
        Resources resources = new Resources();
        resources.setIdResources(1);
        // Set other properties...

        int id = 1;
        when(resourcesService.updateResources(resources, id)).thenReturn("Resources updated successfully");
        assertEquals("Resources updated successfully", controller.updateResources(resources, id));
    }



    @Test
    void deleteResources() {
        int id = 1;
        when(resourcesService.deleteResources(id)).thenReturn("Resources deleted successfully");
        assertEquals("Resources deleted successfully", controller.deleteResources(id));
    }

    @Test
    void getResourcesById() {
        int id = 1;
        Resources resources = new Resources();
        when(resourcesService.getResourcesById(id)).thenReturn(resources);
        assertEquals(resources, controller.getResourcesById(id));
    }

    @Test
    void getAllResources() {
        List<Resources> resourcesList = Collections.singletonList(new Resources());
        when(resourcesService.getAllResources()).thenReturn(resourcesList);
        assertEquals(resourcesList, controller.getAllResources());
    }

    @Test
    void findByType() {
        TypeResource type = TypeResource.CURRAPPLOCALPAAS;
        int id = 1;
        Availablity a = Availablity.AVAILABLE;
        List<Resources> resourcesList = Collections.singletonList(new Resources());
        when(resourcesService.findByType(type, id, a)).thenReturn(resourcesList);
        assertEquals(resourcesList, controller.findByType(type, id, a));
    }

    @Test
    void addDataCenter() {
        int id = 1;
        when(dataCenterService.addDataCenter(id)).thenReturn("DataCenter added successfully");
        assertEquals("DataCenter added successfully", controller.addDataCenter(id));
    }

    // Ajoutez des tests similaires pour les autres méthodes de Controller...
}
