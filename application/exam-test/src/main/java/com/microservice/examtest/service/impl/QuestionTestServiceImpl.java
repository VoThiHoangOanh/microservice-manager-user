package com.microservice.examtest.service.impl;

import com.microservice.examtest.document.Question;
import com.microservice.examtest.dto.payload.QuestionTestDTO;
import com.microservice.examtest.dto.response.question.CreateQuestionTestResponse;
import com.microservice.examtest.dto.response.question.UpdateQuestionTestResponse;
import com.microservice.examtest.exception.BusinessLogicException;
import com.microservice.examtest.mapper.QuestionTestMapper;
import com.microservice.examtest.predicatebuilder.QuestionPredicateBuilder;
import com.microservice.examtest.repository.QuestionTestRepository;
import com.microservice.examtest.service.QuestionTestService;
import com.microservice.sharedmodel.enums.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class QuestionTestServiceImpl implements QuestionTestService {
    private final QuestionTestRepository questionTestRepository;
    private final QuestionTestMapper questionTestMapper;

    @Override
    public QuestionTestDTO createQuestionTest(CreateQuestionTestResponse responseDTO) {
        Question question = new Question();
        this.questionTestMapper.create(responseDTO, question);
        question.replaceName();
        this.questionTestRepository.save(question);
        return this.questionTestMapper.toDTO(question);
    }

    @Override
    public List<QuestionTestDTO> getAllQuestion() {
        return this.questionTestMapper.toDTOs(questionTestRepository.findAll(QuestionPredicateBuilder.getNotTrue()));
    }

    @Override
    public QuestionTestDTO byId(String id) throws BusinessLogicException {
        return this.questionTestMapper.toDTO(this.getById(id));
    }

    @Override
    public Page<QuestionTestDTO> getPaged(String search, Pageable pageable) throws BusinessLogicException {
        Page<Question> questions = this.questionTestRepository.findAll(QuestionPredicateBuilder.getPaged(search), pageable);
        return questions.map(this.questionTestMapper::toDTO);
    }

    @Override
    public QuestionTestDTO updateQuestionTest(String id, UpdateQuestionTestResponse responseDTO) throws BusinessLogicException {
        Question questions = this.getById(id);
        this.questionTestMapper.updated(responseDTO, questions);
        questions.replaceName();
        this.questionTestRepository.save(questions);
        return this.questionTestMapper.toDTO(questions);
    }

    @Override
    public void usedCount(Set<String> ids) throws BusinessLogicException {
        List<Question> questions = this.getByIds(ids);
        if (!questions.isEmpty()) {
            questions.forEach(question -> {
                question.setUsedCount(question.getUsedCount() + 1);
            });
        }

        this.questionTestRepository.saveAll(questions);
    }

    @Override
    public void deleteQuestion(String id) throws BusinessLogicException {
        Question question = this.getById(id);
        if (question.getUsedCount() == 0) {
            question.setDeleted(true);
            this.questionTestRepository.save(question);
        }
    }

    private Question getById(String id) throws BusinessLogicException {
        return questionTestRepository.findOne(QuestionPredicateBuilder
                        .byId(id))
                .orElseThrow(() -> BusinessLogicException
                        .builder()
                        .errorMessage(ErrorMessage.RESOURCE_NOT_FOUND)
                        .params(List.of(id))
                        .build());
    }

    private List<Question> getByIds(Set<String> ids) {
        return questionTestRepository.findAll(QuestionPredicateBuilder.byIds(ids));
    }

}
