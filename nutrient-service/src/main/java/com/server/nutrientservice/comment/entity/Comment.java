package com.server.nutrientservice.comment.entity;

import com.server.nutrientservice.common.entity.BaseEntity;
import com.server.nutrientservice.nutrient.entity.Nutrient;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.StringUtils;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String content;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="nutrient_id")
    private Nutrient nutrient;

    @Builder
    public Comment(String content, Long userId, Nutrient nutrient) {
        this.content = content;
        this.userId = userId;
        this.nutrient = nutrient;
    }

    public static Comment of(String content, Long userId, Nutrient nutrient){
        return Comment.builder()
                .content(content)
                .userId(userId)
                .nutrient(nutrient)
                .build();
    }

    public void changeComment(String content){
        if(!StringUtils.hasText(content)){
            this.content = content;
        }
    }
}
