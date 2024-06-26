package com.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.BookCab;

@Repository
public interface BookCabRepository extends JpaRepository<BookCab, Integer> {

}
