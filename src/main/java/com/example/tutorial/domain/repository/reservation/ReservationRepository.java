package com.example.tutorial.domain.repository.reservation;

import com.example.tutorial.domain.model.ReservableRoomId;
import com.example.tutorial.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository
        extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(
            ReservableRoomId reservableRoomId);
}