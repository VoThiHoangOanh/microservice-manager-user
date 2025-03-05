package com.microservice.examtest.dto.response.part;

import com.microservice.examtest.dto.IRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddQuestionToPartTestResponseDTO implements IRequest {
    private String partId;
    private Set<String> questionIds;
}
