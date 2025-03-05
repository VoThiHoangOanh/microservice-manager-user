package com.microservice.classroom.repository;

import com.microservice.classroom.document.ClassRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends MongoRepository<ClassRoom, String> {

}
