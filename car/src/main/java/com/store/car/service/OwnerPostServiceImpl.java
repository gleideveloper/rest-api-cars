package com.store.car.service;

import com.store.car.model.dto.OwnerPostDTO;
import com.store.car.model.mapper.OwnerPostEntityMapper;
import com.store.car.model.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OwnerPostServiceImpl implements OwnerPostService{

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Autowired
    private OwnerPostEntityMapper ownerPostEntityMapper;
    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        var ownerPostEntity = ownerPostEntityMapper.toOwnerPostEntity(ownerPostDTO);
        ownerPostRepository.save(ownerPostEntity);
    }
}
