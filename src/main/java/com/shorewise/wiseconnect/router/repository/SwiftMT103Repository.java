package com.shorewise.wiseconnect.router.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwiftMT103Repository extends JpaRepository<SwiftMT103Entity, Integer> {
    // You can define custom database operations here
}
