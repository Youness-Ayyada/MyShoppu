package ma.aui.sse.capstone.myshoppu.data.entities;

/**
 *
 * @author Youness Ayyada
 */
public class IllegalStatusChangeException extends RuntimeException {
    private static final long serialVersionUID = -199006397514123367L;
    private OrderStatus problematicStatus;
    
    public IllegalStatusChangeException() {
        super();
    }

    public IllegalStatusChangeException(OrderStatus problematicStatus) {
        super();
        this.problematicStatus = problematicStatus;
    }

    public OrderStatus getProblematicStatus() {
        return problematicStatus;
    }
}
