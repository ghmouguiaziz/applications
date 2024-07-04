package com.sofrecom.applications.repositories;



import com.sofrecom.applications.entities.DataCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataCenterRepo extends JpaRepository<DataCenter,Integer> {

}
