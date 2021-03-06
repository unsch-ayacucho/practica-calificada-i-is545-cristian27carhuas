package pe.edu.unsch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.unsch.entities.Item;
import pe.edu.unsch.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String cart(Model model) {
		model.addAttribute("titulo", "Cart : e-commerce");
		return "views/public/cart/index";
	}
	
	@GetMapping("/buy/{id}")
	public String add(@PathVariable("id") int id, HttpSession session, Model model) {
		
		model.addAttribute("titulo", "Cart : e-commerce");
		
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productService.find(id), 1));
			session.setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isEXists(id, session);
			
			if(index == -1) {
				cart.add(new Item(productService.find(id), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
				session.setAttribute("cart", cart); 
			}
			session.setAttribute("cart", cart);
		}
		
		return "views/public/cart/index";
	}
	
	@GetMapping("delete/{index}")
	public String delete(@PathVariable("index") int index, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart";
	}

	private int isEXists(int id, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getIdproduct() == id) {
				return i;
			}
		}
		
		return -1;
	}

}
