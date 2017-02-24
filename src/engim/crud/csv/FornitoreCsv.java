package engim.crud.csv;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import engim.crud.beans.BeanInterface;
import engim.crud.beans.Fornitore;

public class FornitoreCsv implements OperationsCsv{


	@Override
	public List<BeanInterface> read() {
		
		Properties pr  = new Properties();
		InputStream is = null;
		CSVReader reader = null;
		
		List<BeanInterface> listF;
		
		try{
			
			is = new FileInputStream("Config.properties");
			pr.load(is);
			
			listF = new LinkedList<>();
			reader = new CSVReader(new FileReader(pr.getProperty("CSV_FILE_FORNITORI_READ")));
			
			
			String [] line;
			
			while((line = reader.readNext()) != null){
				listF.add(new Fornitore(line[0], line[1], line[2], Integer.parseInt(line[3])));
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
			
		} finally {
			try {
				
				is.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return listF;
	}

	@Override
	public boolean write(List<BeanInterface> list) {
		
		Properties pr  = new Properties();
		InputStream is = null;
		CSVReader reader = null;
		
		List<String[]> data = null;
		try{
			
			is = new FileInputStream("Config.properties");
			pr.load(is);
				
			CSVWriter writer = new CSVWriter(new FileWriter(pr.getProperty("CSV_FILE_FORNITORI_WRITE")));
	
			for (BeanInterface b : list) {
				data.add(b.attributeToArrayString());
			}
			
			writer.writeAll(data);
			
			writer.close();
			
			return true;
		} catch(Exception e){
			e.getStackTrace();
			return false;
		} finally {
			try {
				
				is.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
