package com.kish.desig.demoset;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReservationJpa extends JpaRepository<Reservation,Long> {
    Collection<Reservation> findAllByLastName(String lastName);
}
