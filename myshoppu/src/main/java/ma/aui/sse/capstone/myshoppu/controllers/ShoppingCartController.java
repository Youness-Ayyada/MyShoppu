package ma.aui.sse.capstone.myshoppu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.aui.sse.capstone.myshoppu.data.dtos.Product;
import ma.aui.sse.capstone.myshoppu.data.dtos.ShoppingCart;
import ma.aui.sse.capstone.myshoppu.services.ShoppingCartService;

import org.springframework.security.test.context.support.WithMockUser;



/**
 *
 * @author Youness AYYADA
 */
@RestController
@RequestMapping("/rest/shoppingCart")
@WithMockUser
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/get")
    public ShoppingCart getShoppingCart(/* Authentication auth */){
        //Retrieve userId from JWT-based security context
        //auth.getPrinciple()
        long userId = 0; //To be removed
        System.out.println(shoppingCartService);
        return shoppingCartService.getShoppingCart(userId);
    }

    @PatchMapping("/addProduct")
    public ShoppingCart addProduct(@RequestBody Product dto){
        //Retrieve userId from JWT-based security context
        //auth.getPrinciple()
        long userId = 0; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        return shoppingCartService.addProduct(shoppingCart, userId,
                                                dto.getId(),
                                                dto.getQuantity());
    }

    @PatchMapping("/decreaseProductQuantity")
    public ShoppingCart decreaseProductQuantity(@RequestBody Product dto){
        //Retrieve userId from JWT-based security context
        //auth.getPrinciple()
        long userId = 0; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        return shoppingCartService.decreaseProductQuantity(shoppingCart, userId, dto.getId(),
                                                    dto.getQuantity());
    }

    @PatchMapping("/removeProduct")
    public ShoppingCart removeProduct(@RequestBody Product dto){
        //Retrieve userId from JWT-based security context
        //auth.getPrinciple()
        long userId = 0; //To be removed
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        return shoppingCartService.removeProduct(shoppingCart, userId, dto.getId());
    }
}