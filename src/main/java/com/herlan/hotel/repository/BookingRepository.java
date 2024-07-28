package com.herlan.hotel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.herlan.hotel.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	@Query("SELECT b FROM Booking b WHERE b.room.id = :roomId "
			+ "AND b.checkIn < :checkOut AND b.checkOut > :checkIn")
    List<Booking> findBookingsForRoom(
            @Param("roomId") Long roomId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut);

	List<Booking> findByRoomId(Long roomId);
					
}
