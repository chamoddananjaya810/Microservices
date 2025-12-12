package com.microservices.inventory_service.service;


import com.microservices.inventory_service.dto.InventoryResponse;
import com.microservices.inventory_service.model.Inventory;
import com.microservices.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;



    @Transactional(readOnly = true)
    @SneakyThrows
    public  List<InventoryResponse> isInStock(List<String> skuCode){
        log.info("wait Started");
Thread.sleep(10000);
        log.info("wait End");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream().map(
                inventory ->
                    InventoryResponse.builder()
                            .skucode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0).build()

        ).toList();
    }
}
