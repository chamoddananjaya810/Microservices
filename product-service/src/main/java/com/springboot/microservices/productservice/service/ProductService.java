package com.springboot.microservices.productservice.service;

import com.springboot.microservices.productservice.dto.ProductRequest;
import com.springboot.microservices.productservice.dto.ProductResponse;
import com.springboot.microservices.productservice.model.Product;
import com.springboot.microservices.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
//මොකක්ද මේ: මේක තමයි Project එකේ "මොළය" (Business Logic Layer).
//
//කාර්යය: නීති රීති (Validations), ගණනය කිරීම් (Calculations) ඔක්කොම වෙන්නේ මෙතන.
//
//උදාහරණය: Product එකක් save කරන්න කලින්, ඒකේ price එක 0 ට වඩා වැඩිද කියල බලන්න ඕන නම්, ඒ check එක ලියන්නේ Service එකේ.
//
//සම්බන්ධය: Service එක විසින් Repository එක call කරනවා data ගන්න හෝ දාන්න.
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product=Product.builder().
                name(productRequest.getName()).
                description(productRequest.getDescription()).
                price(productRequest.getPrice()).build();


        productRepository.save(product);
        log.info("Product {} is saved",product.getId());
    }
    public List<ProductResponse> getAllProduct(){
        List<Product>products=productRepository.findAll();

      return   products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return   ProductResponse.builder().
                id(product.getId()).
                name(product.getName()).
                description(product.getDescription()).
                price(product.getPrice()).
                build();
    }
}
