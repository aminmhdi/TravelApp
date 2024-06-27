package com.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.entity.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer>, JpaSpecificationExecutor<Cab> {
}
