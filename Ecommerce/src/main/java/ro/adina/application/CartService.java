package ro.adina.application;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {
	
    private static final String SESSION_KEY_SHOPPING_CART = "shoppingCart";

    public ShoppingCart getCart(HttpSession session){
        ShoppingCart cart = (ShoppingCart) session.getAttribute(SESSION_KEY_SHOPPING_CART);

        if(cart == null){
            cart = new ShoppingCart();
            setCart(session, cart);
        }

        return cart;
    }

    public void setCart(HttpSession session, ShoppingCart cart){
        session.setAttribute(SESSION_KEY_SHOPPING_CART, cart);
    }

    public void removeCart(HttpSession session){
        session.removeAttribute(SESSION_KEY_SHOPPING_CART);
    }


}
