package com.server.userservice.user.client;

import com.server.userservice.user.dto.response.UserNutrientResponses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("nutrient-service")
public interface NutrientFeignClient {

    @GetMapping(value = "/api/nutrients/me/{userId}", consumes = "appliaction/json")
    UserNutrientResponses getUserNutrients(@PathVariable Long userId);
}
