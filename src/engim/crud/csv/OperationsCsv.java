package engim.crud.csv;

import java.util.List;

import engim.crud.beans.BeanInterface;

public interface OperationsCsv {
	
	public List<BeanInterface> read();
	public boolean write (List<BeanInterface> list);

}
