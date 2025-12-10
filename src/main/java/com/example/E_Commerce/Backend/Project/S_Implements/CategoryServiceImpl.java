package com.example.E_Commerce.Backend.Project.S_Implements;

import com.example.E_Commerce.Backend.Project.dto.CategoryDto;
import com.example.E_Commerce.Backend.Project.entity.Category;
import com.example.E_Commerce.Backend.Project.repository.CategoryRepository;
import com.example.E_Commerce.Backend.Project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto dto){
        Category category = mapToEntity(dto);
        category = categoryRepository.save(category);
        return mapToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private Category mapToEntity(CategoryDto dto){
        Category c = new Category();
        c.setName(dto.getName());
        return c;
    }

    private CategoryDto mapToDto(Category dto){
        CategoryDto dto1 = new CategoryDto();
        dto1.setName(dto.getName());
        dto1.setId(dto.getId());
        return dto1;
    }
}
