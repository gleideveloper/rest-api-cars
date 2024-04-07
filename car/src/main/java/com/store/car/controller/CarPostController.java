package com.store.car.controller;

import com.store.car.model.dto.CarPostDTO;
import com.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    /**
     * Retorna a lista de vendas de carros.
     *
     * @return ResponseEntity<List<CarPostDTO>> Lista de vendas de carros.
     */
    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.ok(carPostService.getCarSales());
    }

    /**
     * Atualiza a venda de um carro.
     *
     * @param carPostDTO Os detalhes atualizados da venda do carro
     * @param id O ID da venda do carro a ser atualizada
     * @return ResponseEntity<Void> ResponseEntity indicando o sucesso da atualização
     */
    @PostMapping("/car/{id}")
    public ResponseEntity<Void> changeCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id){
        carPostService.changeCarSales(carPostDTO, Long.valueOf(id));
        return ResponseEntity.ok().build();
    }

    /**
     * Remove a venda de um carro.
     *
     * @param id O ID da venda do carro a ser removida
     * @return ResponseEntity<Void> ResponseEntity indicando o sucesso da remoção
     */
    @PutMapping("/car/{id}")
    public ResponseEntity<Void> deleteCarSales(@PathVariable("id") String id){
        carPostService.removeCarPost(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }
}
