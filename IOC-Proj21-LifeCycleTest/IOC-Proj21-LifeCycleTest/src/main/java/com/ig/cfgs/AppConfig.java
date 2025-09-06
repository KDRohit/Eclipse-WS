package com.ig.cfgs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.ig.sbeans")
@PropertySource("com/ig/properties/info.properties")
public class AppConfig 
{

}
