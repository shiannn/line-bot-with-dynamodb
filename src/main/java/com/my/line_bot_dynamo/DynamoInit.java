package com.my.line_bot_dynamo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.my.line_bot_dynamo.models.messageObject;
import com.my.line_bot_dynamo.models.ParseInfo;

@Component
public class DynamoInit implements ApplicationListener<ContextRefreshedEvent>{
    private final AmazonDynamoDB amazonDynamoDB;

    @Autowired
    public DynamoInit(AmazonDynamoDB amazonDynamoDB){
        this.amazonDynamoDB = amazonDynamoDB;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        CreateTableRequest tableRequest = new DynamoDBMapper(amazonDynamoDB)
            .generateCreateTableRequest(messageObject.class);
        
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L,1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);

        CreateTableRequest parseInfoRequest = new DynamoDBMapper(amazonDynamoDB)
            .generateCreateTableRequest(ParseInfo.class);
        
        parseInfoRequest.setProvisionedThroughput(new ProvisionedThroughput(1L,1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, parseInfoRequest);
    }
}