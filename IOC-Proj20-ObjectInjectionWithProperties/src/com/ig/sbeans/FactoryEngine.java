package com.ig.sbeans;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("factory-engine")
public class FactoryEngine implements FactoryBean<IEngine> 
{
	@Value("${engine.id}")
	private String engId;
	
	@Autowired
	ApplicationContext acac;

	@Override
	public IEngine getObject() throws Exception 
	{
		if(engId.equalsIgnoreCase("Bajaj"))
		{
			return acac.getBean("Bajaj",Bajaj.class);
		}
		else if(engId.equalsIgnoreCase("Pulsor")) 
		{
			return acac.getBean("Pulsor",Pulsor.class);
		}
		else if(engId.equalsIgnoreCase("Honda")) 
		{
			return acac.getBean("Honda",Honda.class);
		}
		else 
		{
			throw new IllegalArgumentException("illegel property");
		}
	}

	@Override
	public Class<?> getObjectType() 
	{
		return IEngine.class;
	}

}
