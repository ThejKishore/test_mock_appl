package com.kish.desig.demoset;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationJpa extends JpaRepository<Reservation,Long> {
    List<Reservation> findAllByLastName(String lastName);
}
