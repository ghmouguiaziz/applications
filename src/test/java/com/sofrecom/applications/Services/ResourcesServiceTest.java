package com.sofrecom.applications.Services;


import com.sofrecom.applications.entities.Availablity;
import com.sofrecom.applications.entities.DataCenter;
import com.sofrecom.applications.entities.Resources;

import com.sofrecom.applications.entities.TypeResource;
import com.sofrecom.applications.repositories.ResourcesRepo;
import com.sofrecom.applications.repositories.DataCenterRepo;
import com.sofrecom.applications.services.ResourcesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResourcesServiceTest {
    @Mock
    private ResourcesRepo resourcesRepo;

    @Mock
    private DataCenterRepo dataCenterRepo;

    @InjectMocks
    private ResourcesService resourcesService;


    @Test
    void testAddResources() {
        // Given
        Resources resources = new Resources();
        int dataCenterId = 1;
        DataCenter dataCenter = new DataCenter();
        when(dataCenterRepo.findById(dataCenterId)).thenReturn(Optional.of(dataCenter));

        // When
        String result = resourcesService.addResources(resources, dataCenterId);

        // Then
        assertEquals("added", result);
        verify(resourcesRepo).save(resources);
        verify(dataCenterRepo).findById(dataCenterId);
        assertEquals(dataCenter, resources.getDatacenter());
    }

    @Test
    void updateResources() {
        // Given
        int resourceId = 1;
        Resources existingResources = new Resources();
        existingResources.setIdResources(resourceId);
        when(resourcesRepo.findById(resourceId)).thenReturn(Optional.of(existingResources));
        Resources updatedResources = new Resources();
        updatedResources.setIdResources(resourceId);
        updatedResources.setName("Updated Name");

        // When
        String result = resourcesService.updateResources(updatedResources, resourceId);

        // Then
        assertEquals("updated", result);
        verify(resourcesRepo).saveAndFlush(existingResources);
        assertEquals("Updated Name", existingResources.getName());
    }


    @Test
    void deleteResources() {
        // Given
        int resourceId = 1;

        // When
        String result = resourcesService.deleteResources(resourceId);

        // Then
        assertEquals("deleted", result);
        verify(resourcesRepo).deleteById(resourceId);
    }

    @Test
    void getAllResources() {
        // Given
        List<Resources> resourcesList = Arrays.asList(new Resources(), new Resources());
        when(resourcesRepo.findAll()).thenReturn(resourcesList);

        // When
        List<Resources> result = resourcesService.getAllResources();

        // Then
        assertEquals(resourcesList, result);
        verify(resourcesRepo).findAll();
    }

    @Test
    void getResourcesById() {
        // Given
        int resourceId = 1;
        Resources expectedResources = new Resources();
        when(resourcesRepo.findById(resourceId)).thenReturn(Optional.of(expectedResources));

        // When
        Resources result = resourcesService.getResourcesById(resourceId);

        // Then
        assertEquals(expectedResources, result);
        verify(resourcesRepo).findById(resourceId);
    }

    @Test
    void findByType() {
        // Given
        TypeResource type = TypeResource.CURRAPPLOCALPAAS;
        int dataCenterId = 1;
        Availablity availability = Availablity.AVAILABLE;
        List<Resources> expectedResourcesList = Arrays.asList(new Resources(), new Resources());
        when(resourcesRepo.findByTypeAndDatacenter_IdDataCenterAndAndAvailablity(type, dataCenterId, availability)).thenReturn(expectedResourcesList);

        // When
        List<Resources> result = resourcesService.findByType(type, dataCenterId, availability);

        // Then
        assertEquals(expectedResourcesList, result);
        verify(resourcesRepo).findByTypeAndDatacenter_IdDataCenterAndAndAvailablity(type, dataCenterId, availability);
    }
}
