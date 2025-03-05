package com.microservice.classroom.service;

import com.microservice.classroom.dto.payload.ClassRoomDTO;
import com.microservice.classroom.dto.response.AddToClassRoomResponseDTO;
import com.microservice.classroom.dto.response.CreateClassRoomResponseDTO;
import com.microservice.classroom.exception.BusinessLogicException;

public interface ClassRoomService {
    ClassRoomDTO createClassRoom(CreateClassRoomResponseDTO response);
    ClassRoomDTO addToClassRoom(AddToClassRoomResponseDTO response) throws BusinessLogicException;
    void deleteStudentToClassRoom(String classRoomId, String studentId) throws BusinessLogicException;
    void deleteTeacherToClassRoom(String id) throws BusinessLogicException;
}
