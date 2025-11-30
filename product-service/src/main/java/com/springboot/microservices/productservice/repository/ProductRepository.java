package com.springboot.microservices.productservice.repository;

import com.springboot.microservices.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
//මොකක්ද මේ: Database එකත් එක්ක කෙලින්ම ගනුදෙනු කරන කොටස (Data Access Layer).
//
//කාර්යය: SQL query ලියන්න මහන්සි වෙන්න ඕන නෑ. Java මගින් data save කරන්න, delete කරන්න, search කරන්න අවශ්‍ය method මේක ඇතුලේ තියෙනවා (Ex: save(), findById()).
//
//සම්බන්ධය: මේක කෙලින්ම Model එකත් එක්ක සම්බන්ධයි.
public interface ProductRepository extends MongoRepository<Product,String> {

}
