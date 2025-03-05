package com.microservice.examtest.controller;

import com.microservice.common.response.BaseResponseEntity;
import com.microservice.common.response.DefaultSuccessResponse;
import com.microservice.common.response.builder.BaseResponseBuilder;
import com.microservice.examtest.consts.ProjectConst;
import com.microservice.examtest.dto.payload.FullTestDTO;
import com.microservice.examtest.dto.response.fulltest.AddPartToFullTestResponseDTO;
import com.microservice.examtest.dto.response.fulltest.CreateFullTestResponseDTO;
import com.microservice.examtest.dto.response.fulltest.UpdateFullTestResponseDTO;
import com.microservice.examtest.exception.BusinessLogicException;
import com.microservice.examtest.service.FullTestService;
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
@RequestMapping(ProjectConst.BASE_URL_FULLTEST)
public class FullTestController {
    private final FullTestService fullTestService;

    @PostMapping("/create")
    public BaseResponseEntity<DefaultSuccessResponse> createFullTest(@RequestBody @Valid CreateFullTestResponseDTO responseDTO) throws BusinessLogicException {
        this.fullTestService.createFullTest(responseDTO);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }

    @GetMapping("/{id}")
    public FullTestDTO getId(@PathVariable String id) throws BusinessLogicException {
        return this.fullTestService.getId(id);
    }

    @GetMapping("/all")
    public List<FullTestDTO> getAllTest() throws BusinessLogicException {
        return this.fullTestService.getAllId();
    }

    @GetMapping("/paged")
    public Page<FullTestDTO> pagedTest(
            @RequestParam(value = "search", required = false) String search,
            @PageableDefault(sort = "lastModifiedAt", direction = Sort.Direction.ASC) Pageable pageable)
            throws BusinessLogicException {
        return this.fullTestService.pagedFullTest(search, pageable);
    }

    @PutMapping("/add")
    public BaseResponseEntity<DefaultSuccessResponse> addPartToFullTest(@RequestBody @Valid AddPartToFullTestResponseDTO responseDTO) throws BusinessLogicException {
        this.fullTestService.addPartToFullTest(responseDTO);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }

    @PutMapping("/{id}")
    public BaseResponseEntity<DefaultSuccessResponse> updateTest(@PathVariable String id, @RequestBody @Valid UpdateFullTestResponseDTO responseDTO) throws BusinessLogicException {
        this.fullTestService.updateTest(id, responseDTO);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }


    @DeleteMapping("/{id}")
    public BaseResponseEntity<DefaultSuccessResponse> deleteTest(@PathVariable String id) throws BusinessLogicException {
        this.fullTestService.deleteTest(id);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponseDeleted());

    }


}
