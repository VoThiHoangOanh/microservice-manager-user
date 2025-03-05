package com.microservice.examtest.service;

import com.microservice.examtest.document.FullTest;
import com.microservice.examtest.dto.payload.FullTestDTO;
import com.microservice.examtest.dto.response.fulltest.AddPartToFullTestResponseDTO;
import com.microservice.examtest.dto.response.fulltest.CreateFullTestResponseDTO;
import com.microservice.examtest.dto.response.fulltest.UpdateFullTestResponseDTO;
import com.microservice.examtest.exception.BusinessLogicException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface FullTestService {
    FullTestDTO createFullTest(CreateFullTestResponseDTO responseDTO) throws BusinessLogicException;
    FullTestDTO addPartToFullTest(AddPartToFullTestResponseDTO responseDTO) throws BusinessLogicException;
    FullTestDTO getId(String id)throws BusinessLogicException;
    List<FullTestDTO> getAllId()throws BusinessLogicException;
    Page<FullTestDTO> pagedFullTest(String search, Pageable pageable) throws BusinessLogicException;
    FullTestDTO updateTest(String id, UpdateFullTestResponseDTO responseDTO) throws BusinessLogicException;
    void usedCount(Set<String> ids);
    void deleteTest(String id)throws BusinessLogicException;
}
