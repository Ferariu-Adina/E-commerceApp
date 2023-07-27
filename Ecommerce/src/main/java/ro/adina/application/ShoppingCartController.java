package ro.adina.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {
	
	/*ShoppingCart newCart = new ShoppingCart();
	
	@RequestMapping("/cart") 
	public String addToCart(Model model) {
		
		
		
		model.addAttribute("products", newCart.getAllProducts());
		
		return "cart";
	}
	
	@RequestMapping("/addProductToCart")
	public String addProduct( @RequestParam("id") Products product, Model model) {
		newCart.addProduct(product);
		model.addAttribute("product", newCart.getProductFromCart(product));
		return "addToCart";	
	}*/
	@Autowired
	ProductRepository productRepo;
	@Autowired
	CartService cartService;
	@PostMapping("/addToCart")
    public String add(HttpSession session, @RequestParam("product") Products product/* @RequestParam(value = "id") Long id/*, @RequestParam(defaultValue = "0") Products product , @RequestParam(defaultValue = "0") double price*/,  Model model){
		//Products product = new Products(name, price);
        ShoppingCart cart = cartService.getCart(session);
       /* for(Products product :productRepo.findAll()) {
        cart.addProduct(product);
        }*/
        cart.addProduct(product);
        System.out.println(cart.getTotal());
        model.addAttribute("total", cart.getTotalPrice());
        model.addAttribute("session.shoppingCart", cart);
        return "cart";
    }
	
	@GetMapping("/getaddCart")
	public String addProduct( Model model) {
		model.addAttribute("product", new Products());
		return "addToCart";	
	}
	
	@PostMapping("/addCart")
	public String addProduct(HttpSession session, @RequestParam(value = "name", required = false) String name, @RequestParam(value ="price", required = false) Double price, Model model) {
		ShoppingCart cart = cartService.getCart(session);
		Products newProduct = new Products(name, price);
		//cart.addProduct(productRepo.getReferenceById(id));
		cart.addProduct(newProduct);
		//greetings.add(newGreeting);
		
		//model.addAttribute("total", cart.getTotal());
		model.addAttribute("session.shoppingCart", cart);
		
		return "cart";	
	}
	
	

}
