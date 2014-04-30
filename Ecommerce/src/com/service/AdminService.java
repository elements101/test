package com.service;
import java.util.List;
import com.bean.*;
public interface AdminService {
       public List getAllConInfo();
       public boolean deleteCon(Integer consumerid);
       public Consumer selectCon(Integer consumerid);
       public boolean editCon(Consumer consumer);
       public List getAllProduct();
       public boolean editProduct(Product product);
       public Product selectProduct(Integer productid);
       public boolean deleteProduct(Integer productid);
       public List getAllSP();
       public SP selectSP(Integer spid);
       public boolean deleteSP(Integer spid);
       public List getAllOrder();
       public boolean deleteOrder(Integer UId,Integer SPId );
       public boolean updateComment(Integer UId,Integer SPId,String comment);
}
