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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

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
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));
        return mapToDto(product);
    }

    /* WithOut Stream we should use this , but here Stream done this to us
    List<Product> products = productRepository.findAll();
    List<ProductDto> dtos = new ArrayList<>();

    for(Product p : products) {
        dtos.add(mapToDto(p));
    }

    return dtos; */

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToDto) // product -> this.mapToDto(product)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long id, CreateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found "));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category Not found"));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(category);

        Product updated = productRepository.save(product);

        return mapToDto(updated);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product Not Found"));

        productRepository.deleteById(id);
    }

    // ENTITY -> DTO
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
