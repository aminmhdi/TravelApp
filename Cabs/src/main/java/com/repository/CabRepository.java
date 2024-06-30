package com.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.entity.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer>, JpaSpecificationExecutor<Cab> {
    @Query(value = "SELECT " +
            "c.id, " +
            "c.driver_name, " +
            "SUM(CASE " +
            "WHEN bc.finished_date IS NOT NULL THEN c.amount " +
            "ELSE 0 " +
            "END) AS fare " +
            "FROM " +
            "travelapp.cab c " +
            "LEFT JOIN " +
            "book_cab bc ON bc.cab_id = c.id " +
            "WHERE c.id = :id " +
            "GROUP BY c.id , c.driver_name;", nativeQuery = true)
    Map<String, Object> getFareById(int id);
}
