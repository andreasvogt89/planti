package com.planti.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Integer> {

    Plant findByName (String plantName);

}
