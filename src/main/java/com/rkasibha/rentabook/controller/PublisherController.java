package com.rkasibha.rentabook.controller;

import com.rkasibha.rentabook.dto.PublisherDto;
import com.rkasibha.rentabook.model.Publisher;
import com.rkasibha.rentabook.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/publishers")
public class PublisherController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PublisherService publisherService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<PublisherDto> addPublisher(@RequestBody PublisherDto publisherDto) {
        Publisher publisher = mapper.map(publisherDto, Publisher.class);
        return new ResponseEntity<>(mapper.map(publisherService.addPublisher(publisher), PublisherDto.class), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{name}")
    public ResponseEntity<PublisherDto> getPublisherByName(@PathVariable String name) {
        PublisherDto publisherDto = mapper.map(publisherService.getPublisher(name), PublisherDto.class);
        return new ResponseEntity<>(publisherDto, HttpStatus.OK);
    }
}
