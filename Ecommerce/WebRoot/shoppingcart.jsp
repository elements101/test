<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store - Shopping Cart</title>
<meta name="keywords" content="shoes store, shopping cart, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store, Shopping Cart, online store template " />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">



</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

</head>

<body>

<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">

	<div id="templatemo_header">
    	<div id="site_title"><h1><a href="http://www.cssmoban.com">Online Shoes Store</a></h1></div>
        <div id="header_right">
        	<p>
	         <a href="orderlist.action">My Account</a> | <a href="seller/addproduct.jsp">My sell</a> | <a href="#">My Cart</a> | <a href="#">Checkout</a> | <a href="index.jsp">Log In</a></p>
            <p>
            	Shopping Cart: <strong>${sessionScope.cout} items</strong> ( <a href="shoppingcart.jsp">Show Cart</a> )
			</p>
		</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="findex.jsp">Home</a></li>
                <li><a href="showas.action">Products</a>
                    <ul>
                        <li><a href="http://www.cssmoban.com/">Sub menu 1</a></li>
                        <li><a href="#">Sub menu 2</a></li>
                        <li><a href="#">Sub menu 3</a></li>
                        <li><a href="#">Sub menu 4</a></li>
                        <li><a href="#">Sub menu 5</a></li>
                  </ul>
                </li>
                <li><a href="about.html">About</a>
                    <ul>
                        <li><a href="http://www.cssmoban.com/">Sub menu 1</a></li>
                        <li><a href="#">Sub menu 2</a></li>
                        <li><a href="#">Sub menu 3</a></li>
                  </ul>
                </li>
                <li><a href="faqs.html">FAQs</a></li>
                <li><a href="checkout.jsp">Checkout</a></li>
                <li><a href="contact.html">Contact Us</a></li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->
        <div id="templatemo_search">
            <form action="#" method="get">
              <input type="text" value=" " name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
              <input type="submit" name="Search" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
            </form>
        </div>
    </div> <!-- END of templatemo_menubar -->
    
    <div id="templatemo_main">
    	<div id="sidebar" class="float_l">
        	<div class="sidebar_box"><span class="bottom"></span>
            	<h3>Categories</h3>   
                <div class="content"> 
                	<ul class="sidebar_list">
                    	<li class="first"><a href="#">Sed eget purus</a></li>
                        <li><a href="#">Vestibulum eleifend</a></li>
                        <li><a href="#">Nulla odio ipsum</a></li>
                        <li><a href="#">Suspendisse posuere</a></li>
                        <li><a href="#">Nunc a dui sed</a></li>
                        <li><a href="#">Curabitur ac mauris</a></li>
                        <li><a href="#">Mauris nulla tortor</a></li>
                        <li><a href="#">Nullam ultrices</a></li>
                        <li><a href="#">Nulla odio ipsum</a></li>
                        <li><a href="#">Suspendisse posuere</a></li>
                        <li><a href="#">Nunc a dui sed</a></li>
                        <li><a href="#">Curabitur ac mauris</a></li>
                        <li><a href="#">Mauris nulla tortor</a></li>
                        <li><a href="#">Nullam ultrices</a></li>
                        <li class="last"><a href="#">Sed eget purus</a></li>
                    </ul>
                </div>
            </div>
            
        </div>
        <div id="content" class="float_r">
        	<h1>Shopping Cart</h1>
        	<table width="680px" cellspacing="0" cellpadding="5">
                   	  <tr bgcolor="#ddd">
                        	<th width="220" align="left">Image </th> 
                        	<th width="180" align="left">Description </th> 
                       	  	<th width="100" align="center">Quantity </th> 
                        	<th width="60" align="right">Price </th> 
                        	<th width="90"> </th>
                            
                      </tr>
                      <s:iterator value="%{#session.cartItems}" var="cartItems">
    	              <tr>
    		                <td align="center"><img src="images/product/<s:property value='#cartItems.sp.product.image' />"/></td>
    		                <td align="center"><s:property value="#cartItems.sp.product.description" /></td>
    		                <td align="center"><s:property value="#cartItems.num" /></td>
    		                <td align="center"><s:property value="#cartItems.sp.product.price" /></td>
    		                <td align="center"> <a href="delproduct.action?pid=<s:property value='#cartItems.sp.SPId' />"><img src="images/remove_x.gif" alt="remove" /><br />Remove</a>  </td>
    	             </tr>
    	             </s:iterator>

                        <tr>
                        	<td colspan="3" align="right"  height="30px">Have you modified your basket? Please click here to <a href="cartlist.action"><strong>Update</strong></a>&nbsp;&nbsp;</td>
                            <td align="right" style="background:#ddd; font-weight:bold"> Total </td>
                            <td align="right" style="background:#ddd; font-weight:bold"> ${sessionScope.price} </td>
                            <td style="background:#ddd; font-weight:bold"> </td>
						</tr>
					</table>
                    <div style="float:right; width: 215px; margin-top: 20px;">
                    
					<p><a href="checkout.jsp?price=${sessionScope.price}">Proceed to checkout</a></p>
                    <p><a href="products.html">Continue shopping</a></p>
                    	
                    </div>
			</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	<p><a href="#">Home</a> | <a href="#">Products</a> | <a href="#">About</a> | <a href="#">FAQs</a> | <a href="#">Checkout</a> | <a href="#">Contact Us</a>
		</p>

		Copyright © 2072 <a href="#">Your Company Name</a> | Collect from <a href="http://www.cssmoban.com" target="_parent">网站模板</a>
    	
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->

</body>
</html>
