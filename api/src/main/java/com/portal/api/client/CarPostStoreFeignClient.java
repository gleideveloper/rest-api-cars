package com.portal.api.client;

import com.portal.api.dto.CarPostDTO;
import com.portal.api.dto.OwnerPostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "carPostStoreClient", url = "${feign.client.address.url}")
public interface CarPostStoreFeignClient {

    @PostMapping("/user")
    void ownerPostClient(@RequestBody OwnerPostDTO newUser);

    @GetMapping("/sales/cars")
    List<CarPostDTO> carForSaleClient();

    @PutMapping("/sales/car/{id}")
    void changeCarForSaleClient(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id);

    @DeleteMapping("/sales/car/{id}")
    void deleteCarForSaleClient(@PathVariable("id") String id);
}
