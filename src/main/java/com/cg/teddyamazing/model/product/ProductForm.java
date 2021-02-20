package com.cg.teddyamazing.model.product;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class ProductForm {

    @javax.validation.constraints.Size(min = 3,max = 10)
    private String id;

    @NotEmpty
    private String name;

    @Min(10000)
    private double price;

    private String desv;
    private MultipartFile img;

    private Category category;

    private Size size;

    public ProductForm() {
    }

    public ProductForm(ProductFormBuilder productFormBuilder) {
        this.name = productFormBuilder.name;
        this.price = productFormBuilder.price;
        this.desv = productFormBuilder.desv;
        this.img = productFormBuilder.img;
        this.category = productFormBuilder.category;
        this.size = productFormBuilder.size;

    }

    public static class ProductFormBuilder {
        private final String name;
        private String desv;
        private double price;
        private MultipartFile img;
        private Category category;
        private Size size;

        public ProductFormBuilder(String name) {
            this.name = name;
        }

        public ProductFormBuilder description(String desv) {
            this.desv = desv;
            return this;
        }
        public ProductFormBuilder price(double price) {
            this.price = price;
            return this;
        }

        public ProductFormBuilder image(MultipartFile img) {
            this.img = img;
            return this;
        }

        public ProductFormBuilder image(Category category) {
            this.category = category;
            return this;
        }
        public ProductFormBuilder image(Size size) {
            this.size = size;
            return this;
        }

        public ProductForm build() {
            return new ProductForm(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesv() {
        return desv;
    }

    public void setDesv(String desv) {
        this.desv = desv;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
