package com.herlan.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herlan.hotel.entity.Room;


public interface RoomRepository extends JpaRepository<Room, Long>{

}
