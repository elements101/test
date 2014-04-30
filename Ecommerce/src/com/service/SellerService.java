package com.service;
import java.util.List;
import com.bean.*;
public interface SellerService {
       public boolean addProduct(Product product);
       public List<Product> showProduct(Seller seller);
       public Product selectProduct(Integer PId);
       public void upProduct(SP sp);
       public boolean editProduct(Product product);
       public List<SP> showAllSp(Seller seller);
       public void cancelUp(SP instance);
       public List<Order> showOneStu(Integer SPId);
       public void sendProduct(Integer spid,Integer uid,Integer status);
}
