package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.Person;

import jakarta.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;
    private String bookName;
    private boolean isReturn;

    public UserLoanHistory() {
    }

    public UserLoanHistory(Person person, String bookName) {
        this.person = person;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn(){
        this.isReturn = true;
    }

    public String getBookName() {
        return bookName;
    }
}
