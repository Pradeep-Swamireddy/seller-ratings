package com.deloitte.sellerratings.repositories;

import com.deloitte.sellerratings.repositories.documents.RatingsDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingsRepository extends MongoRepository<RatingsDocument, String> {
    List<RatingsDocument> findAllBySellerId(String seller);
}
