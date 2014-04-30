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
public class OrderDAO {
	@Resource SessionFactory factory;
	public void delete(OrderId... ids) {
		for(OrderId id : ids){
			factory.getCurrentSession().delete(factory.getCurrentSession().load(Order.class, id));
		}
	}
		
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Order find(OrderId id) {
			return (Order)factory.getCurrentSession().get(Order.class, id);
		}

		@SuppressWarnings("unchecked")
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public List<Order> list() {		
			return factory.getCurrentSession().createQuery("from Order").list();
		}
		public List<Order> findbyUId(Integer id){
			System.out.println(id);
			Query query=factory.getCurrentSession().createQuery( "from Order o where o.consumer.UId =:name");
			query.setParameter("name",id);
			return query.list();
		}
	    public List<Order> findbySPId(Integer id){
			Query query=factory.getCurrentSession().createQuery( "from Order where s_p_id =:name");
			query.setParameter("name",id);
			return query.list();
	    }
		public void save(Order order) {
			factory.getCurrentSession().persist(order);
		}

		public void update(Order order) {
			factory.getCurrentSession().merge(order);
		}
}
