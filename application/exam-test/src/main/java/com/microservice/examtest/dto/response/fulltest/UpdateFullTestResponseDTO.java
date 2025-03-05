package com.microservice.examtest.dto.response.fulltest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateFullTestResponseDTO {
    private String testName;
    private List<String> partIds;
}
