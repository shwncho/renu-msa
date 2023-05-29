package com.server.nutrientservice.nutrient.controller;

import com.server.nutrientservice.nutrient.dto.request.CommentRequest;
import com.server.nutrientservice.nutrient.dto.request.UpdateCommentRequest;
import com.server.nutrientservice.nutrient.dto.response.CommentResponse;
import com.server.nutrientservice.nutrient.dto.response.NutrientResponse;
import com.server.nutrientservice.nutrient.dto.response.NutrientResponses;
import com.server.nutrientservice.nutrient.dto.response.UserNutrientResponses;
import com.server.nutrientservice.nutrient.service.NutrientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nutrients")
@RequiredArgsConstructor
public class NutrientController {

    private final NutrientService nutrientService;

    @GetMapping("/categories")
    public NutrientResponses getNutrientsByCategories(@RequestParam String category){
        return nutrientService.getNutrientsByCategories(category);
    }

    @GetMapping("/conditions")
    public NutrientResponses getNutrientsByConditions(@RequestParam String category){
        return nutrientService.getNutrientByConditions(category);
    }

    @GetMapping("/{id}")
    public NutrientResponse getNutrient(@PathVariable Long id){
        return nutrientService.getNutrient(id);
    }

    @PostMapping("{id}")
    public void postMyNutrient(@RequestHeader("user_id") String userId,
                                 @PathVariable Long id)
    {
        nutrientService.postMyNutrient(userId, id);
    }

    @DeleteMapping("{id}")
    public void deleteMyNutrient(@RequestHeader("user_id") String userId,
                                 @PathVariable Long id)
    {
        nutrientService.deleteMyNutrient(userId, id);
    }

    @GetMapping("/me/{userId}")
    public UserNutrientResponses getUserNutrients(@PathVariable Long userId){
        return nutrientService.getUserNutrients(userId);
    }

    @PostMapping("/{id}/comment")
    public CommentResponse postComment(@RequestHeader("user_id") String userId,
                                       @PathVariable Long id, @RequestBody CommentRequest commentRequest)
    {
        return nutrientService.postComment(userId, id, commentRequest);
    }

    @PatchMapping("/comment/{commentId}")
    public void patchComment(@RequestHeader("user_id") String userId,
                             @PathVariable Long commentId, @RequestBody UpdateCommentRequest updateCommentRequest)
    {
        nutrientService.patchComment(userId,commentId,updateCommentRequest);
    }

    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@RequestHeader("user_id") String userId,
                              @PathVariable Long commentId)
    {
        nutrientService.deleteComment(userId,commentId);
    }

}
