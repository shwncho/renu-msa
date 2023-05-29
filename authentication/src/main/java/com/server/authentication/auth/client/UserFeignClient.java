package com.server.authentication.auth.client;

import com.server.authentication.auth.dto.request.SignUpRequest;
import com.server.authentication.auth.entity.User;
import com.server.authentication.oauth.KaKaoOauthUserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient("user-service")
public interface UserFeignClient {

    @GetMapping(value="/api/users", consumes = "application/json")
    Optional<User> getUser(@RequestParam String nickname);

    @PostMapping(value="/api/users", consumes = "application/json")
    User createUser(@RequestBody User user);


}
