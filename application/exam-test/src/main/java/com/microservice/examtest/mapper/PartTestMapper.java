package com.microservice.examtest.mapper;

import com.microservice.examtest.document.Part;
import com.microservice.examtest.document.sub.PartType;
import com.microservice.examtest.dto.payload.PartTestDTO;
import com.microservice.examtest.dto.response.part.CreatePartTestResponseDTO;
import com.microservice.examtest.dto.response.part.UpdatePartTestResponseDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PartTestMapper {
    @Mapping(target = "partId", source = "id")
    @Mapping(target = "pastMessage", source = "partType", qualifiedByName = "replacePartMessage")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract PartTestDTO toDTO(Part entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void create(CreatePartTestResponseDTO dto, @MappingTarget Part entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract  void updated(UpdatePartTestResponseDTO dto, @MappingTarget Part entity);

    public abstract List<PartTestDTO> toDTOs(List<Part> entities);

    @Named("replacePartMessage")
    public String replacePartMessage(PartType partType) {
        if (partType == null) return null;
        return partType.getMessage();
    }

}
