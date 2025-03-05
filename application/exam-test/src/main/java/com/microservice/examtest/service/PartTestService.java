package com.microservice.examtest.service;


import com.microservice.examtest.dto.payload.PartTestDTO;
import com.microservice.examtest.dto.response.part.AddQuestionToPartTestResponseDTO;
import com.microservice.examtest.dto.response.part.CreatePartTestResponseDTO;
import com.microservice.examtest.dto.response.part.UpdatePartTestResponseDTO;
import com.microservice.examtest.exception.BusinessLogicException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface PartTestService {
    PartTestDTO createPartTest(CreatePartTestResponseDTO responseDTO) throws BusinessLogicException;
    PartTestDTO addQuestionToPartTest(AddQuestionToPartTestResponseDTO responseDTO) throws BusinessLogicException;

    PartTestDTO getIdPart(String id) throws BusinessLogicException;

    List<PartTestDTO> getAllPart();

    Page<PartTestDTO> getPaged(String search, Pageable pageable) throws BusinessLogicException;

    PartTestDTO updatePartTest(String id, UpdatePartTestResponseDTO responseDTO) throws BusinessLogicException;

    void usedCount(Set<String> ids);

    void deletePartTest(String id) throws BusinessLogicException;


}
