package com.group.libraryapp.service.book;

import com.group.libraryapp.repository.book.BookMemoryRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookMemoryRepository bookMemoryRepository;

    public BookService(BookMemoryRepository bookMemoryRepository) {
        this.bookMemoryRepository = bookMemoryRepository;
    }

    public void saverBook() {
        bookMemoryRepository.saveBook();
    }
}
