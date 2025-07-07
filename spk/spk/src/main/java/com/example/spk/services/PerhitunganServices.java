package com.example.spk.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PerhitunganServices {
    private static final Logger log = LoggerFactory.getLogger(PerhitunganServices.class);

    @PersistenceContext
    private EntityManager entityManager;


}
