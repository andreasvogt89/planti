package com.planti.database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Plant {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String type;
    private String description;
    private Integer neededLiterWaterPerWatering;
    private Date lastWatering;
    private long timeToNextWatering;
    private Date nextWatering;


    public Plant(String name, String type, String description,
                 Integer neededLiterWaterPerWatering, Date lastWatering,
                 long timeToNextWatering) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.neededLiterWaterPerWatering = neededLiterWaterPerWatering;
        this.timeToNextWatering = timeToNextWatering;
        this.lastWatering = lastWatering;
        this.nextWatering = new Date(lastWatering.getTime() + timeToNextWatering);
    }

    public Plant(){

    }

    @OneToMany(mappedBy = "plant",cascade=CascadeType.ALL)
    private List<PlantHistoryLog> plantHistoryLog = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNeededLiterWaterPerWatering() {
        return neededLiterWaterPerWatering;
    }

    public void setNeededLiterWaterPerWatering(Integer neededLiterWaterPerWatering) {
        this.neededLiterWaterPerWatering = neededLiterWaterPerWatering;
    }

    public Date getLastWatering() {
        return lastWatering;
    }

    public void setLastWatering(Date lastWatering) {
        this.lastWatering = lastWatering;
    }

    public long getTimeToNextWatering() {
        return timeToNextWatering;
    }

    public void setTimeToNextWatering(long timeToNextWatering) {
        this.timeToNextWatering = timeToNextWatering;
    }

    public Date getNextWatering() {
        return nextWatering;
    }

    public void setNextWatering(Date nextWatering) {
        this.nextWatering = nextWatering;
    }

    public List<PlantHistoryLog> getPlantHistoryLog() {
        return plantHistoryLog;
    }

    public void setPlantHistoryLog(List<PlantHistoryLog> plantHistoryLog) {
        this.plantHistoryLog = plantHistoryLog;
    }
}
