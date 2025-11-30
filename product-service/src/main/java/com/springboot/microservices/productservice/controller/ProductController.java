package com.springboot.microservices.productservice.controller;


import com.springboot.microservices.productservice.dto.ProductRequest;
import com.springboot.microservices.productservice.dto.ProductResponse;
import com.springboot.microservices.productservice.model.Product;
import com.springboot.microservices.productservice.repository.ProductRepository;
import com.springboot.microservices.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//මොකක්ද මේ: පිටත ලෝකය (Frontend / Postman) එක්ක සම්බන්ධ වෙන තැන (API Layer).
//
//කාර්යය: User එවන Request (GET, POST, PUT, DELETE) බාරගැනීම සහ ප්‍රතිඵලය (Response) ආපහු යැවීම. මේක හරියට හෝටලයක "Waiter" වගේ. Order එක අරගෙන Kitchen (Service) එකට දෙනවා.
//
//සම්බන්ධය: Controller එක විසින් Service එක call කරනවා.


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse>getAllProduct(){
        return productService.getAllProduct();
    }


}
