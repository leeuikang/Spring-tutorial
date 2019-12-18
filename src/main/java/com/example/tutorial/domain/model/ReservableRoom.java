package com.example.tutorial.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ReservableRoom implements Serializable {
    private static final long serialVersionUID = 957780691869519467L;

    public ReservableRoomId getReservableRoomId() {
        return reservableRoomId;
    }

    public void setReservableRoomId(ReservableRoomId reservableRoomId) {
        this.reservableRoomId = reservableRoomId;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    @EmbeddedId
    private ReservableRoomId reservableRoomId;
    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    @MapsId("roomId")
    private MeetingRoom meetingRoom;

    public ReservableRoom(ReservableRoomId reservableRoomId) {
        this.reservableRoomId = reservableRoomId;
    }

    public ReservableRoom() { }
}
