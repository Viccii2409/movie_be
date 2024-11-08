package com.springboot.CinemaSystem.entity;

import com.fasterxml.jackson.annotation.*;
import com.springboot.CinemaSystem.dto.RoomDto;
import com.springboot.CinemaSystem.dto.TheaterRoomDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "theaterID")
	private long ID;
	@Column(nullable = false)
	private String name;


	@Lob
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	private String phone;
	private String email;
	private String image;

	@Formula("(SELECT COUNT(r.roomid) from Room r where r.theaterid = theaterID)")
	private int quantityRoom;
	@Column(nullable = false)
	private boolean status;

	@OneToMany(mappedBy = "theater")
	@JsonIdentityReference(alwaysAsId = true)
	private List<Agent> agent;

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonManagedReference(value = "theater-room")
	private List<Room> room;

	@Embedded
	private Address address;

	public TheaterRoomDto toTheaterRoomDto() {
		TheaterRoomDto theaterRoomDto = new TheaterRoomDto();
		theaterRoomDto.setId(this.getID());
		theaterRoomDto.setName(this.getName());

		// Sử dụng Optional để tránh NullPointerException nếu danh sách rooms là null
		List<RoomDto> roomDtos = Optional.ofNullable(this.getRoom())
				.orElse(Collections.emptyList()) // Trả về danh sách trống nếu null
				.stream()
				.map(Room::toRoomDto)
				.collect(Collectors.toList());

		theaterRoomDto.setRoom(roomDtos);
		theaterRoomDto.setStatus(this.isStatus());

		return theaterRoomDto;
	}


}