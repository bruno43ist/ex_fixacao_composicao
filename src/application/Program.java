package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;



public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date h = new Date();
		
		
		System.out.println("Enter client data: ");
		
		System.out.println("Name: ");
		String name = sc.nextLine();
		
		System.out.println("Email: ");
		String email = sc.nextLine();

		System.out.println("Birth date: ");
		Date date = sdf.parse(sc.next());
		
		Client cliente = new Client(name,email,date);
		
		System.out.println("Enter order data: ");
		
		System.out.println("Status: ");
		String status = sc.next();
		OrderStatus os1 = OrderStatus.valueOf(status);
		
		Order order = new Order(new Date(), os1, cliente);
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			
			System.out.println("Product name: ");
			sc.nextLine();
			String proname = sc.nextLine();
			
			System.out.println("Product price: ");
			double proprice = sc.nextDouble();
			
			System.out.println("Quantity: ");
			int qtd = sc.nextInt();
			
			Product product = new Product(proname,proprice);
			OrderItem item = new OrderItem(qtd,proprice,product);
			order.addItem(item);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
	}

}
