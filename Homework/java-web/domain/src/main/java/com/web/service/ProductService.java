package com.web.service;

import com.web.entity.product.Product;
import com.web.entity.product.validation.ProductValidator;
import com.web.repository.ProductRepository;
import com.web.service.exceptions.ProductAlreadyExistException;
import com.web.service.exceptions.ValidationException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductValidator productValidator;

    public ProductService(ProductRepository productRepository, ProductValidator productValidator) {
        this.productRepository = productRepository;
        this.productValidator = productValidator;
    }

    public Product saveToRepository(Product product) {
        List<String> validationResults = productValidator.validate(product);
        if (!validationResults.isEmpty()) {
            throw new ValidationException(
                "Product was not save to the repository because:\n"
                    + String.join("\n", validationResults)
            );
        } else if (productRepository.getAll().contains(product)) {
            throw new ProductAlreadyExistException(
                "Product was not added to the repository because it is already there."
            );
        }

        return productRepository.saveToRepository(product);
    }

    public Product deleteFromRepository(String productName) {
        if (Objects.isNull(productName)) {
            throw new IllegalArgumentException(
                "Can't delete product with name equal null"
            );
        }

        return productRepository.deleteFromRepository(productName);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public List<Product> getAllSorted(Comparator<Product> comparator) {

        return productRepository.getAll().stream()
            .sorted(comparator)
            .toList();
    }
}
