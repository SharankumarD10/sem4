package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BookRepository;
import com.example.demo.Entity.BookEntity;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	public BookEntity create (BookEntity book) {
		return bookRepository.save(book);
	}
	
	public Optional<BookEntity> read(Long id){
		return bookRepository.findById(id);
	}

	public BookEntity update(BookEntity book) {
		
		return bookRepository.save(book);
	}

	public String delete(Long id) {
		
		bookRepository.deleteById(id);
		return "data deleted";
	}
	
}
