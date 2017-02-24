package engim.crud.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import engim.crud.beans.Fornitore;
import engim.crud.utils.DBConnection;


public class FornitoriQuery implements Query<Fornitore>  {

	@Override
	public List<Fornitore> select() {
		// TODO Auto-generated method stub
		
		
		try (Connection conn = DBConnection.getConnection()){
						
			QueryRunner run = new QueryRunner();
			
			ResultSetHandler<List<Fornitore>> resultHandler = new BeanListHandler<Fornitore>(Fornitore.class);
			
			List<Fornitore> fornitore = run.query(conn, "select * from fornitori",resultHandler);
			
			return fornitore;
			
		} catch (SQLException e){
			e.getStackTrace();
			return null;
		}
		
		
	}

	@Override
	public Boolean insert(Fornitore t) {
		
		try (Connection conn = DBConnection.getConnection()){
			
			QueryRunner run = new QueryRunner();
			
			ResultSetHandler<List<Fornitore>> resultHandler = new BeanListHandler<Fornitore>(Fornitore.class);
			
			List<Fornitore> fornitore = run.insert
		(conn,"insert into fornitori values(?,?,?,?)", resultHandler, t.getCodf(),t.getNome(),t.getCitta_sede(),t.getN_soci());
			
			if (fornitore.size()!=0 || fornitore!=null ){
				return true;
			}
			
		} catch (SQLException e){
			e.getStackTrace();
		}
		
		return false;
		
	}

	@Override
	public Boolean update(Fornitore t) {
		
		try (Connection conn = DBConnection.getConnection()){
			
			int rows = 0;
			
			QueryRunner run = new QueryRunner();
			
			ResultSetHandler<List<Fornitore>> resultHandler = new BeanListHandler<Fornitore>(Fornitore.class);
			
			rows = run.update(conn, "update fornitori set nome=?,citta_sede=?,n_soci=? where codF=?",resultHandler, t.getNome(),t.getCitta_sede(),t.getN_soci(), t.getCodf());
			
			if (rows>0){			
				return true;
			}
		} catch (SQLException e){
			e.getStackTrace();
		}
		
		return false;
		
	}

	@Override
	public Boolean delete(Fornitore t) {

		try (Connection conn = DBConnection.getConnection()){

			int rows = 0;
			
			QueryRunner run = new QueryRunner();
			
			ResultSetHandler<List<Fornitore>> resultHandler = new BeanListHandler<Fornitore>(Fornitore.class);
			
			rows = run.update(conn, "delete from fornitori where codF=?",resultHandler, t.getCodf());
			
			if (rows>0){			
				return true;
			}
		} catch (SQLException e){
			e.getStackTrace();
		}
		
		return false;
		
	}



}
