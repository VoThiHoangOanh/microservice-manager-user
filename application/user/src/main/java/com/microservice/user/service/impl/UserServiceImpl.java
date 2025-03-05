package com.microservice.user.service.impl;

import com.microservice.sharedmodel.core.utils.WordUtils;
import com.microservice.sharedmodel.enums.ErrorMessage;
import com.microservice.user.document.User;
import com.microservice.sharedmodel.user.dto.UserDTO;
import com.microservice.user.dto.response.UserPayloadDTO;
import com.microservice.user.exception.BusinessLogicException;
import com.microservice.user.mapper.UserMapper;
import com.microservice.user.predicatebuilder.UserPredicateBuilder;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.UserService;
import com.microservice.user.utils.UserUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createOrUpdateUser(UserPayloadDTO payloadDTO) throws BusinessLogicException {
        if (Objects.nonNull(payloadDTO.getId())) {
            this.updateUser(payloadDTO, payloadDTO.getId());
        } else {
            if (this.userRepository.existsByEmail(payloadDTO.getEmail())) {
                throw BusinessLogicException
                        .builder()
                        .errorMessage(ErrorMessage.EMAIL_EXISTED)
                        .params(List.of(payloadDTO.getEmail()))
                        .build();
            }
            User user = new User();
            this.userMapper.create(payloadDTO, user);
            user.setUserId(UserUtils.generateUserId((int) userRepository.count() + 1));
            user.replaceName(payloadDTO.getName());
            this.userRepository.save(user);
        }
    }

    private void updateUser(UserPayloadDTO payloadDTO, String id) throws BusinessLogicException {
        User user = this.getById(id);
        //check email
        userRepository.findByEmail(payloadDTO.getEmail()).ifPresent(userByEmail -> {
            if (!userByEmail.getId().equals(id)) {
                try {
                    throw BusinessLogicException
                            .builder()
                            .errorMessage(ErrorMessage.EMAIL_EXISTED)
                            .params(List.of(payloadDTO.getEmail()))
                            .build();
                } catch (BusinessLogicException e) {
                    log.error("Error: Email existed, {}", payloadDTO.getEmail(), e);
                    throw new RuntimeException(e);
                }
            }
        });

        this.userMapper.updated(payloadDTO, user);
        user.replaceName(payloadDTO.getName());
        this.userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return this.userMapper.toDTOs(userRepository.findAll(UserPredicateBuilder.getNotTrue()));
    }

    @Override
    public Page<UserDTO> getPaged(String search, Pageable pageable) {
        Page<User> users = this.userRepository.findAll(UserPredicateBuilder.getPaged(search), pageable);
        return users.map(this.userMapper::toDTO);
    }

    @Override
    public UserDTO byId(String id) throws BusinessLogicException {
        return this.userMapper.toDTO(this.getById(id));
    }

    @Override
    public Optional<UserDTO> byUserId(String id) {
        return Optional.ofNullable(this.userMapper.toDTO(this.getByUserId(id)));
    }

    private User getByUserId(String testId) {
        return this.userRepository.findOne(UserPredicateBuilder.byUserId(testId)).orElse(null);
    }

    private User getById(String testId) throws BusinessLogicException {
        return this.userRepository
                .findById(testId)
                .orElseThrow(() -> BusinessLogicException
                        .builder()
                        .errorMessage(ErrorMessage.RESOURCE_NOT_FOUND)
                        .params(List.of(testId))
                        .build());
    }

    @Override
    public void deleteById(String id) throws BusinessLogicException {
        User user = this.getById(id);
        user.setDeleted(true);
        this.userRepository.save(user);
    }

    private void initData() {
        User user = new User();
        int size = (int) userRepository.count();
        user.setUserId(UserUtils.generateUserId(size + 1));
        user.setName(UserUtils.generateUserName(size + 1));
        user.setPicture("picture" + size);
        user.setNameNoAccent(WordUtils.toNonVietnamese(user.getName()));
        user.setEmail(UserUtils.generateUserEmail(size));
        this.userRepository.save(user);
    }

    @Override
    public void init() {
        for (int i = 0; i < 30; i++) {
            initData();
        }
    }
}
