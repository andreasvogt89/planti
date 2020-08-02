package com.planti.database;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PlantHistoryLog {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne (cascade=CascadeType.ALL)
    private Plant plant;
    private Date waterDate;

    public PlantHistoryLog(Plant plant, Date waterDate) {
        this.plant = plant;
        this.waterDate = waterDate;
    }

    public PlantHistoryLog() {

    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Date getWaterDate() {
        return waterDate;
    }

    public void setWaterDate(Date waterDate) {
        this.waterDate = waterDate;
    }
}
