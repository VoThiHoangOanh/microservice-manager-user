package com.microservice.examtest.dto.response.part;

import com.microservice.examtest.dto.IRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePartTestResponseDTO implements IRequest {
    private String partName;
    private List<String> questionIds;
}
