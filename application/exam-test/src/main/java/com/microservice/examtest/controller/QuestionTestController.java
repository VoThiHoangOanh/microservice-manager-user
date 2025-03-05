package com.microservice.examtest.controller;


import com.microservice.common.response.BaseResponseEntity;
import com.microservice.common.response.DefaultSuccessResponse;
import com.microservice.common.response.builder.BaseResponseBuilder;
import com.microservice.examtest.consts.ProjectConst;
import com.microservice.examtest.dto.payload.QuestionTestDTO;
import com.microservice.examtest.dto.response.question.CreateQuestionTestResponse;
import com.microservice.examtest.dto.response.question.UpdateQuestionTestResponse;
import com.microservice.examtest.exception.BusinessLogicException;
import com.microservice.examtest.service.QuestionTestService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(ProjectConst.BASE_URL_QUESTION)
public class QuestionTestController {
    private final QuestionTestService questionTestService;

    @PostMapping("create")
    public BaseResponseEntity<DefaultSuccessResponse> createQuestion(@RequestBody @Valid CreateQuestionTestResponse responseDTO) {
        questionTestService.createQuestionTest(responseDTO);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }

    @GetMapping("/{id}")
    public QuestionTestDTO getById(@PathVariable String id) throws BusinessLogicException {
        return questionTestService.byId(id);
    }

    @GetMapping("/all")
    public List<QuestionTestDTO> getAll() {
        return questionTestService.getAllQuestion();
    }

    @GetMapping("/paged")
    public Page<QuestionTestDTO> getPage(
            @RequestParam(value = "search", required = false) String search,
            @PageableDefault(sort = "lastModifiedAt", direction = Sort.Direction.ASC) Pageable pageable)
            throws BusinessLogicException {
        return questionTestService.getPaged(search, pageable);
    }

    @PutMapping("/{id}")
    public BaseResponseEntity<DefaultSuccessResponse> updateQuestion(@PathVariable String id, @RequestBody @Valid UpdateQuestionTestResponse responseDTO) throws BusinessLogicException {
        questionTestService.updateQuestionTest(id, responseDTO);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }

    @DeleteMapping({"/{id}"})
    public BaseResponseEntity<DefaultSuccessResponse> deleteQuestion(@PathVariable String id) throws BusinessLogicException {
        this.questionTestService.deleteQuestion(id);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponseDeleted());

    }


}
