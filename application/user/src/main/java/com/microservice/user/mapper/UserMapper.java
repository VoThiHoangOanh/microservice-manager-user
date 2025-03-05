package com.microservice.user.mapper;

import com.microservice.user.document.User;
import com.microservice.sharedmodel.user.dto.UserDTO;
import com.microservice.user.dto.response.UserPayloadDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserDTO toDTO(User entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void create(UserPayloadDTO dto, @MappingTarget User entity);

    @Mapping(target = "userId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updated(UserPayloadDTO dto, @MappingTarget User entity);



    List<UserDTO> toDTOs(List<User> entities);

}
