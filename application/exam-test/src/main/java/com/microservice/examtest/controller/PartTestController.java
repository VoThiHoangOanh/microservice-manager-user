package com.microservice.examtest.controller;

import com.microservice.common.response.BaseResponseEntity;
import com.microservice.common.response.DefaultSuccessResponse;
import com.microservice.common.response.builder.BaseResponseBuilder;
import com.microservice.examtest.consts.ProjectConst;
import com.microservice.examtest.dto.payload.PartTestDTO;
import com.microservice.examtest.dto.response.part.AddQuestionToPartTestResponseDTO;
import com.microservice.examtest.dto.response.part.CreatePartTestResponseDTO;
import com.microservice.examtest.dto.response.part.UpdatePartTestResponseDTO;
import com.microservice.examtest.exception.BusinessLogicException;
import com.microservice.examtest.service.PartTestService;
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
@RequestMapping(ProjectConst.BASE_URL_PART)
public class PartTestController {
    private final PartTestService partTestService;

    @PostMapping("/create")
    public BaseResponseEntity<DefaultSuccessResponse> createPart(@RequestBody @Valid CreatePartTestResponseDTO responseDTO) throws BusinessLogicException {
        this.partTestService.createPartTest(responseDTO);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }

    @GetMapping("/{id}")
    public PartTestDTO getByIdPart(@PathVariable String id) throws BusinessLogicException {
        return this.partTestService.getIdPart(id);

    }

    @GetMapping("/all")
    public List<PartTestDTO> getAllPart() {
        return this.partTestService.getAllPart();
    }

    @GetMapping("/paged")
    public Page<PartTestDTO> pagedPart(
            @RequestParam(value = "search", required = false) String search,
            @PageableDefault(sort = "lastModifiedAt", direction = Sort.Direction.ASC) Pageable pageable)
            throws BusinessLogicException {
        return this.partTestService.getPaged(search, pageable);
    }

    @PutMapping("/{id}")
    public BaseResponseEntity<DefaultSuccessResponse> updatePartTest(@PathVariable String id, @RequestBody @Valid UpdatePartTestResponseDTO responseDTO) throws BusinessLogicException {
        this.partTestService.updatePartTest(id, responseDTO);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }
    @PutMapping("/add")
    public BaseResponseEntity<DefaultSuccessResponse> addQuestionToPart(@RequestBody @Valid AddQuestionToPartTestResponseDTO responseDTO) throws BusinessLogicException{
        this.partTestService.addQuestionToPartTest(responseDTO);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }

    @DeleteMapping("/{id}")
    public BaseResponseEntity<DefaultSuccessResponse> deletePartTest(@PathVariable String id) throws BusinessLogicException {
        this.partTestService.deletePartTest(id);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponseDeleted());

    }

}
