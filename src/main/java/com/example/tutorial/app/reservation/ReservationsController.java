package com.example.tutorial.app.reservation;

import com.example.tutorial.domain.model.ReservableRoomId;
import com.example.tutorial.domain.model.Reservation;
import com.example.tutorial.domain.service.reservation.ReservationService;
import com.example.tutorial.domain.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("reservations/{date}/{roomId}")
public class ReservationsController {
    @Autowired
    RoomService roomService;

    @Autowired
    ReservationService reservationService;

    @ModelAttribute
    ReservationForm setUpForm(){
        ReservationForm form = new ReservationForm();
        form.setStartTime(LocalTime.of(9,0));
        form.setEndTime(LocalTime.of(10,0));
        return form;
    }

    @RequestMapping(method = RequestMethod.GET)
    String reserveForm(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
                       @PathVariable("roomId") Integer roomId, Model model){
        ReservableRoomId reservableRoomId = new ReservableRoomId(roomId, date);
        List<Reservation> reservations = reservationService
                .findReservations(reservableRoomId);
        List<LocalTime> timeList = Stream
                .iterate(LocalTime.of(0, 0), t -> t.plusMinutes(30))
                .limit(24 * 2).collect(Collectors.toList());
        model.addAttribute("room", roomService.findMeetingRoom(roomId));
        model.addAttribute("reservations", reservations);
        model.addAttribute("timeList", timeList);
        // model.addAttribute("user", dummyUser());
        return "reservation/reserveForm";
    }

}
