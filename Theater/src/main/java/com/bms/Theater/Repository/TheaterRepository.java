package com.bms.Theater.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.Theater.Entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

    List<Theater> findByTheaterCity(String city);    
}
