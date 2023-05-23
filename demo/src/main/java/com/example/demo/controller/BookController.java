package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.services.BookService;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping

    private String showAll(Model model){
    List<Book>books=bookService.getAllBooks();
    model.addAttribute("books",books);
    return "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("books", new Book());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }
//    private List<Book> books;
//
//    @GetMapping
//    public String listBooks(Model model) {
//        model.addAttribute("books", books);
//        model.addAttribute("title", "Book List");
//        return "book/list";
//    }
//
//    @GetMapping("/add")
//    public String addBookForm(Model model) {
//        model.addAttribute("books", new Book());
//        return "book/add";
//    }
//
//    @PostMapping("/add")
//    public String addBook(@ModelAttribute("book") Book book) {
//        books.add(book);
//        return "redirect:/books";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editBookForm(@PathVariable("id") Long id, Model model) {
//        Book editBook = null;
//        for (Book book : books) {
//            if (book.getId().equals(id)) {
//                editBook = book;
//                break;
//            }
//        }
//        if (editBook != null) {
//            model.addAttribute("book", editBook);
//            return "book/edit";
//        } else {
//            return "not-found";
//        }
//    }
//    @PostMapping("/edit")
//    public String editBook(@ModelAttribute("book") Book updatedBook) {
//        for (int i = 0; i < books.size(); i++) {
//            Book book = books.get(i);
//            if (book.getId().equals(updatedBook.getId())) {
//                books.set(i, updatedBook);
//                break;
//            }
//        }
//        return "redirect:/books";
//    }
//    @GetMapping("/delete/{id}")
//    public String deleteBook(@PathVariable("id") Long id) {
//        Iterator<Book> iterator = books.iterator();
//        while (iterator.hasNext()) {
//            Book book = iterator.next();
//            if (book.getId().equals(id)) {
//                iterator.remove();
//                break;
//            }
//        }
//        return "redirect:/books";
//    }
}
