package com.shorewise.wiseconnect.router.repository;

import com.shorewise.wiseconnect.router.entity.SwiftTransactionDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwiftTransactionDataRepository extends JpaRepository<SwiftTransactionDataEntity, String> {
    // Here, String is the type of the primary key of SwiftTransactionDataEntity
    
    // You can define custom methods if needed
    // For example, if you need to find entities by a specific field
    // List<SwiftTransactionDataEntity> findBySomeField(String someField);
}
