package com.web.court.controller;

import com.web.court.domain.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.web.court.service.ReservationService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationQueryController {

    private final ReservationService reservationService;

    public ReservationQueryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public void setupForm() {
    }

    @PostMapping
    public String submitForm(@RequestParam("courtName") String courtName, Model model) {
        var reservations = java.util.Collections.<Reservation>emptyList();
        if (courtName != null) {
            reservations = this.reservationService.query(courtName);
        }
        model.addAttribute("reservations", reservations);
        return "/WEB-INF/jsp/reservationQuery.jsp";
    }


}
