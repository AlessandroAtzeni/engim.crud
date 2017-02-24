

package engim.crud.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import engim.crud.beans.Prodotto;
import engim.crud.utils.DBConnection;


public class ProdottiQuery implements Query<Prodotto> {

	@Override
	public List<Prodotto> select() {
		try (Connection conn = DBConnection.getConnection()){
			
			QueryRunner run = new QueryRunner();
			
			ResultSetHandler<List<Prodotto>> resultHandler = new BeanListHandler<Prodotto>(Prodotto.class);
			
			List<Prodotto> prodotto = run.query(conn, "select * from prodotti",resultHandler);
			
			return prodotto;
			
		} catch (SQLException e){
			e.getStackTrace();
		}
		
		return null;
	}

	@Override
	public Boolean insert(Prodotto t) {
		try (Connection conn = DBConnection.getConnection()){
			
			QueryRunner run = new QueryRunner();
			
			ResultSetHandler<List<Prodotto>> resultHandler = new BeanListHandler<Prodotto>(Prodotto.class);
			
			List<Prodotto> prodotto = run.insert
	(conn,"insert into prodotti values(?,?,?,?,?,?)", resultHandler , t.getCodP(),t.getNome(),t.getTaglia(),t.getColore(),t.getQta(), t.getMagazzino() );
			
			if (prodotto.size()!=0 || prodotto!=null ){
				return true;
			}
			
		} catch (SQLException e){
			e.getStackTrace();
		}
		
		return false;
		
	}

	@Override
	public Boolean update(Prodotto t) {
	try (Connection conn = DBConnection.getConnection()){
			
			int rows = 0;
			
			QueryRunner run = new QueryRunner();
			
			ResultSetHandler<List<Prodotto>> resultHandler = new BeanListHandler<Prodotto>(Prodotto.class);
			
			rows = run.update(conn, "update prodotti set nome=?, taglia=?,colore=?, qta=?, magazzino=?, where codP=?",resultHandler,t.getNome(),t.getTaglia(),t.getColore(),t.getQta(), t.getMagazzino(), t.getCodP());
			
			if (rows>0){			
				return true;
			}
		} catch (SQLException e){
			e.getStackTrace();
		}
		
		return false;
		
	}

	@Override
	public Boolean delete(Prodotto t) {
		try (Connection conn = DBConnection.getConnection()){

			int rows = 0;
			
			QueryRunner run = new QueryRunner();
			
			ResultSetHandler<List<Prodotto>> resultHandler = new BeanListHandler<Prodotto>(Prodotto.class);
			
			rows = run.update(conn, "delete from prodotti where codP=?",resultHandler, t.getCodP());
			
			if (rows>0){			
				return true;
			}
		} catch (SQLException e){
			e.getStackTrace();
		}
		return false;
	}

	
}


