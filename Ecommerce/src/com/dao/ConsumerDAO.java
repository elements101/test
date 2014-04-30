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
public class ConsumerDAO {
	@Resource SessionFactory factory;
	public void delete(Integer... UIds) {
		for(Integer UId : UIds){
			factory.getCurrentSession().delete(factory.getCurrentSession().load(Consumer.class, UId));
		}
	}
		
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Consumer find(Integer UId) {
			return (Consumer)factory.getCurrentSession().get(Consumer.class, UId);
		}

		@SuppressWarnings("unchecked")
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public List<Consumer> list() {		
			return factory.getCurrentSession().createQuery("from Consumer").list();
		}
		public Consumer findbyUName(String UName){
			Query query=factory.getCurrentSession().createQuery( "from Consumer where UName=:name");
			query.setParameter("name", UName);
			return (Consumer) query.uniqueResult();
		}
	    
		public void save(Consumer consumer) {
			factory.getCurrentSession().persist(consumer);
		}

		public void update(Consumer consumer) {
			factory.getCurrentSession().merge(consumer);
		}

}
