package ma.aui.sse.capstone.myshoppu.data.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;;

/**
 *
 * @author Youness AYYADA
 */
@Entity
public class Review extends BaseEntity {

    private static final long serialVersionUID = 8080148085913683937L;

    @ManyToOne
    @NotNull
    private Product product;

    @NotNull
    private String comment;

    private float grade;

    protected Review() {
    }

    public Review(String comment, float grade, Product product) {
        this.comment = comment;
        this.grade = grade;
        this.product = product;
    }

    public String getEval() {
        return comment;
    }

    public void setEval(String comment) {
        this.comment = comment;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Product getProduct() {
        return product;
    }
}