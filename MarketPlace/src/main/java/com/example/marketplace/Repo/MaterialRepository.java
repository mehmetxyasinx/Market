package com.example.marketplace.Repo;


import com.example.marketplace.Entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository <MaterialEntity,Long>{


}
