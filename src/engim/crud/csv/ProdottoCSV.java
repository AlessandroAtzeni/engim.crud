package engim.crud.csv;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import engim.crud.beans.BeanInterface;
import engim.crud.beans.Prodotto;

public class ProdottoCSV implements OperationsCsv {

	public List<BeanInterface> read() {
		Properties pr  = new Properties();
		InputStream is = null;
		CSVReader reader = null;
		
		List<BeanInterface> listP;
		
		try{
			
			is = new FileInputStream("Config.properties");
			pr.load(is);
			
			listP = new LinkedList<>();
			reader = new CSVReader(new FileReader(pr.getProperty("CSV_FILE_PRODOTTI_READ")));
			
			
			String [] line;
			
			while((line = reader.readNext()) != null){
				listP.add(new Prodotto(line[0], line[1], Integer.parseInt(line[2]), line[3], line[4], line[5]));
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
			
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return listP;
	}


	@Override
	public boolean write(List<BeanInterface> list) {
		
		Properties pr  = new Properties();
		InputStream is = null;
		
		
		List<String[]> data = new ArrayList<String[]>();
		try{
			
			is = new FileInputStream("Config.properties");
			pr.load(is);
				
			CSVWriter writer = new CSVWriter(new FileWriter(pr.getProperty("CSV_FILE_PRODOTTI_WRITE")));
	
			for (BeanInterface b : list) {
				
				data.add(b.attributeToArrayString());
			}
			
			writer.writeAll(data);
			writer.flush();
			
			writer.close();
			
			return true;
		} catch(Exception e){
			e.getStackTrace();
			return false;
		} finally {
			try {
				
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
