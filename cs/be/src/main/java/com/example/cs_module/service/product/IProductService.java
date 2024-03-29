package com.example.cs_module.service.product;

import com.example.cs_module.dto.product.ProductDTO;
import com.example.cs_module.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductDTO> findALLProduct(Pageable pageable, String name);
    void create (ProductDTO productDTO);
    void delete (int id);

    Product findById(int id);
}
