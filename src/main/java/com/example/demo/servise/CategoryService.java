package com.example.demo.servise;

import com.example.demo.entity.Category;
import com.example.demo.payload.CategoryDto;
import com.example.demo.payload.Result;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {
    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Result addCategory(CategoryDto categoryDto){
       Category category=new Category();

       category.setName(categoryDto.getName());
       if (categoryDto.getParentCategoryId()!=null){
           Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
           if (!optionalParentCategory.isPresent()){
               return new Result("Bunday categoruya mavjud emas",false);
           }else {
               category.setParentCategory(optionalParentCategory.get());
           }

       }
        categoryRepository.save(category);
        return new Result("Muvafafaqyatli saqlandi",true);
    }
    public List<Category> getCategories() {

        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    public Result getSubCategory(@PathVariable Integer parentCategoryId) {

        Optional<Category> parentCategory = categoryRepository.findById(parentCategoryId);
        if (parentCategory.isPresent()) {

            List<Category> subCategoryList = categoryRepository.findAllByParentCategoryId(parentCategory.get());
            return new Result("Subcategories", true, subCategoryList);
        }
        return new Result("There is not Subcategories yet.", false);
    }

    public Result editCategory(Integer categoryID, CategoryDto categoryDTO) {

        Optional<Category> optionalCategory = categoryRepository.findById(categoryID);
        if (!optionalCategory.isPresent())
            return new Result("Invalid category ID", false);

        Category editedCategory = optionalCategory.get();
        editedCategory.setName(categoryDTO.getName());

        if (categoryDTO.getParentCategoryId() != 0) {
            optionalCategory = categoryRepository.findById(categoryDTO.getParentCategoryId());

            if (!optionalCategory.isPresent()) {
                return new Result("There is not parent category", false);
            }
            editedCategory.setParentCategory(optionalCategory.get());
        }
        categoryRepository.save(editedCategory);
        return new Result("Category successfully edited", true);
    }

    public Result deleteCategory(Integer categoryID){

        Optional<Category> optionalCategory = categoryRepository.findById(categoryID);
        if (!optionalCategory.isPresent())
            return new Result("Invalid Category ID", false);

        categoryRepository.deleteById(categoryID);
        return new Result("Category deleted", true);
    }
}
