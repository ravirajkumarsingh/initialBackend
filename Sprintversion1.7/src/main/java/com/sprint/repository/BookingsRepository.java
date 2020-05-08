package com.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entity.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {

}
