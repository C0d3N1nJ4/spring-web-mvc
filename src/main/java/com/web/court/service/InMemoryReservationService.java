package com.web.court.service;

import com.web.court.domain.Player;
import com.web.court.domain.Reservation;
import com.web.court.domain.SportType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InMemoryReservationService implements ReservationService{

    private static final SportType TENNIS = new SportType(1, "Tennis");
    private final List<Reservation> reservations = Collections.synchronizedList(new ArrayList<>());

    public InMemoryReservationService() {
        var roger = new Player("Roger");
        var rafael = new Player("Rafael");
        var date = LocalDate.of(2024, 1, 1);
        reservations.add(new Reservation("Tennis #1", date, 16, roger, TENNIS));
        reservations.add(new Reservation("Tennis #2", date, 20, rafael, TENNIS));
    }

    @Override
    public List<Reservation> query(String courtName) {
        return this.reservations.stream()
                .filter(reservation -> StringUtils.startsWithIgnoreCase(reservation.getCourtName(), courtName))
                .collect(Collectors.toList());
    }
}
