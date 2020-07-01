package com.planti.database;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class PlantHistoryLog {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;


}
