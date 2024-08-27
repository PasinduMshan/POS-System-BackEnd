package lk.ijse.possystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceOrderDto {
    private String placeOrderId;
    private Date date;
    private String orderCusId;
    private String orderCusName;
    private String orderCusAddress;
    private String orderItemId;
    private String orderItemName;
    private double orderItemPrice;
    private double orderItemQty;
    private double orderCash;
    private double orderDiscount;
    private double orderBalance;
    private double orderTotal;
    private double orderSubtotal;
}
