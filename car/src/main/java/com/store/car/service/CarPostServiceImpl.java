package com.store.car.service;

import com.store.car.model.dto.CarPostDTO;
import com.store.car.model.entity.CarPostEntity;
import com.store.car.model.mapper.CarPostEntityMapper;
import com.store.car.model.repository.CarPostRepository;
import com.store.car.model.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CarPostServiceImpl implements CarPostService{

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private CarPostEntityMapper carPostEntityMapper;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        var carPostEntity = carPostEntityMapper.toCarPostEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }

    @Override
    public List<CarPostDTO> getCarSales() {
        return carPostRepository.findAll().stream()
                .map(carPostEntityMapper::toCarPostDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void changeCarSales(CarPostDTO carPostDTO, Long postId) {

        var ownerPost = ownerPostRepository.findById(carPostDTO.getOwnerId())
                .orElseThrow(NoSuchElementException::new);
//                .orElseThrow(() -> new RuntimeException("Owner not found"));

        var updateCarPostEntity = CarPostEntity.builder()
                .ownerPost(ownerPost)
                .contact(ownerPost.getContactNumber())
                .model(carPostDTO.getModel())
                .brand(carPostDTO.getBrand())
                .price(carPostDTO.getPrice())
                .city(carPostDTO.getCity())
                .description(carPostDTO.getDescription())
                .engineVersion(carPostDTO.getEngineVersion())
                .createdDate(String.valueOf(new Date()))
                .build();

        carPostRepository.save(updateCarPostEntity);
    }

    @Override
    public void removeCarPost(Long id) {
        carPostRepository.deleteById(id);
    }
}
