package com.example.demo.servise;

import com.example.demo.entity.Attachment;
import com.example.demo.entity.Category;
import com.example.demo.entity.Measurement;
import com.example.demo.entity.Product;
import com.example.demo.payload.ProductDto;
import com.example.demo.payload.Result;
import com.example.demo.repository.AttachmentRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MeasurementRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;
    final AttachmentRepository attachmentRepository;
    final MeasurementRepository measurementRepository;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, AttachmentRepository attachmentRepository, MeasurementRepository measurementRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.attachmentRepository = attachmentRepository;
        this.measurementRepository = measurementRepository;
    }

    public Result addProduct(ProductDto productDto){
        boolean existsByName = productRepository.existsByNameAndCategoryId(productDto.getName(),productDto.getCategoryId());
        if (existsByName){
return new Result("Bunday categoriyali product bazada mavjud",false);
        }
        //CATEGORIYANI TEKSHIRISH
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new Result("Bunday categoriya Mavjud emas",false);
        }
        //PHOTO TAKSHIRISH
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent()){
            return new Result("Bunday photo bazada amvjud emas",false);
        }
        //MEASUREMENT NI TEKSHIRISH
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent()){
            return new Result("Bunday o`lchob birligi mavjud emas",false);
        }
        //SAQLASH
        Product product=new Product();
        product.setName(productDto.getName());
        product.setCode("1");//todo generasiya qilish kerak
        product.setCategory(optionalCategory.get());
        product.setMeasurement(optionalMeasurement.get());
        product.setPhoto(optionalAttachment.get());
        productRepository.save(product);
        return new Result("Maxsulot Saqlandi",true);

    }


}
