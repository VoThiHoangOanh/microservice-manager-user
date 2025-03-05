package com.microservice.user.dto.response;

import com.microservice.user.dto.IRequest;
import com.microservice.sharedmodel.user.dto.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserPayloadDTO extends UserDTO implements IRequest {
}
