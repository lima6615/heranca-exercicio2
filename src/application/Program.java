package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Product product;
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (ch == 'c') {
				product = new Product(name, price);
				list.add(product);
			} else if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customs = sc.nextDouble();
				product = new ImportedProduct(name, price, customs);
				list.add(product);
			} else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				product = new UsedProduct(name, price, manufactureDate);
				list.add(product);
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product c : list) {
			System.out.println(c.priceTag());
		}

		sc.close();
	}
}
