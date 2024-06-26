package com.store.car.service;

import com.store.car.model.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO);
    List<CarPostDTO> getCarSales();
    void changeCarSales(CarPostDTO carPostDTO, Long postId);
    void removeCarPost(Long id);
}
