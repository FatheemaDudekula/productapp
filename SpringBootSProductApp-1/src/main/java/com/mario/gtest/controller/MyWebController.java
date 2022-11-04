package com.mario.gtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mario.gtest.entity.Product;
import com.mario.gtest.service.ProductService;

@RestController
@RequestMapping("/user")
public class MyWebController {
	
	@Autowired
	ProductService productService;

	public MyWebController() {
		System.out.println("\n\n\n====>> Inside Constructor " + this);
	}

	@PostMapping("/Product")
	public String addUser(@RequestBody Product product) {

		try {
			return productService.insertProduct(product);
		} catch (Exception e) {
			return "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
		}
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {

		try {
			List<Product> allExtractedProducts = productService.getAllProducts();

			return allExtractedProducts;

		} catch (Exception e) {
			System.out.println(e);

		}

		return null;
	}

	@GetMapping("/product/{searchProductName}")
	public Product pro1(@PathVariable String searchProductName) throws Exception {
		return productService.getProductByProductName(searchProductName);
	}

	@GetMapping("/product/{searchProductCode}")
	public Product pro2(@PathVariable int searchProductCode) throws Exception {
		return productService.getProductByProductCode(searchProductCode);
	}

	@GetMapping("/product/{dealer}")
	public List<Product> pro3(@PathVariable String dealer) throws Exception {
		System.out.println(" --->> 1 Inside controller " + dealer);
		return productService.getAllProductsByDealerName(dealer);
	}

	@GetMapping("/product/{category}")
	public List<Product> pro4(@PathVariable String category) throws Exception {

		return productService.getProductByCategory(category);
	}

	@GetMapping("/productbycategoryandpriceanddealer")
	public List<Product> productsByCategoryAndPriceRangeAndDealerName(@RequestParam String category, @RequestParam float p1,
			@RequestParam float p2, @RequestParam String dlr) throws Exception {

		return productService.getProductsByCategoryAndPriceRangeAndDealerName(category, p1, p2, dlr);
	}
	
	@GetMapping("/productbycatgoryandpriceandrating")
	public List<Product> productsByCategoryAndPriceAndRating(@RequestParam String cat, @RequestParam float prc, @RequestParam float rate) throws Exception
	{
		return productService.getAllProductsByCategoryAndPriceAndRating(cat, prc, rate);
		
	}
}



