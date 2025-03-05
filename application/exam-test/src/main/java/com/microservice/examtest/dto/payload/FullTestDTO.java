package com.microservice.examtest.dto.payload;

import com.microservice.examtest.enums.DoTestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class FullTestDTO {
    private String testId;
    private String testName;
    private List<String> partIds;
    private int totalQuestion;
    private long testDuration;
    private int usedCount ;
    private DoTestStatus doTestStatus;
    private boolean deleted;



}
