package com.planti.database;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Timestamp;
import java.util.Date;

public class PlantHistoryLog {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;


    private String nameId;
    private Timestamp waterDates;


}
