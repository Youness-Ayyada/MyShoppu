package ma.aui.sse.capstone.myshoppu.services;

import org.springframework.stereotype.Service;

import ma.aui.sse.capstone.myshoppu.data.entities.Product;
import ma.aui.sse.capstone.myshoppu.data.dtos.ShoppingCart;
import ma.aui.sse.capstone.myshoppu.data.repositeries.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;



/**
 *
 * @author Youness AYYADA
 */
@Service
public class ShoppingCartService {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "ShoppingCart")
    public ShoppingCart getShoppingCart(long userId){
        return new ShoppingCart();
    }

    @CachePut(value = "ShoppingCart", key = "#userId")
    public ShoppingCart addProduct(ShoppingCart shoppingCart, long userId, long productId, int quantity){
        Product product = productRepository.findById(productId).get();
        shoppingCart.addProduct(product, quantity);
        return shoppingCart;
    }

    @CachePut(value = "ShoppingCart", key = "#userId")
    public ShoppingCart decreaseProductQuantity(ShoppingCart shoppingCart, long userId, long productId, int quantity){
        Product product = productRepository.findById(productId).get();
        shoppingCart.removeProduct(product, quantity);
        return shoppingCart;
    }

    @CachePut(value = "ShoppingCart", key = "#userId")
    public ShoppingCart removeProduct(ShoppingCart shoppingCart, long userId, long productId){
        Product product = productRepository.findById(productId).get();
        shoppingCart.removeProduct(product);
        return shoppingCart;
    }

    @CachePut(value = "ShoppingCart", key = "#userId")
    public ShoppingCart empty(ShoppingCart shoppingCart, long userId){
        shoppingCart.empty();
        return shoppingCart;
    }
}