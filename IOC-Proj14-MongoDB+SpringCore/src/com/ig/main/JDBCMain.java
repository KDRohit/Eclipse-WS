package com.ig.main;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class JDBCMain 
{
	public static void main(String[] args)
	{
		// Connect to MongoDB (default localhost:27017)
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) 
        {
            
            // Get database (creates it if not exists)
            MongoDatabase database = mongoClient.getDatabase("admin");
            System.out.println("Connected to database: " + database.getName());
            
            // Insert a sample document
            
            MongoCollection<Document> table = database.getCollection("Employee");
            Document data = new Document("name", "Rohit");
            data.append("empId", "Brother");
            data.append("member", "Brother");
            
            table.insertOne(data);
            System.out.println("Document inserted successfully!");
        }
        catch(Exception e)
        {
        	
        }
	}
}
