package com.microservice.classroom.controller;

import com.microservice.classroom.controller.consts.ProjectConst;
import com.microservice.classroom.dto.response.AddToClassRoomResponseDTO;
import com.microservice.classroom.dto.response.CreateClassRoomResponseDTO;
import com.microservice.classroom.exception.BusinessLogicException;
import com.microservice.classroom.service.ClassRoomService;
import com.microservice.common.response.BaseResponseEntity;
import com.microservice.common.response.DefaultSuccessResponse;
import com.microservice.common.response.builder.BaseResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(ProjectConst.BASE_URL)

public class ClassRoomController {
    private final ClassRoomService classRoomService;

    @PostMapping("/create")
    public BaseResponseEntity<DefaultSuccessResponse> createClassRoom(@RequestBody @Valid CreateClassRoomResponseDTO response) {
        classRoomService.createClassRoom(response);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }

    @PutMapping ("/add")
    public BaseResponseEntity<DefaultSuccessResponse> addToClassRoom(@RequestBody @Valid AddToClassRoomResponseDTO response) throws BusinessLogicException {
        classRoomService.addToClassRoom(response);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }
    @DeleteMapping("/{classRoomId}/student/{studentId}")
    public BaseResponseEntity<DefaultSuccessResponse> deleteStudentToClassRoom(@PathVariable String classRoomId, @PathVariable String studentId) throws BusinessLogicException {
        classRoomService.deleteStudentToClassRoom(classRoomId, studentId);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponseDeleted());
    }
    @DeleteMapping("/{id}")
    public BaseResponseEntity<DefaultSuccessResponse> deleteTeacherToClassRoom(@PathVariable String id) throws BusinessLogicException {
        classRoomService.deleteTeacherToClassRoom(id);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponseDeleted());
    }
}
