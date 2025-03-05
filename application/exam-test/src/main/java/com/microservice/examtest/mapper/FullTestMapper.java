package com.microservice.examtest.mapper;

import com.microservice.examtest.document.FullTest;
import com.microservice.examtest.dto.payload.FullTestDTO;
import com.microservice.examtest.dto.response.fulltest.CreateFullTestResponseDTO;
import com.microservice.examtest.dto.response.fulltest.UpdateFullTestResponseDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class FullTestMapper {
    @Mapping(target = "testId", source = "id")

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract FullTestDTO toDTO(FullTest entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void create(CreateFullTestResponseDTO dto, @MappingTarget FullTest entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    public abstract void updated(UpdateFullTestResponseDTO dto, @MappingTarget FullTest entity);

    public abstract List<FullTestDTO> toDTOs(List<FullTest> entities);

}
