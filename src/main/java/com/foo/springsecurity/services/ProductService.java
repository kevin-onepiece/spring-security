package com.foo.springsecurity.services;

import com.foo.springsecurity.entity.Product;
import com.foo.springsecurity.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author foo
 * @since 2022-05-30
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
