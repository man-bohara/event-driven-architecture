package com.kafka.example.repository;

import com.kafka.example.model.Message;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
