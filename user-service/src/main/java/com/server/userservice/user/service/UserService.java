package com.server.userservice.user.service;

import com.server.userservice.common.entity.BaseEntity;
import com.server.userservice.common.exception.ApplicationException;
import com.server.userservice.user.client.NutrientFeignClient;
import com.server.userservice.user.dto.request.OauthUserRequest;
import com.server.userservice.user.dto.response.OauthUserResponse;
import com.server.userservice.user.dto.response.UserResponse;
import com.server.userservice.user.entity.User;
import com.server.userservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.server.userservice.common.exception.user.UserErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final NutrientFeignClient nutrientFeignClient;

    @Transactional
    public Optional<User> getUser(String nickname){
        return userRepository.findByNicknameAndStatus(nickname, BaseEntity.Status.ACTIVE);
    }

    @Transactional
    public OauthUserResponse createUser(OauthUserRequest oauthUserRequest){
        User user = userRepository.save(oauthUserRequest.toEntity());
        return OauthUserResponse.from(user);
    }

    @Transactional(readOnly = true)
    public UserResponse getMe(String userId){
        User user = userRepository.findById(Long.parseLong(userId))
                .orElseThrow(() -> new ApplicationException(USER_NOT_FOUND));

        return UserResponse.of(user.getNickname(),user.getProfileImageUrl(),nutrientFeignClient.getUserNutrients(Long.parseLong(userId)));
    }

}
