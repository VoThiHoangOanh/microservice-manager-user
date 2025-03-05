package com.microservice.classroom.dto.response;

import com.microservice.classroom.enums.RoleClassRoom;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddToClassRoomResponseDTO {
    private String classId;
    private String userId;
    private RoleClassRoom role;
}
