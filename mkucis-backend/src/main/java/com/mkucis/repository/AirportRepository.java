package com.mkucis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkucis.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
