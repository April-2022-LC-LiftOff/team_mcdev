package ingis.microgreenappapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import net.bytebuddy.build.ToStringPlugin;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "customer_orders")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "delivery_date")
    private LocalDate deliveryDate;
    @Column(name = "active_order")
    private Boolean activeOrder;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="orderId")
    private  List<OrderDetails> orderDetails = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;


    public CustomerOrder() {

    }

    public CustomerOrder(LocalDate orderDate, LocalDate deliveryDate, Boolean activeOrder, List<OrderDetails> orderDetails, Customer customer) {
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.activeOrder = activeOrder;
        this.orderDetails = orderDetails;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Boolean getActiveOrder() {
        return activeOrder;
    }

    public void setActiveOrder(Boolean activeOrder) {
        this.activeOrder = activeOrder;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
