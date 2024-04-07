package com.store.car.model.mapper;

import com.store.car.model.dto.CarPostDTO;
import com.store.car.model.dto.OwnerPostDTO;
import com.store.car.model.entity.CarPostEntity;
import com.store.car.model.entity.OwnerPostEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerPostEntityMapper {
    OwnerPostEntity toOwnerPostEntity(OwnerPostDTO ownerPostDTO);

    OwnerPostDTO toOwnerPostDTO (OwnerPostEntity ownerPostEntity);
}
