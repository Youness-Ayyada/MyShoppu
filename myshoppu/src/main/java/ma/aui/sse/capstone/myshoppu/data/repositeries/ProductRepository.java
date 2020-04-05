/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.aui.sse.capstone.myshoppu.data.repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.aui.sse.capstone.myshoppu.data.entities.Product;

/**
 *
 * @author Youness AYYADA
 */
@RepositoryRestResource
public interface ProductRepository extends BaseRepository<Product> {
        
        @Query("select p from Product p where p.name like %?1%")
        List<Product> findByName(String name);

        @Query("select p from Product p where p.name like %?1% and p.price between ?2 and ?3")
        List<Product> findByNameAndPrice(String name, float min, float max);

        @Query("select p from Product p where p.category.id = ?1")
        List<Product> findByCategory(long categoryId);

        @Query("select p from Product p where p.category.id = ?1 and p.price between ?2 and ?3")
        List<Product> findByCategoryAndPrice(long categoryId, float min, float max);

        @Query("select p from Product p where p.shop.id = ?1")
        List<Product> findByShop(long shopID);

        @Query("select p from Product p where p.shop.id = ?1 and p.price between ?2 and ?3")
        List<Product> findByShopAndPrice(long shopId, float min, float max);

        @Query("select p from Product p where p.category.id = ?1 and p.shop.id = ?2")
        List<Product> findByCategoryAndShop(long categoryId, long shopId);

        @Query("select p from Product p where p.category.id =?1 and p.shop.id = ?2 and p.price between ?3 and ?4")
        List<Product> findByCategoryAndShopAndPrice(long categoryId, long shopId, float min, float max);
}
