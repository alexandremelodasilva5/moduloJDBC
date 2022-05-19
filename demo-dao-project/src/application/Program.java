package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("---Teste 1 = seller findSellerById---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n---Teste 2 =  seller findByDepartment---");
		Department dep= new Department(2, null); 
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller sel:list) {
			System.out.println(sel);
		}
		
		System.out.println("\n---Teste 3 = seller findAll---"); 
		list = sellerDao.findAll();
		for(Seller sel:list) {
			System.out.println(sel);
		}
		
		System.out.println("\n---Teste 4 = seller insert---");
		Seller newSeller = new Seller(null, "Helena", "helena@gmail", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("id inserido: "+newSeller.getId());
		
		System.out.println("\n---Teste 5 = seller update---");
		seller = sellerDao.findById(1);
		seller.setName("Martha");
		sellerDao.update(seller);
		System.out.println("vendedor atualizado");
		
		System.out.println("\n---Teste 6 = seller delete---");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("id deletado");
		
		sc.close();
	}

}
