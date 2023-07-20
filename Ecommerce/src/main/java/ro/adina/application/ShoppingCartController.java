package ro.adina.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/addToCart")
    public String add(HttpSession session, @RequestParam(defaultValue = "1") Long id/*, @RequestParam(defaultValue = "0") Products product , @RequestParam(defaultValue = "0") double price*/,  Model model){
		//Products product = new Products(name, price);
        ShoppingCart cart = cartService.getCart(session);
       /* for(Products product :productRepo.findAll()) {
        cart.addProduct(product);
        }*/
        cart.addProduct(productRepo.getReferenceById(id));
        model.addAttribute("session.shoppingCart", cart);
        return "cart";
    }
	
	

}
