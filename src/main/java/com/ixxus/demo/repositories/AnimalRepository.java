package com.ixxus.demo.repositories;

import com.ixxus.demo.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
@Component
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
