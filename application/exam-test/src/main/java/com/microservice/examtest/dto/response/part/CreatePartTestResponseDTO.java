package com.microservice.examtest.dto.response.part;

import com.microservice.examtest.document.sub.PartType;
import com.microservice.examtest.dto.IRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePartTestResponseDTO implements IRequest {
    private String partName;
    private PartType partType;
}
