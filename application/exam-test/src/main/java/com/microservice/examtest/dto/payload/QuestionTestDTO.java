package com.microservice.examtest.dto.payload;


import com.microservice.examtest.document.sub.QuestionOption;
import com.microservice.examtest.document.sub.ScoreType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class QuestionTestDTO {
    private String questionId;
    private String questionName;
    private List<QuestionOption> options;
    private ScoreType scoreType;
    private int usedCount;
    private boolean deleted;
}
