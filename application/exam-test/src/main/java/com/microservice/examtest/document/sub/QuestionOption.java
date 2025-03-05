package com.microservice.examtest.document.sub;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QuestionOption {
    private String optionId;
    private String nameText;
    private Boolean isCorrect;
}
