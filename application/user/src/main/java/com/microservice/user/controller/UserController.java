package com.microservice.user.controller;

import com.microservice.user.validator.UserValidator;
import com.microservice.sharedmodel.user.dto.UserDTO;
import com.microservice.user.dto.response.UserPayloadDTO;
import com.microservice.user.exception.BusinessLogicException;
import com.microservice.user.consts.ProjectConst;
import com.microservice.user.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import com.microservice.common.response.BaseResponseEntity;
import com.microservice.common.response.DefaultSuccessResponse;
import com.microservice.common.response.builder.BaseResponseBuilder;

import java.util.List;

@RestController
@RequestMapping(ProjectConst.BASE_URL)
@AllArgsConstructor
public class UserController extends ValidatorController<UserValidator> {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable String id) throws BusinessLogicException {
        return userService.byId(id);
    }
    @GetMapping("/all")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/paged")
    public Page<UserDTO> getPage(
            @RequestParam(value = "search", required = false) String search,
            @PageableDefault(sort = "lastModifiedAt", direction = Sort.Direction.ASC) Pageable pageable)
            throws BusinessLogicException {
        return userService.getPaged(search, pageable);
    }

    @PutMapping("/save")
    public BaseResponseEntity<DefaultSuccessResponse> createUser(@Valid @RequestBody UserPayloadDTO payloadDTO) throws BusinessLogicException {
        this.userService.createOrUpdateUser(payloadDTO);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }
    @PutMapping("/init")
    public BaseResponseEntity<DefaultSuccessResponse> init() throws BusinessLogicException {
        this.userService.init();
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponse());
    }
    @DeleteMapping("/{id}")
    public BaseResponseEntity<DefaultSuccessResponse> deleteUser(@PathVariable String id) throws BusinessLogicException {
        this.userService.deleteById(id);
        return BaseResponseBuilder.ok().body(DefaultSuccessResponse.defaultResponseDeleted());
    }
}
