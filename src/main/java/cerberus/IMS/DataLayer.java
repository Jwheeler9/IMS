package cerberus.IMS;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DataLayer {

	//----------------------------------
	// Attributes
	private Session session;
	private DAO dao;
	
	//----------------------------------
	// Accessors
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	//----------------------------------
	// Constructor && Cleanup
	public DataLayer(){
		
		session = SessionFactoryManager.getInstance().openSession();
		dao = new DAO(session);
	}
	public void close(){
		if(session != null) session.close();
	}
	
	//----------------------------------
	// Methods
	public void makeRecord(Object _obj){
		
		Transaction tx = session.beginTransaction();
		
		dao.createRecord(_obj);
		
		tx.commit();
	}
	public void changeRecord(Object _obj){
		
		Transaction tx = session.beginTransaction();
		
		dao.updateRecord(_obj);
		
		tx.commit();
	}
}
