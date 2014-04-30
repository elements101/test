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
public class ProductDAO {
	@Resource SessionFactory factory;
	public void delete(Integer... PIds) {
		for(Integer PId : PIds){
			factory.getCurrentSession().delete(factory.getCurrentSession().load(Product.class, PId));
		}
	}
		
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Product find(Integer PId) {
			return (Product)factory.getCurrentSession().get(Product.class, PId);
		}

		@SuppressWarnings("unchecked")
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public List<Product> list() {		
			return factory.getCurrentSession().createQuery("from Product").list();
		}
		public List<Product> findbySname(String name){
			Query query=factory.getCurrentSession().createQuery( "from Product where SName=:name");
			query.setParameter("name",name);
			return query.list();
		}
	    
		public void save(Product product) {
			factory.getCurrentSession().persist(product);
		}

		public void update(Product product) {
			factory.getCurrentSession().merge(product);
		}
}
