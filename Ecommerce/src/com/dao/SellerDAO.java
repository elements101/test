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
public class SellerDAO {
	@Resource SessionFactory factory;
	public void delete(Integer... SIds) {
		for(Integer SId : SIds){
			factory.getCurrentSession().delete(factory.getCurrentSession().load(Seller.class, SId));
		}
	}
		
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Seller find(Integer SId) {
			return (Seller)factory.getCurrentSession().get(Seller.class, SId);
		}

		@SuppressWarnings("unchecked")
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public List<Seller> list() {		
			return factory.getCurrentSession().createQuery("from Seller").list();
		}
		public Seller findbyUName(String SName){
			Query query=factory.getCurrentSession().createQuery( "from Seller where SName=:name");
			query.setParameter("name", SName);
			return (Seller) query.uniqueResult();
		}
	    
		public void save(Seller seller) {
			factory.getCurrentSession().persist(seller);
		}

		public void update(Seller seller) {
			factory.getCurrentSession().merge(seller);
		}
}
