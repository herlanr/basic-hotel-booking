package com.herlan.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.herlan.hotel.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
