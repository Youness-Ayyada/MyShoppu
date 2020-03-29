package ma.aui.sse.capstone.myshoppu.data.repositeries;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import ma.aui.sse.capstone.myshoppu.data.entities.Order;

/**
 *
 * @author Youness AYYADA
 */
public interface OrderRepository extends BaseRepository<Order>{
    @Query("select o from Order o where o.user.id = ?1")
    List<Order> findByCustomer(long userId);
}