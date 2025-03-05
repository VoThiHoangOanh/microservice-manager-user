package com.microservice.examtest.service;

import com.microservice.examtest.dto.payload.QuestionTestDTO;
import com.microservice.examtest.dto.response.question.CreateQuestionTestResponse;
import com.microservice.examtest.dto.response.question.UpdateQuestionTestResponse;
import com.microservice.examtest.exception.BusinessLogicException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface QuestionTestService {
    QuestionTestDTO createQuestionTest (CreateQuestionTestResponse responseDTO);
    List<QuestionTestDTO> getAllQuestion();
    QuestionTestDTO byId (String id) throws BusinessLogicException;
    Page<QuestionTestDTO> getPaged(String search, Pageable pageable) throws BusinessLogicException;
    QuestionTestDTO updateQuestionTest (String id,UpdateQuestionTestResponse responseDTO) throws BusinessLogicException;
    void deleteQuestion(String id) throws BusinessLogicException;
    void usedCount(Set<String> ids) throws BusinessLogicException;






}
