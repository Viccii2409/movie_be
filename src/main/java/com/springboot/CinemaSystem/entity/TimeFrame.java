package com.springboot.CinemaSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.*;

@Data
@Entity
public class TimeFrame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "timeFrameID")
	private long ID;
	private String name;
	private Time timeStart;
	private Time timeEnd;
	private float surcharge;

	@OneToMany(mappedBy = "timeFrame", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<SeatTicket> seatTicket;

}