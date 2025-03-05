package com.microservice.examtest.dto.response.fulltest;

import com.microservice.examtest.enums.DoTestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateFullTestResponseDTO {
    private String testName;
    private int totalPart;
    private int totalQuestion;
    private long testDuration;
    private DoTestStatus doTestStatus;

}
