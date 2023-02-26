package com.example.Mapping.Service;
import java.util.ArrayList;
import java.util.List;

import com.example.Mapping.Model.Book;
import com.example.Mapping.Model.Student;
import com.example.Mapping.Repo.IBookRepo;
import com.example.Mapping.Repo.IStudentRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private IBookRepo iBookRepo;

    @Autowired
    private IStudentRepo iStudentRepo;

    public Book addBook(String book) {

        JSONObject jsonObject = new JSONObject(book);
        Student student = null;
        int studentId = jsonObject.getInt("student");

        if(iStudentRepo.findById(studentId).isPresent()) {
            student = iStudentRepo.findById(studentId).get();
        } else {
            return null;
        }

        Book book1 = new Book();
        book1.setStudent(student);
        book1.setTitle(jsonObject.getString("title"));
        book1.setAuthor(jsonObject.getString("author"));
        book1.setDescription(jsonObject.getString("description"));
        book1.setPrice(jsonObject.getString("price"));

        Book bookObj=iBookRepo.save(book1);


        return bookObj;

    }

    public List<Book> findByBook(String bookId) {
        List<Book> book ;
        if(bookId!=null) {
            book = new ArrayList<>();
            book.add(iBookRepo.findById(Integer.parseInt(bookId)).get());

        }
        else {
            book=iBookRepo.findAll();
        }
        return book;
    }}