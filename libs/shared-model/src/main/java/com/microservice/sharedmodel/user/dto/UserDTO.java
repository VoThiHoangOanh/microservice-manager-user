package com.microservice.sharedmodel.user.dto;

import com.microservice.sharedmodel.core.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserDTO extends BaseDTO {
    private String userId;
    private String name;
    private String picture;
    private String phone;
    private String email;
}
