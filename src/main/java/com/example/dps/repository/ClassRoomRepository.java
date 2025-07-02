package com.example.dps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dps.entity.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer>  {

	Optional<ClassRoom> findById(int classId);
    

}
