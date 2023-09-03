package com.web.court.service;

import com.web.court.domain.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> query(String courtName);

}
