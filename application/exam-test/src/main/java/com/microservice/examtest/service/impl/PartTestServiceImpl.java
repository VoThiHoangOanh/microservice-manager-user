package com.microservice.examtest.service.impl;

import com.microservice.examtest.document.Part;
import com.microservice.examtest.dto.payload.PartTestDTO;
import com.microservice.examtest.dto.response.part.AddQuestionToPartTestResponseDTO;
import com.microservice.examtest.dto.response.part.CreatePartTestResponseDTO;
import com.microservice.examtest.dto.response.part.UpdatePartTestResponseDTO;
import com.microservice.examtest.exception.BusinessLogicException;
import com.microservice.examtest.mapper.PartTestMapper;
import com.microservice.examtest.predicatebuilder.PartPredicateBuilder;
import com.microservice.examtest.repository.PartTestRepository;
import com.microservice.examtest.service.PartTestService;
import com.microservice.examtest.service.QuestionTestService;
import com.microservice.sharedmodel.enums.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class PartTestServiceImpl implements PartTestService {
    private final PartTestRepository partTestRepository;
    private final PartTestMapper partTestMapper;

    private final QuestionTestService questionTestService;

    @Override
    public PartTestDTO createPartTest(CreatePartTestResponseDTO responseDTO) throws BusinessLogicException {
        Part part = new Part();
        this.partTestMapper.create(responseDTO, part);
        part.replaceName();
        this.partTestRepository.save(part);
        return this.partTestMapper.toDTO(part);
    }

    @Override
    public PartTestDTO addQuestionToPartTest(AddQuestionToPartTestResponseDTO responseDTO) throws BusinessLogicException {
        Part part = this.getById(responseDTO.getPartId());

        Set<String> questionIds = responseDTO.getQuestionIds();


        if (part.getQuestionIds() == null) {
            part.setQuestionIds(new HashSet<>());
        }
        part.getQuestionIds().addAll(questionIds);
        Part afterSave = this.partTestRepository.save(part);

        if (!questionIds.isEmpty()) {
            questionTestService.usedCount(questionIds);

        }


        return this.partTestMapper.toDTO(afterSave);

    }

    @Override
    public PartTestDTO getIdPart(String id) throws BusinessLogicException {
        return this.partTestMapper.toDTO(getById(id));
    }

    @Override
    public List<PartTestDTO> getAllPart() {
        return this.partTestMapper.toDTOs(partTestRepository.findAll(PartPredicateBuilder.getNotTrue()));
    }

    @Override
    public Page<PartTestDTO> getPaged(String search, Pageable pageable) throws BusinessLogicException {
        Page<Part> parts = this.partTestRepository.findAll(PartPredicateBuilder.getPaged(search), pageable);
        return parts.map(this.partTestMapper::toDTO);
    }

    @Override
    public PartTestDTO updatePartTest(String id, UpdatePartTestResponseDTO responseDTO) throws BusinessLogicException {
        Part parts = this.getById(id);
        this.partTestMapper.updated(responseDTO, parts);
        parts.replaceName();
        this.partTestRepository.save(parts);
        return this.partTestMapper.toDTO(parts);
    }

    @Override
    public void usedCount(Set<String> ids) {
        List<Part> parts = this.getByIds(ids);
        if (!parts.isEmpty()) {
            parts.forEach(part -> {
                        part.setUsedCount(part.getUsedCount() + 1);
                    }
            );
        }
        this.partTestRepository.saveAll(parts);
    }

    @Override
    public void deletePartTest(String id) throws BusinessLogicException {
        Part part = this.getById(id);
        if (part.getUsedCount() == 0) {
            part.setDeleted(true);
            this.partTestRepository.save(part);
        }

    }

    private Part getById(String id) throws BusinessLogicException {
        return partTestRepository.findOne(PartPredicateBuilder.byId(id))
                .orElseThrow(() -> BusinessLogicException
                        .builder()
                        .errorMessage(ErrorMessage.RESOURCE_NOT_FOUND)
                        .params(List.of(id))
                        .build());

    }

    private List<Part> getByIds(Set<String> ids) {
        return partTestRepository.findAll(PartPredicateBuilder.byIds(ids));
    }

}
