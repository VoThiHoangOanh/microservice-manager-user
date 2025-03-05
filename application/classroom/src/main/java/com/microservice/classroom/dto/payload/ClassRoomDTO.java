package com.microservice.classroom.dto.payload;

import com.microservice.sharedmodel.core.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ClassRoomDTO extends BaseDTO {
    private String className;
    private Set<String> studentIds;
    private String teacherId;
    private int quantityMaxStudent;
}
