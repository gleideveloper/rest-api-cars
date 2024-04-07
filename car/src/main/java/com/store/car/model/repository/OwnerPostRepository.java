package com.store.car.model.repository;

import com.store.car.model.entity.CarPostEntity;
import com.store.car.model.entity.OwnerPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, Long> {
}
