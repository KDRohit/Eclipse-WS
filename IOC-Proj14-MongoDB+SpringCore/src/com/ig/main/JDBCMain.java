package com.ig.main;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
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
            database.getCollection("family")
                    .insertOne(new Document("name", "Rohit")
                    .append("member", "Brother"));
            
            System.out.println("Document inserted successfully!");
        }
        catch(Exception e)
        {
        	
        }
	}
}
