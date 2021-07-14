package com.linkedinlearning.reactivespring.controller;

import com.linkedinlearning.reactivespring.model.Reservation;
import com.linkedinlearning.reactivespring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping(ReservationResource.ROOM_V_1_RESERVATIONS)
public class ReservationResource {
    public static final String ROOM_V_1_RESERVATIONS = "/room/v1/reservations";
    private ReservationService reservationService;

    @Autowired
    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> getReservationById(@PathVariable String id) {
        return reservationService.getReservation(id);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping(path = "{roomId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> updateReservation(@PathVariable String roomId, @RequestBody Mono<Reservation> reservation) {
        return Mono.just("{}");
    }

    @DeleteMapping(path = "{roomId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Boolean> deleteReservation(@PathVariable String roomId) {
        return Mono.just(true);
    }
}
