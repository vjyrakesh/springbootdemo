package com.rkasibha.rentabook.service;

import com.rkasibha.rentabook.model.Publisher;
import com.rkasibha.rentabook.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher getPublisher(String name) {
        return publisherRepository.findByName(name);
    }
}
