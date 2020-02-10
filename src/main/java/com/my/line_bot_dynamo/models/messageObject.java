package com.my.line_bot_dynamo.models;

import javax.validation.constraints.NotEmpty;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "MessageTable")
public class messageObject{
    private String id;

    @NotEmpty
    private String message;

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId(){
        return id;
    }

    @DynamoDBAttribute
    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}