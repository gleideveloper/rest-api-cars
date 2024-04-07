package com.store.car.service;

import com.store.car.model.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService{

    void createOwnerPost(OwnerPostDTO ownerPostDTO);

}
