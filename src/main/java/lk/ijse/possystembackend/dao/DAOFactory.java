package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.possystembackend.dao.custom.impl.ItemDAOImpl;
import lk.ijse.possystembackend.dao.custom.impl.PlaceOrderDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getDAOFactory() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, PLACE_ORDER
    }

    public SuperDAO getDAO(DAOTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case PLACE_ORDER:
                return new PlaceOrderDAOImpl();
            default:
                return null;
        }

    }
}
