package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.db.DbConnection;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T>T execute(String sql, Object... ob) throws SQLException, NamingException {
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);

        for (int i = 0; i < ob.length; i++) {
            pstm.setObject(i+1, ob[i]);
        }

        if (sql.startsWith("SELECT")) {
            return (T)pstm.executeQuery();
        } else {
            return (T)(Boolean)(pstm.executeUpdate() > 0);
        }
    }
}
