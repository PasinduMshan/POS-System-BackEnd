package lk.ijse.possystembackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceOrder {
    private String OrderId;
    private Date date;
    private String orderCusId;
    private String orderItemId;
    private double orderItemPrice;
    private double orderItemQty;
    private double orderCash;
    private double orderDiscount;
    private double orderBalance;
    private double orderTotal;
    private double orderSubtotal;
}
