package ro.adina.application;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	
	//List<Greeting> greetings = new ArrayList<Greeting>();
	//@Autowired
	//GreetingRepository greetingRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	/*
	AppController(GreetingRepository repository) {
		this.greetingRepo = repository;
	}*/
	
	//List<Products> products = new ArrayList<Products>();
	/*@GetMapping("/greeting")
	public String greeting(@RequestParam(defaultValue = "world") Long id, Model model) {
		
		model.addAttribute("name", id);
		model.addAttribute("greetings", greetingRepo.findById(id));
		
		return "greeting.html";
	}
	
	@GetMapping("/getaddGreeting")
	public String addGreeting( Model model) {
		model.addAttribute("greeting", new Greeting());
		return "addGreeting";	
	}
	
	@PostMapping("/addGreeting")
	public String addGreeting(@RequestParam("content") String content, Model model) {
		
		
		Greeting newGreeting = new Greeting(content);
		greetingRepo.save(newGreeting);
		
		//greetings.add(newGreeting);
		
		model.addAttribute("greetings", greetingRepo.findAll());
		
		return "greeting";	
	}
	
	@GetMapping("/greetings")
	public Optional<Greeting> allGreetings(@RequestParam(defaultValue = "0") Long id) {
		return greetingRepo.findById(id);
	}
	
	@GetMapping("/allgreetings")
	public String Greetings(Model model) {
		model.addAttribute("greetings", greetingRepo.findAll());
		return "greeting";
	}*/
	@GetMapping({"/","/index"})
	public String home() {
		return "index";
	}
	
	@GetMapping("/product")
	public String product(@RequestParam(defaultValue = "world") Long id, Model model) {
		
		model.addAttribute("name", id);
		model.addAttribute("greetings", productRepo.findById(id));
		
		return "product";
	}
	
	@GetMapping("/getaddProduct")
	public String addProduct( Model model) {
		model.addAttribute("product", new Products());
		return "addProduct";	
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestParam("name") String name,@RequestParam("price") Double price, Model model) {
		
		Products newProduct = new Products(name, price);
		productRepo.save(newProduct);
		
		//greetings.add(newGreeting);
		
		model.addAttribute("products", productRepo.findAll());
		
		return "product";	
	}
	@GetMapping("/products")
	public Optional<Products> allProducts(@RequestParam(defaultValue = "0") Long id) {
		return productRepo.findById(id);
	}
	@GetMapping("/allproducts")
	public String Greetings(Model model) {
		model.addAttribute("products", productRepo.findAll());
		return "product";
	}
	
	@RequestMapping("/cart")
    public String cart(){
        return "cart";
    }
	
	@GetMapping("/addToList")
	public String readingList() {
		return "404";
	}
	
	/*@PostMapping("/addProducts")
	public Products addProduct(@RequestBody Products product) {
		System.out.println(product.getName());
		products.add(product);
		return product;	
	}
	
	@GetMapping("/products") 
	public List<Products> showProducts() {
		return products;
	}*/

}
