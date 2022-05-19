package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("---Teste 1 = findSellerById---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("---Teste 2 = findByDepartment---");
		Department dep= new Department(2, null); 
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller sel:list) {
			System.out.println(sel);
		}
	}

}
