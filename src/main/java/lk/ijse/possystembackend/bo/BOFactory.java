package lk.ijse.possystembackend.bo;

import lk.ijse.possystembackend.bo.custom.impl.CustomerBOImpl;
import lk.ijse.possystembackend.bo.custom.impl.ItemBOImpl;
import lk.ijse.possystembackend.bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {   }

    public static BOFactory getBoFactory() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER, ITEM, PLACE_ORDER
    }

    public SuperBO getBO(BOTypes boType) {
        switch (boType) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }

    }

}
