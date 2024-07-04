package com.sofrecom.applications.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Resources implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResources;
    private String name ;
    private int bcVcpu;
    private int bcRam;
    private int bcNgVcpu;
    private int bcNgRam;
    private int icVcpu;
    private int icRam;
    private int perfStorage;
    private int capaStorage;
    private String hypothesys;

    @Enumerated(EnumType.STRING)
    private TypeResource type;
    @Enumerated(EnumType.STRING)
    private Availablity availablity ;
    @JsonIgnore

    @ManyToOne
    private  DataCenter datacenter;

}
