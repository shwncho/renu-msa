package com.server.nutrientservice.nutrient.service;

import com.server.nutrientservice.comment.entity.Comment;
import com.server.nutrientservice.comment.repository.CommentRepository;
import com.server.nutrientservice.common.exception.ApplicationException;
import com.server.nutrientservice.nutrient.dto.request.CommentRequest;
import com.server.nutrientservice.nutrient.dto.request.UpdateCommentRequest;
import com.server.nutrientservice.nutrient.dto.response.*;
import com.server.nutrientservice.nutrient.entity.Category;
import com.server.nutrientservice.nutrient.entity.Nutrient;
import com.server.nutrientservice.nutrient.repository.NutrientRepository;
import com.server.nutrientservice.usernutrient.entity.UserNutrient;
import com.server.nutrientservice.usernutrient.repository.UserNutrientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.server.nutrientservice.common.exception.nutrient.NutrientErrorCode.*;

@Service
@RequiredArgsConstructor
public class NutrientService {

    private final NutrientRepository nutrientRepository;
    private final UserNutrientRepository userNutrientRepository;
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public NutrientResponses getNutrientsByCategories(String category){
        return NutrientResponses.from(nutrientRepository.findAllByCategory(Category.toEnum(category))
                .stream()
                .map(NutrientInfo::from)
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public NutrientResponses getNutrientByConditions(String category){
        return NutrientResponses.from(nutrientRepository.findAllByCategory(Category.toEnum(category))
                .stream()
                .map(NutrientInfo::from)
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public NutrientResponse getNutrient(Long id){
        Nutrient nutrient = nutrientRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(NOT_FOUND_NUTRIENT));
        return NutrientResponse.from(nutrient);
    }

    @Transactional
    public void postMyNutrient(String userId, Long id){
        Nutrient nutrient = nutrientRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(NOT_FOUND_NUTRIENT));
        userNutrientRepository.save(UserNutrient.of(nutrient,Long.parseLong(userId)));
    }

    @Transactional
    public void deleteMyNutrient(String userId, Long id){
        Nutrient nutrient = nutrientRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(NOT_FOUND_NUTRIENT));
        userNutrientRepository.deleteByUserIdAndNutrient(Long.parseLong(userId),nutrient);
    }

    @Transactional(readOnly = true)
    public UserNutrientResponses getUserNutrients(Long userId){
        List<UserNutrient> nutrients = userNutrientRepository.findAllByUserId(userId);
        return UserNutrientResponses.from(nutrients.stream()
                .map(n -> UserNutrientResponse.from(n.getNutrient()))
                .collect(Collectors.toList()));
    }

    @Transactional
    public CommentResponse postComment(String userId, Long id, CommentRequest commentRequest){
        Nutrient nutrient = nutrientRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(NOT_FOUND_NUTRIENT));
        return CommentResponse.from(commentRepository.save(Comment.of
                (commentRequest.getContent(),Long.parseLong(userId),nutrient))
                .getId());

    }

    @Transactional
    public void patchComment(String userId, Long commentId, UpdateCommentRequest updateCommentRequest){
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ApplicationException(NOT_FOUND_COMMENT));
        validateUserId(Long.parseLong(userId),commentId);

        comment.changeComment(updateCommentRequest.getContent());

    }

    private void validateUserId(Long userId, Long commentId){
        if(!Objects.equals(userId,commentId)){
            throw  new ApplicationException(INVALID_USER);
        }
    }

    @Transactional
    public void deleteComment(String userId, Long commentId){
        commentRepository.findById(commentId)
                        .orElseThrow(() -> new ApplicationException(NOT_FOUND_COMMENT));
        validateUserId(Long.parseLong(userId),commentId);
        commentRepository.deleteById(commentId);
    }
}
