package com.store.car.service;

import com.store.car.model.dto.CarPostDTO;
import com.store.car.model.mapper.CarPostEntityMapper;
import com.store.car.model.repository.CarPostRepository;
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
        var carPostEntity = carPostRepository.findById(postId)
                .orElseThrow(NoSuchElementException::new);

        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));
        carPostEntity.setContact(carPostDTO.getContact());

        carPostRepository.save(carPostEntity);
    }

    @Override
    public void removeCarPost(Long id) {
        carPostRepository.deleteById(id);
    }
}
