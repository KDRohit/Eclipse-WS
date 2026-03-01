package learning;

public interface IMessageLog 
{
	void showMessage(String s1,String s2);
	
	default void showDefaultMessage()
	{
		System.out.println("This is default Message");
	}
}
