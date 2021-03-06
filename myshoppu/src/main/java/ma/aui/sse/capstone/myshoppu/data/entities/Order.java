package ma.aui.sse.capstone.myshoppu.data.entities;

import java.util.List;
import java.util.Map.Entry;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ma.aui.sse.capstone.myshoppu.data.dtos.ShoppingCart;




/**
 *
 * @author Youness Ayyada
 */
@Entity
@Table(name = "\"order\"")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 3959935433240472748L;

    @ManyToOne
    @NotNull
    protected User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<OrderItem> orderItems;

    protected OrderStatus status;
    protected float productsTotalPrice;
    protected float shippingCost;
    protected static final float TAX_RATE = (float) 0.2;

    protected Order() {
    }

    public Order(ShoppingCart shoppingCart, User user) {
        this.user = user;
        if (shoppingCart.getSelectedProducts() != null) {
            Iterator<Entry<Product, Integer>> it = shoppingCart.getSelectedProducts().entrySet().iterator();
            while (it.hasNext()) {
                Entry<Product, Integer> e = it.next();
                new OrderItem(this, e.getKey(), e.getValue());
            }
        }
        productsTotalPrice = shoppingCart.getProductsTotalPrice();
        shippingCost = shoppingCart.getShippingCost();
        status = OrderStatus.HANDLING;
    }

    public void updateStatus(OrderStatus newStatus) throws IllegalStatusChangeException {
        if (status == OrderStatus.CANCELED || status == OrderStatus.DELIVERED)
            throw new IllegalStatusChangeException(newStatus);
        status = newStatus;
        // Service:EmailUpdate(Order.Status) use JavaMail API to send a notification to the customer by email

    }

    public User getUser() {
        return user;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public float getProductsTotalPrice() {
        return productsTotalPrice;
    }

    public void setProductsTotalPrice(float productsTotalPrice) {
        this.productsTotalPrice = productsTotalPrice;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public List<OrderItem> getOrders() {
        return orderItems;
    }

    public void setOrderLines(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}