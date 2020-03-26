package com.rkasibha.rentabook.controller;

import com.rkasibha.rentabook.dto.AuthorDto;
import com.rkasibha.rentabook.model.Author;
import com.rkasibha.rentabook.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : authors) {
            authorDtos.add(mapper.map(author, AuthorDto.class));
        }
        return new ResponseEntity<>(authorDtos, HttpStatus.OK);
    }

}
