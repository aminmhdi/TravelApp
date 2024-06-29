package com.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.entity.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer>, JpaSpecificationExecutor<Cab> {
    @Query(value = "SELECT \n" + //
            "    c.id, c.driver_name, SUM(c.amount) as fare\n" + //
            "FROM\n" + //
            "    travelapp.cab c\n" + //
            "        INNER JOIN\n" + //
            "    book_cab bc ON bc.cab_id = c.id\n" + //
            "WHERE\n" + //
            "\tc.id = :id and\n" + //
            "    bc.finished_date IS NOT NULL\n" + //
            "GROUP BY c.id , c.driver_name;", nativeQuery = true)
    Map<String, Object> getFareById(int id);
}
