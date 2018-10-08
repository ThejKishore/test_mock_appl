package com.kish.desig.demoset;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;



@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ReservationJpaTest {


    @Autowired
    ReservationJpa reservationJpa;


    @Test
    public void getAllReservation(){

        List<Reservation> saveList = Arrays.asList(new Reservation(null,"Thej","Karuneegar"),
                new Reservation(null,"Shanaya","Karuneegar"),
                new Reservation(null,"Abirami","Karuneegar"));

        reservationJpa.saveAll(saveList);

        Collection<Reservation> reservations = reservationJpa.findAllByLastName("Karuneegar");

        assertThat(reservations).isNotEmpty();
        assertThat(reservations).containsAll(saveList);
    }



}
