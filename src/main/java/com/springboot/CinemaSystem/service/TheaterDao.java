package com.springboot.CinemaSystem.service;

import com.springboot.CinemaSystem.dto.TheaterDto;
import com.springboot.CinemaSystem.entity.*;

import java.util.Date;
import java.util.List;

public interface TheaterDao {

	public Theater addTheater(Theater theater);
	public Theater updateTheater(Theater theater);
	public boolean updateStatusTheater(long theaterID);
	public Theater getTheaterByID(long theaterID);
	public long getCountTheater();

	public List<Theater> getAllTheaters();
	public List<TheaterDto> getAllTheaterDto();
	public Room addRoom(Room room);
	public boolean updateStatusRoom(long roomID);
	public List<Room> getRoomByTheater(long theaterID);
	public Room getRoomByID(long roomID);
	public List<Room> getRoomsByTypeRoom(long typeRoomID, long theaterID);
	public boolean addTypeRoom(TypeRoom typeRoom);
	public TypeRoom getTypeRoomByID(long typeRoomID);
	public List<TypeRoom> getAllTypeRooms();
	public boolean addListSeat(List<Seat> seats);
	public boolean addSeat(Seat seat);
	public boolean editSeat(Seat seat);
	public List<Seat> getSeatByRoom(long roomID);
	public Seat getSeatByID(long seatID);
	public boolean addTypeSeat(TypeSeat typeSeat);
	public TypeSeat getTypeSeatByID(long typeSeatID);
	public List<TypeSeat> getAllTypeSeats();
	public float getTheaterStat(Date startDate, Date endDate);
	public boolean updateRoom(Room room);

	public boolean deleteTheater(long id);
}