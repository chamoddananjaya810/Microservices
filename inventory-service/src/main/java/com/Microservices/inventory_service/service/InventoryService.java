package com.Microservices.inventory_service.service;


import com.Microservices.inventory_service.dto.InventoryResponse;
import com.Microservices.inventory_service.model.Inventory;
import com.Microservices.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;



    @Transactional(readOnly = true)
    public  List<InventoryResponse> isInStock(List<String> skuCode){
        return inventoryRepository.findBySkuCodeIn(skuCode).stream().map(
                inventory ->
                    InventoryResponse.builder()
                            .skucode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0).build()

        ).toList();
    }
}
