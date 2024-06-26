package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.UserRepository;
import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.user.Person;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.user.UserLoanHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saverBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(request.getBookName(),false )){
            throw new IllegalArgumentException("대출되어 있는 책입니다.");
        }

        Person user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        user.loanBook(request.getBookName());
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        Person user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        user.returnBook(request.getBookName());
    }
}
