package com.rkasibha.rentabook.service;

import com.rkasibha.rentabook.repository.AuthorRespository;
import com.rkasibha.rentabook.dto.AuthorBookDetailsDto;
import com.rkasibha.rentabook.dto.AuthorDetailsDto;
import com.rkasibha.rentabook.model.Author;
import com.rkasibha.rentabook.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {

    @Autowired
    private AuthorRespository authorRespository;

    public List<AuthorDetailsDto> fetchAllAuthors() {
        List<Author> authors = authorRespository.findAll();
        List<AuthorDetailsDto> authorDetailsDtos = new ArrayList<>();
        for (Author author : authors) {
            AuthorDetailsDto authorDetailsDto = new AuthorDetailsDto();
            authorDetailsDto.setId(author.getId());
            authorDetailsDto.setFirstName(author.getFirstName());
            authorDetailsDto.setLastName(author.getLastName());
            Set<AuthorBookDetailsDto> bookDetailsDtoSet = new HashSet<>();
            for (Book book : author.getBooks()) {
                AuthorBookDetailsDto authorBookDetailsDto = new AuthorBookDetailsDto();
                authorBookDetailsDto.setId(book.getId());
                authorBookDetailsDto.setName(book.getName());
                bookDetailsDtoSet.add(authorBookDetailsDto);
            }
            authorDetailsDto.setBooks(bookDetailsDtoSet);
            authorDetailsDtos.add(authorDetailsDto);
        }
        return authorDetailsDtos;
    }

    public List<Author> getAllAuthors() {
        return authorRespository.findAll();
    }
}
