package engim.crud.sql;

import java.util.List;

public interface Query <T> {
	
	public List<T> select();
	public Boolean insert(T t);
	public Boolean update(T t);
	public Boolean delete(T t);
}
