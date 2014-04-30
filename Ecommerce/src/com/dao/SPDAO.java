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
public class SPDAO {
	@Resource SessionFactory factory;
	public void delete(Integer... SPIds) {
		for(Integer SPId : SPIds){
			factory.getCurrentSession().delete(factory.getCurrentSession().load(SP.class, SPId));
		}
	}
		
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public SP find(Integer SPId) {
			return (SP)factory.getCurrentSession().get(SP.class, SPId);
		}

		@SuppressWarnings("unchecked")
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public List<SP> list() {		
			return factory.getCurrentSession().createQuery("from SP").list();
		}
	    public List<SP> findbySId(Integer id){
			Query query=factory.getCurrentSession().createQuery( "from SP where s_id = :name");
			query.setParameter("name",id);
			return query.list();
	    }
		public void save(SP sp) {
			factory.getCurrentSession().persist(sp);
		}

		public void update(SP sp) {
			factory.getCurrentSession().merge(sp);
		}
}
