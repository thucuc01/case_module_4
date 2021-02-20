package com.cg.teddyamazing.model.product;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Product {
    @Id
    private String id;

    @Column(unique = true)

    private String name;

    private double price;
    private String desv;
    private String img;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

//    @Transient
//    private MultipartFile imageData;
//
//    public MultipartFile getImageData() {
//        return imageData;
//    }
//
//    public void setImageData(MultipartFile imageData) {
//        this.imageData = imageData;
//    }

    public Product() {
    }


    //upload file

    public static class ProductBuilder {
        private final String name;
        private double price;
        private String desv;
        private String img;
        private Category category;
        private Size size;


        public ProductBuilder(String name) {
            this.name = name;
        }

        public ProductBuilder desv(String description) {
            this.desv = description;
            return this;
        }
        public ProductBuilder price(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder img(String image) {
            this.img = image;
            return this;
        }
        public ProductBuilder category(Category category) {
            this.category = category;
            return this;
        }
        public ProductBuilder size(Size size) {
            this.size = size;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
    public Product(ProductBuilder productBuilder){
        this.name= productBuilder.name;
        this.price= productBuilder.price;
        this.desv= productBuilder.desv;
        this.img= productBuilder.img;
        this.category= productBuilder.category;
        this.size= productBuilder.size;
    }

//    end upload file

    public Product(String id, String name, double price, String desv, String img, Category category, Size size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desv = desv;
        this.img = img;
        this.category = category;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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