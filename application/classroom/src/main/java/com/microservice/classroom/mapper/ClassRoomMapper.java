package com.microservice.classroom.mapper;

import com.microservice.classroom.document.ClassRoom;
import com.microservice.classroom.dto.payload.ClassRoomDTO;
import com.microservice.classroom.dto.response.CreateClassRoomResponseDTO;
import org.mapstruct.*;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassRoomMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ClassRoomDTO toDTO(ClassRoom entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void create(CreateClassRoomResponseDTO dto, @MappingTarget ClassRoom entity);
}
