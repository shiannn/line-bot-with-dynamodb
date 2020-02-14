package com.my.line_bot_dynamo.repositories;

import java.util.Optional;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.my.line_bot_dynamo.models.messageObject;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@EnableScan
@EnableScanCount
@Repository
public interface MessageRepository extends CrudRepository<messageObject, String> {
    // Page<messageObject> findAllByMessage(String Message, Pageable pageable);
    Optional<messageObject> findByMessageId(String messageId);
}

/*
@Repository
@Slf4j
public class MessageRepository{
    @Autowired
    private final DynamoDBMapper mapper;

    @Autowired
    public MessageRepository(DynamoDBMapper dynamoDBMapper) {
        this.mapper = dynamoDBMapper;
    }

    public void save(messageObject model) {
        try {
            mapper.save(model);
        } catch (Exception ex) {
            log.error("Couldn't save {} to DynamoDB", model, ex);
            throw new RuntimeException("Couldn't save {} to DynamoDB", ex);
        }
    }
}
*/