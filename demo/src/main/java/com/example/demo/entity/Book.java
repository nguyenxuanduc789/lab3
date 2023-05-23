//package com.example.demo.entity;
//import jakarta.persistence.*;
//import jdk.jfr.Category;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name="Book")
//public class Book {
////    private Long id;
////    private String title;
////    private String author;
////    private double price;
////    private String category;
////
////    // Getters and Setters
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public String getAuthor() {
////        return author;
////    }
////
////    public void setAuthor(String author) {
////        this.author = author;
////    }
////
////    public double getPrice() {
////        return price;
////    }
////
////    public void setPrice(double price) {
////        this.price = price;
////    }
////
////    public String getCategory() {
////        return category;
////    }
////
////    public void setCategory(String category) {
////        this.category = category;
////    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long id;
//    @Column(name="title")
//    private String title;
//    @Column(name="author")
//    private String author;
//    @Column(name="price")
//    private Double price;
//    @ManyToOne
//    @JoinColumn(name="category_id")
//    private Category category;
//}
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
