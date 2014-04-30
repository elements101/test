package com.service;
import java.util.List;
import com.bean.*;
public interface ConsumerService {
     public void updateConInfo(Consumer consumer);
     public List<Order> getAllOrder(Consumer consumer);
     public void setComment(Integer spid,Consumer consumer,String comment);
     public boolean buyProduct(Integer spid,Consumer consumer,Integer num);
}
