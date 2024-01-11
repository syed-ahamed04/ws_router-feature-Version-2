package com.shorewise.wiseconnect.router.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shorewise.wiseconnect.router.entity.SwiftMT103Entity;

@Repository
public interface SwiftMT103Repository extends JpaRepository<SwiftMT103Entity, Integer> {
    // You can define custom database operations here
}
