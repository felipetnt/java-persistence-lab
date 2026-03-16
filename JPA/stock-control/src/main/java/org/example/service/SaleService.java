package org.example.service;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.dao.ProductDAO;
import org.example.dao.SaleDAO;
import org.example.exception.ProductNotFoundException;
import org.example.exception.SaleNotFoundException;
import org.example.domain.model.Product;
import org.example.domain.model.Sale;
import org.example.domain.model.SaleProduct;

import java.util.List;
import java.util.UUID;

public class SaleService {

    @Inject
    private SaleDAO saleDAO;

    @Inject
    private ProductDAO productDAO;

    @Inject
    private ClientService clientService;

    @Transactional
    public void createSale(Sale sale) {

        clientService.findById(sale.getClient().getId());

        for (SaleProduct item : sale.getProducts()) {

            Product product = productDAO.search(item.getProduct().getId());

            if (product == null) {
                throw new ProductNotFoundException("Produto não encontrado");
            }

            if (product.getQuantityStock() < item.getQuantity()) {
                throw new RuntimeException("Estoque insuficiente");
            }

            product.setQuantityStock(
                    product.getQuantityStock() - item.getQuantity()
            );

            item.setUnityPrice(product.getPrice());
            item.setSale(sale);
        }

        saleDAO.persistir(sale);
    }

    public Sale findById(UUID id) {

        Sale sale = saleDAO.search(id);

        if (sale == null) {
            throw new SaleNotFoundException("Venda não encontrada");
        }

        return sale;
    }

    public List<Sale> listAll() {
        return saleDAO.listAll();
    }

    @Transactional
    public void delete(UUID id) {

        Sale sale = findById(id);

        saleDAO.delete(sale);
    }
}