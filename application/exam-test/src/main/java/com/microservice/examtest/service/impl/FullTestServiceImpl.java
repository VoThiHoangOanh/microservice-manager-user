package com.microservice.examtest.service.impl;

import com.microservice.examtest.document.FullTest;
import com.microservice.examtest.dto.payload.FullTestDTO;
import com.microservice.examtest.dto.response.fulltest.AddPartToFullTestResponseDTO;
import com.microservice.examtest.dto.response.fulltest.CreateFullTestResponseDTO;
import com.microservice.examtest.dto.response.fulltest.UpdateFullTestResponseDTO;
import com.microservice.examtest.exception.BusinessLogicException;
import com.microservice.examtest.mapper.FullTestMapper;
import com.microservice.examtest.predicatebuilder.FullTestPredicateBuilder;
import com.microservice.examtest.repository.FullTestRepository;
import com.microservice.examtest.service.FullTestService;
import com.microservice.examtest.service.PartTestService;
import com.microservice.sharedmodel.enums.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Slf4j
@AllArgsConstructor
@Service
public class FullTestServiceImpl implements FullTestService {
    private final FullTestRepository fullTestRepository;
    private final PartTestService partTestService;
    private final FullTestMapper fullTestMapper;

    @Override
    public FullTestDTO createFullTest(CreateFullTestResponseDTO responseDTO) throws BusinessLogicException {
        FullTest fullTest = new FullTest();
        this.fullTestMapper.create(responseDTO, fullTest);
        fullTest.replaceName();
        this.fullTestRepository.save(fullTest);
        return this.fullTestMapper.toDTO(fullTest);
    }

    @Override
    public FullTestDTO getId(String id) throws BusinessLogicException {
        return fullTestMapper.toDTO(getById(id));
    }

    @Override
    public FullTestDTO addPartToFullTest(AddPartToFullTestResponseDTO responseDTO) throws BusinessLogicException {
        FullTest fullTest = this.getById(responseDTO.getTestId());
        Set<String> partIds = responseDTO.getPartIds();

        if (fullTest.getPartIds() == null) {
            fullTest.setPartIds(new HashSet<>());
        }
        fullTest.getPartIds().addAll(partIds);
        FullTest afterSave = this.fullTestRepository.save(fullTest);
        if (!partIds.isEmpty()) {
            partTestService.usedCount(partIds);
        }
        return this.fullTestMapper.toDTO(afterSave);
    }


    @Override
    public List<FullTestDTO> getAllId() throws BusinessLogicException {

        return this.fullTestMapper.toDTOs(fullTestRepository.findAll(FullTestPredicateBuilder.getNotTrue()));
    }

    @Override
    public Page<FullTestDTO> pagedFullTest(String search, Pageable pageable) throws BusinessLogicException {
        Page<FullTest> fullTests = this.fullTestRepository.findAll(FullTestPredicateBuilder.getPaged(search), pageable);

        return fullTests.map(this.fullTestMapper::toDTO);
    }


    @Override
    public FullTestDTO updateTest(String id, UpdateFullTestResponseDTO responseDTO) throws BusinessLogicException {
        FullTest fullTests = this.getById(id);
        this.fullTestMapper.updated(responseDTO, fullTests);
        fullTests.replaceName();
        this.fullTestRepository.save(fullTests);
        return this.fullTestMapper.toDTO(fullTests);
    }

    @Override
    public void usedCount(Set<String> ids) {
        List<FullTest> fullTests = this.getIds(ids);
        if (!fullTests.isEmpty()) {
            fullTests.forEach(fullTest -> {
                        fullTest.setUsedCount(fullTest.getUsedCount() + 1);
                    }
            );
        }
        this.fullTestRepository.saveAll(fullTests);

    }

    @Override
    public void deleteTest(String id) throws BusinessLogicException {
        FullTest fullTest = this.getById(id);
        if (fullTest.getUsedCount() == 0) {
            fullTest.setDeleted(true);
            this.fullTestRepository.save(fullTest);
        }

    }

    private FullTest getById(String id) throws BusinessLogicException {
        return fullTestRepository.findOne(FullTestPredicateBuilder.byId(id))
                .orElseThrow(() -> BusinessLogicException
                        .builder()
                        .errorMessage(ErrorMessage.RESOURCE_NOT_FOUND)
                        .params(List.of(id))
                        .build());

    }

    private List<FullTest> getIds(Set<String> ids) {
        return fullTestRepository.findAll(FullTestPredicateBuilder.byIds(ids));

    }

}
