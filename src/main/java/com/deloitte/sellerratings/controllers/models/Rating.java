package com.deloitte.sellerratings.controllers.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rating {
    private String ratingId;
    @NotBlank
    private String sellerId;
    @NotNull
    private Integer rating;
    @NotBlank
    private String userId;
    private String description;
}
