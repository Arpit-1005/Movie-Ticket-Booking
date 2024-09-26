package com.bms.city.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.city.Entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    public CityEntity findByName(String name);
    
}
