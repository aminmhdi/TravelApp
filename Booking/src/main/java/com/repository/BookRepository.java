package com.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.entity.BookCab;

@Repository
public interface BookRepository extends JpaRepository<BookCab, Integer> {
    @Query(value = "select bc.id from book_cab bc where bc.cab_id = :cabId and bc.finished_date is null order by bc.id desc LIMIT 1", nativeQuery = true)
    Integer getByCabId(int cabId);
}
