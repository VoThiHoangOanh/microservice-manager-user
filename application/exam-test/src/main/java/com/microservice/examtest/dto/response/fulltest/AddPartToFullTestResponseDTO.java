package com.microservice.examtest.dto.response.fulltest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddPartToFullTestResponseDTO {
    private String testId;
    private Set<String> partIds;
}
