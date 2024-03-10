package com.saraiva.crud.controllers;

import com.saraiva.crud.domain.product.Product;
import com.saraiva.crud.domain.product.ProductRepository;
import com.saraiva.crud.domain.product.RequestProductDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired //injects dependencies| create instance
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProductDTO data){ //
        // the repository (ProductRepository) expects a Product entity (to manipulate the database):
        // that's why it's needed to do the following
        Product newproduct = new Product(data);
        repository.save(newproduct);
        System.out.println(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional //when more than one SQL query is executed
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProductDTO data) {
        Optional<Product> optionalProduct = repository.findById(data.id()); // may get a new obj

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());

            return ResponseEntity.ok(product);
        } else {
            throw new EntityNotFoundException();
            // or, without the exception handler: return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable String id){
        Optional<Product> optionalProduct = repository.findById(id); // may get a new obj

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }


}


