package ma.aui.sse.capstone.myshoppu.data.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Youness AYYADA
 */
@Entity
public class Shop extends BaseEntity {

    private static final long serialVersionUID = -7014503160098567776L;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Product> products;

    protected Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}