package com.example.E_Commerce.Backend.Project.S_Implements;

import com.example.E_Commerce.Backend.Project.dto.CreateProductRequest;
import com.example.E_Commerce.Backend.Project.dto.ProductDto;
import com.example.E_Commerce.Backend.Project.entity.Category;
import com.example.E_Commerce.Backend.Project.entity.Product;
import com.example.E_Commerce.Backend.Project.repository.CategoryRepository;
import com.example.E_Commerce.Backend.Project.repository.ProductRepository;
import com.example.E_Commerce.Backend.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDto createProduct(CreateProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(category);

        Product updated = productRepository.save(product);
        return mapToDto(updated);
    }

    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDto updateProduct(Long id, CreateProductRequest request) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }


    private ProductDto mapToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }
}
