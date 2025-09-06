import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.ig.sbeans.IEngine;
import com.ig.sbeans.Bajaj;
import com.ig.sbeans.Honda;
import com.ig.sbeans.Pulsor;

@Component("factory-engine")
public class FactoryEngine implements FactoryBean<IEngine> 
{
	@Value("${engine.id}")
	private String engId;
	
	public IEngine getObject() throws Exception 
	{
		if(engId.equalsIgnoreCase("Bajaj"))
		{
			return new Bajaj();
		}
		else if(engId.equalsIgnoreCase("Pulsor")) 
		{
			return new Pulsor();
		}
		else if(engId.equalsIgnoreCase("Honda")) 
		{
			return new Honda();
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
