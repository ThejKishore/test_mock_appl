package com.kish.desig.demoset;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DemoController {

    private final ReservationJpa reservationJpa;

    public DemoController(ReservationJpa reservationJpa) {
        this.reservationJpa = reservationJpa;
    }

    @GetMapping("/aboutus")
    public ResponseEntity<String> aboutUs(){
        return ResponseEntity.ok("About us is up and working");
    }


    @GetMapping("/reservations/{lastName}")
    public ResponseEntity<Collection<Reservation>> getReservationDetails(@PathVariable String lastName){
        return  ResponseEntity.ok(this.reservationJpa.findAllByLastName(lastName));
    }


}
