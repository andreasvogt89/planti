package com.planti.webcontroller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class JSON_WaterEntry {

    @JsonProperty("plantName")
    private String plantName;

    @JsonProperty("amountOfWater")
    private Integer amountOfWater;

    @JsonProperty("wateringDate")
    private Date wateringDate;

    public JSON_WaterEntry(String plantName, Integer amountOfWater, Date wateringDate) {
        this.plantName = plantName;
        this.amountOfWater = amountOfWater;
        this.wateringDate = wateringDate;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Integer getAmountOfWater() {
        return amountOfWater;
    }

    public void setAmountOfWater(Integer amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public Date getWateringDate() {
        return wateringDate;
    }

    public void setWateringDate(Date wateringDate) {
        this.wateringDate = wateringDate;
    }
}
