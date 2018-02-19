package com.bookmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanager.dao.BookDao;
import com.bookmanager.entity.Book;

@RestController
public class BookController {

	@Autowired
	BookDao bookDao;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> findAll() {
		List<Book> books = bookDao.findAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> findById(@PathVariable("id") Integer id) {
		Book book = bookDao.findByPrimaryKey(id);
		return new ResponseEntity<Book>(book, (book != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
		Book book = bookDao.findByPrimaryKey(id);
		if (book == null)
			return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);

		bookDao.delete(book);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		if(book.getId() > 0)
			return new ResponseEntity<Book>(book, HttpStatus.BAD_REQUEST);
		bookDao.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		Book bookFind = bookDao.findByPrimaryKey(book.getId());
		if (bookFind != null) {
			bookDao.update(book);
			return new ResponseEntity<Book>(bookFind, HttpStatus.OK);
		}
		return new ResponseEntity<Book>(bookFind, HttpStatus.BAD_REQUEST);
	}
}