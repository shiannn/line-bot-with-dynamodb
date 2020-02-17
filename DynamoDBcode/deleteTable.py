import boto3
import json

def listTables(ddb):
    response = ddb.list_tables()
    json_formatted_str = json.dumps(response, indent=4)
    print(json_formatted_str)

def scanTable(ddb, TableNames):
    table = ddb.Table(TableNames)
    response = table.scan()
    json_formatted_str = json.dumps(response, indent=4)
    print(json_formatted_str)

def deleteTable(ddb, TableNames):
    table = ddb.Table(TableNames)
    table.delete()

if __name__ == '__main__':
    ddb_client = boto3.client('dynamodb', endpoint_url='http://localhost:8000')
    ddb_resource = boto3.resource('dynamodb', region_name='us-west-2', endpoint_url="http://localhost:8000")
    TableNames = 'MessageTable'
    #TableNames = 'ParseInfoTable'
    
    #scanTable(ddb_resource, TableNames)
    #listTables(ddb_client)
    deleteTable(ddb_resource, TableNames)