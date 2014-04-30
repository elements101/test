package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.bean.*;
@Repository @Transactional
public class AdminDAO {
	@Resource SessionFactory factory;
	public void delete(Integer... AIds) {
		for(Integer AId : AIds){
			factory.getCurrentSession().delete(factory.getCurrentSession().load(Admin.class, AId));
		}
	}
		
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Admin find(Integer AId) {
			return (Admin)factory.getCurrentSession().get(Admin.class, AId);
		}

		@SuppressWarnings("unchecked")
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public List<Admin> list() {		
			return factory.getCurrentSession().createQuery("from Admin").list();
		}
	    public Admin findbyAname(String name){
	    	Query query=factory.getCurrentSession().createQuery( "from Admin where AName=:name");
			query.setParameter("name", name);
			return (Admin) query.uniqueResult();
	    }
		public void save(Admin admin) {
			factory.getCurrentSession().persist(admin);
		}

		public void update(Admin admin) {
			factory.getCurrentSession().merge(admin);
		}

}
