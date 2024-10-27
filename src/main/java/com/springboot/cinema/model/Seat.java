package com.springboot.cinema.model;

import com.springboot.cinema.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Seat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeatID")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "SeatNumber", nullable = false)
    private Integer seatNumber;

    @Column(name = "RowNum", nullable = false)
    private String rowNum;

    @Column(name = "Status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "RoomID", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "TypeSeatID", nullable = false)
    private TypeSeat typeSeat;

    @OneToMany(mappedBy = "seat")
    private Set<SeatReservation> seatReservations;

    @OneToMany(mappedBy = "seat")
    private Set<SeatTicket> seatTickets;

    @OneToMany(mappedBy = "seat")
    private Set<SeatAvailability> seatAvailabilities;
}