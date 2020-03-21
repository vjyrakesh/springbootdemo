package com.rkasibha.springbootdemo.controller;

import com.rkasibha.springbootdemo.dto.AuthorDetailsDto;
import com.rkasibha.springbootdemo.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorDetailsDto>> getAllAuthors() {
        return new ResponseEntity<>(authorService.fetchAllAuthors(), HttpStatus.OK);
    }

}
