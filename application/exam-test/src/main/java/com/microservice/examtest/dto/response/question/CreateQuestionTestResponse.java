package com.microservice.examtest.dto.response.question;


import com.microservice.examtest.document.sub.QuestionOption;
import com.microservice.examtest.document.sub.ScoreType;
import com.microservice.examtest.dto.IRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuestionTestResponse implements IRequest {
    private String questionName;
    private List<QuestionOption> options;
    private ScoreType scoreType;
}
