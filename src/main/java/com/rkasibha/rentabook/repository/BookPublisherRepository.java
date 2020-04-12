package com.rkasibha.rentabook.repository;

import com.rkasibha.rentabook.model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPublisherRepository extends JpaRepository<BookPublisher, Integer> {
}
