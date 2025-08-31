package com.ig.cfgs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
@PropertySource("com/ig/properties/info.properties")
@Configuration
@ComponentScan(basePackages = "com.ig.sbeans")
@ImportResource("com/ig/cfgs/AppConfig.xml")
public class AppConfig 
{

}
