package com.portal.api.service;

import com.portal.api.client.CarPostStoreFeignClient;
import com.portal.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

//    @Autowired
//    private CarPostStoreClient carPostStoreClient;

    @Autowired
    private CarPostStoreFeignClient carPostStoreClient;

    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        carPostStoreClient.ownerPostClient(ownerPostDTO);
    }
}
