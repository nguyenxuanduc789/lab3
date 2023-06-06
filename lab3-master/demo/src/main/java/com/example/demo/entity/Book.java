
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.example.demo.Validator.annotation.ValiUserId;
import jakarta.validation.constraints.*;
@Data
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotEmpty(message = "title không được để trống")
    @Size(max = 50, min = 1, message = "Tên không vượt quá 50 ký tự")
    private String title;

    @Column(name = "author")
    @NotEmpty(message = "author không được để trống")
    private String author;
    @Column(name = "price")
    @NotNull(message = "price không được để trống")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @ValiUserId
    private User user;
}
