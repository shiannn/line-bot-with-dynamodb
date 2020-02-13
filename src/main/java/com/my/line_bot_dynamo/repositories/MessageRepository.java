package com.my.line_bot_dynamo.repositories;

import java.util.List;
import com.my.line_bot_dynamo.models.messageObject;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@EnableScan
@EnableScanCount
@Repository
public interface MessageRepository extends CrudRepository<messageObject, String>{
    //Page<messageObject> findAllByMessage(String Message, Pageable pageable);
}