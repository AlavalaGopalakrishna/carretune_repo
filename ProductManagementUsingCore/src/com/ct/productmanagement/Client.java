package com.ct.productmanagement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Client {

	public static void main(String[] args) {
		HashMap<Integer,Product> products=new HashMap<Integer,Product>();
		int productId=0;
		String productName,productDesc,productCategory=null;
		int productPrice=0;
		
		Scanner scan= new Scanner(System.in);
		while (true) {
		System.out.println("**********Product Managemrnt**********");
		System.out.println("1.Add Product");
		System.out.println("2.Update Product");
		System.out.println("3.Delete Product");
		System.out.println("4.Get Product");
		System.out.println("5.Get All Products");
		System.out.println("6.Get All Products Between Prices");
		System.out.println("7.Get All Products By Category");
		int option =scan.nextInt();
		switch (option) {
		case 1:
			System.out.println("Enter ProductId:");
			productId=scan.nextInt();
			System.out.println("Enter ProductName:");
			productName=scan.next();
			System.out.println("Enter ProductPrice:");
			productPrice=scan.nextInt();
			System.out.println("Enter ProductDesc:");
			productDesc=scan.next();
			System.out.println("Enter ProductCategory:");
			productCategory =scan.next();
			Product product=new Product(productId,productName,productPrice,productDesc,productCategory);
			products.put(productId,product);
			if(products.size()>0)
				System.out.println("product added successfully");
			break;
		case 2:
			System.out.println("Enter Exsisting ProductId:");
			productId=scan.nextInt();
			System.out.println("Enter ProductName:");
			productName=scan.next();
			System.out.println("Enter ProductPrice:");
			productPrice=scan.nextInt();
			System.out.println("Enter ProductDesc:");
			productDesc=scan.next();
			System.out.println("Enter ProductCategory:");
			productCategory =scan.next();
			Product product1=new Product(productId,productName,productPrice,productDesc,productCategory);
			products.put(productId,product1);
			if(products.size()>0)
				System.out.println("product Updated successfully");
			break;
		case 3:
			System.out.println("Enter Exsisting ProductId:");
			productId=scan.nextInt();
			products.remove(productId);
			System.out.println("Product Removed Successfully");
			break;
		case 4:
			System.out.println("Enter Exsisting ProductId:");
			productId=scan.nextInt();
			Product prod=products.get(productId);
			System.out.println(prod);
			break;
		case 5:
			Set<Integer> keys=products.keySet();
			Iterator <Integer> itr =keys.iterator();
			while(itr.hasNext()) {
				int key =itr.next();
				System.out.println(products.get(key));
			}
			break;
		case 6:
			System.out.println("Enter Min ProductPrice:");
			int minProductPrice=scan.nextInt();
			System.out.println("Enter Mix ProductPrice:");
			int maxProductPrice=scan.nextInt();
			keys =products.keySet();
			itr = keys.iterator();
			while(itr.hasNext()) {
				int key = itr.next();
				Product product2 = products.get(key);
				productPrice=product2.getProductPrice();
				if(productPrice >= minProductPrice && productPrice <= maxProductPrice)
					System.out.println(product2);
			}
			break;
		case 7:
			System.out.println("Enter ProductCategory:");
			productCategory=scan.next();
			keys =products.keySet();
			itr = keys.iterator();
			while(itr.hasNext()) {
				int key = itr.next();
				Product product2 = products.get(key);
				String productCategory1=product2.getProductCategory();
				if(productCategory.equals(productCategory1))
					System.out.println(product2);
			}
			break;
			default:
				System.out.println("Thank You !!!!!");
				System.exit(0);
				break;
		}
	}
}
}