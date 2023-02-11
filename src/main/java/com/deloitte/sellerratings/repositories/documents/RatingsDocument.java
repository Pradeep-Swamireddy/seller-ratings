package com.deloitte.sellerratings.repositories.documents;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("ratings")
public class RatingsDocument {
    @Id
    private String ratingId;
    private String sellerId;
    private Integer rating;
    private String userId;
    private String description;
}
