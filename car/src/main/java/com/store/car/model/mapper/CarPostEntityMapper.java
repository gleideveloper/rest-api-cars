package com.store.car.model.mapper;

import com.store.car.model.dto.CarPostDTO;
import com.store.car.model.entity.CarPostEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarPostEntityMapper {
    CarPostEntity toCarPostEntity(CarPostDTO carPostDTO);

    CarPostDTO toCarPostDTO (CarPostEntity carPostEntity);
}
