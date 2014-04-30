package com.service;

import com.bean.*;

public interface LoginService {
       public Consumer consumerLogin(String name,String password);
       public Seller sellerLogin(String name);
       public Admin adminLogin(String name,String password);
}
