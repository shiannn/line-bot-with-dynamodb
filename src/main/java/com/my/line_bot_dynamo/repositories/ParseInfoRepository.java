package com.my.line_bot_dynamo.repositories;

import java.util.Optional;

import com.my.line_bot_dynamo.models.ParseInfo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@EnableScanCount
@Repository
public interface ParseInfoRepository extends CrudRepository<ParseInfo, String> {
    // Page<messageObject> findAllByMessage(String Message, Pageable pageable);
}