package com.sofrecom.applications.repositories;


import com.sofrecom.applications.entities.Availablity;
import com.sofrecom.applications.entities.Resources;
import com.sofrecom.applications.entities.TypeResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourcesRepo extends JpaRepository<Resources,Integer> {



    List<Resources> findByTypeAndDatacenter_IdDataCenterAndAndAvailablity(TypeResource type, int id, Availablity a);
}
