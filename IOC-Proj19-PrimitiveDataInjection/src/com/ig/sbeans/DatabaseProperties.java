package com.ig.sbeans;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component("dbproperties")
@Data
@PropertySource("com/ig/properties/Database.properties")
public class DatabaseProperties
{
	// Injected:- properties
	
	@Value("${driver}")
	private String driver;
	@Value("${dburl}")
	private String dbUrl;
	@Value("${user}")
	private String user;
	@Value("${pass}")
	private String pass;
	
	// Injected:- properties table
	@Value("#{'${fields}'.split(',')}")
	private ArrayList<String> fields;
	@Value("#{'${types}'.split(',')}")
	private ArrayList<String> types;
	
	// Injected:- system properties
	
	@Value("${os.name}")
	private String osName;
	@Value("${os.version}")
	private String osVersion;
	
	// Injected:- direct value
	
	@Value("rdubey")
	private String localName;
	@Value("asdf#123")
	private String localPassword;
	
	// Injected:- Environment variable
	@Value("${Path}")
	private String path;
	
}
