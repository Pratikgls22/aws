//package com.onlineportal.qrscanner.elasticEntity;
//
//import jakarta.persistence.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//@Document(indexName = "products")
//public class ProductElasticEntity {
//
//    @Id
//    private Long id;
//    @Field(type = FieldType.Text)
//    private String name;
//    @Field(type = FieldType.Text)
//    private String price;
//
//    public ProductElasticEntity() {
//    }
//
//    public ProductElasticEntity(Long id, String name, String price) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//}
