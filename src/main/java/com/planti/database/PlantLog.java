package com.planti.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
public class PlantLog {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    private String name;
    private String type;
    private String description;
    private Integer neededLiterWaterPerWatering;
    private Date lastWatering;
    private long timeToNextWatering;
    private Date nextWatering;
}
