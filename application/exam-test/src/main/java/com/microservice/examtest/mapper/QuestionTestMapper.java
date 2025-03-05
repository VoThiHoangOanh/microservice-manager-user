package com.microservice.examtest.mapper;
import com.microservice.examtest.document.Question;
import com.microservice.examtest.dto.payload.QuestionTestDTO;
import com.microservice.examtest.dto.response.question.CreateQuestionTestResponse;
import com.microservice.examtest.dto.response.question.UpdateQuestionTestResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionTestMapper {

    @Mapping(target = "questionId", source = "id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    QuestionTestDTO toDTO(Question entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void create(CreateQuestionTestResponse dto, @MappingTarget Question entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updated(UpdateQuestionTestResponse dto, @MappingTarget Question entity);

    List<QuestionTestDTO> toDTOs(List<Question> entities);
}
