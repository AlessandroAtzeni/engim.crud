package engim.crud.main;

import java.util.ArrayList;
import java.util.List;

import engim.crud.beans.BeanInterface;
import engim.crud.beans.Fornitore;
import engim.crud.beans.Prodotto;
import engim.crud.csv.FornitoreCsv;
import engim.crud.csv.ProdottoCSV;
import engim.crud.sql.*;


public class MainCrud {

	public static void main(String[] args) {
		
		ProdottoCSV pcsv = new ProdottoCSV();
		FornitoreCsv fcsv = new FornitoreCsv();
		
		List<BeanInterface> listW = new ArrayList<BeanInterface>();
		
		listW.add(new Prodotto("huh", "hjhjkh", 0, "ggkg", "hjhjh", "JHJH"));
		listW.add(new Prodotto("haaa", "bbb", 7, "cccc", "ssss", "qqqq"));
		
		
		pcsv.write(listW);
		
		List<BeanInterface> listB = fcsv.read();
		for(BeanInterface i : listB){
			
			System.out.println(i.toString());
		}
		
		FornitoriQuery fq = new FornitoriQuery();
		
		List<Fornitore> listF = new ArrayList<Fornitore>();
		listF = fq.select();
		
			if(listF.isEmpty()){
				System.out.println("CAZZZOO");
			}else{
				System.out.println(""+listF.size());
			}

	}

}
