package com.sofrecom.applications.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class DataCenter implements Serializable {
    @Id
    private  int idDataCenter;




    @OneToMany(mappedBy = "datacenter", cascade = CascadeType.ALL)
    private List<Resources> resources;





}
