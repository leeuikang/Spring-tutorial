package com.example.tutorial.domain.repository.room;

import com.example.tutorial.domain.model.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRoomRepository
        extends JpaRepository<MeetingRoom, Integer> {
}
