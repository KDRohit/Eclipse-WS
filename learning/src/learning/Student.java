package learning;

import java.util.Iterator;
import java.util.List;

public class Student implements Iterable<String>
{
	private final List<String> friends = List.of("raja","rani");

	@Override
	public Iterator<String> iterator() 
	{
		return new Iterator<String>() {
			int i = 0;
			@Override
			public boolean hasNext() {
				return i<friends.size();
			}
			
			@Override
			public String next() {
				// TODO Auto-generated method stub
				return friends.get(i++);
			}
		};
	}
	
}
