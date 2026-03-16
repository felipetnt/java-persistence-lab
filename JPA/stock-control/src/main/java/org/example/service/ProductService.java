package org.example.service;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.dao.ProductDAO;
import org.example.exception.ProductNotFoundException;
import org.example.domain.model.Product;

import java.util.List;
import java.util.UUID;

public class ProductService {

    @Inject
    private ProductDAO productDAO;

    @Transactional
    public void create(Product product) {
        productDAO.persistir(product);
    }

    public Product findById(UUID id) {
        Product product = productDAO.search(id);

        if (product == null) {
            throw new ProductNotFoundException("Produto não encontrado");
        }

        return product;
    }

    public List<Product> listAll() {
        return productDAO.listAll();
    }

    @Transactional
    public void update(UUID id, Product updatedData) {

        Product product = findById(id);

        product.setName(updatedData.getName());
        product.setPrice(updatedData.getPrice());
        product.setQuantityStock(updatedData.getQuantityStock());
    }

    @Transactional
    public void delete(UUID id) {

        Product product = findById(id);

        productDAO.delete(product);
    }
}