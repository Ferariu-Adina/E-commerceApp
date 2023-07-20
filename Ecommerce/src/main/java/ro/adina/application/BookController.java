package ro.adina.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	List<Book> bookList = new ArrayList<Book>();
	
	@GetMapping("/bookList")
	public String getBookList(Model model) {
		if(bookList.isEmpty()) {
		bookList.add(new Book("asasd","ssad","ssdsa"));
		bookList.add(new Book("sdsdds","ssad","ssdsa"));
		bookList.add(new Book("asasd","ssad","ssdsa"));
		}
		
		model.addAttribute("books", bookList);
		
		return "allBooks";
	}

}
