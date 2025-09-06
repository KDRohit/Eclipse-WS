package com.ig.cfgs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ig.sbeans.Bajaj;
import com.ig.sbeans.Honda;
import com.ig.sbeans.Pulsor;
@PropertySource("com/ig/properties/info.properties")
@Configuration
@ComponentScan(basePackages = "com.ig.sbeans")
//@ImportResource("com/ig/cfgs/AppConfig.xml")
public class AppConfig 
{
	/*@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() 
	{
	    return new PropertySourcesPlaceholderConfigurer();
	}*/
	
	@Bean({"Bajaj", "BajajAlias"})
    public Bajaj GetInstanceOfBajaj() 
	{
        return new Bajaj();
    }
	@Bean({"Pulsor", "PulsorAlias"})
    public Pulsor GetInstanceOfPulsor() 
	{
        return new Pulsor();
    }
	@Bean({"Honda", "HondaAlias"})
    public Honda GetInstanceOfHonda() 
	{
        return new Honda();
    }
	
}
