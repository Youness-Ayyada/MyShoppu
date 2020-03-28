package ma.aui.sse.capstone.myshoppu.data.repositeries;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.aui.sse.capstone.myshoppu.data.entities.Review;

/**
 *
 * @author Youness AYYADA
 */
@RepositoryRestResource
public interface ReviewRepository extends BaseRepository<Review>{
    // search for reviews of a product id
    @Query("select r from Review r where r.product.id = ?1")
    List<Review> findByProduct(long productId);
}