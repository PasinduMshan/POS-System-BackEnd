package lk.ijse.possystembackend.controllers;

import jakarta.json.JsonException;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.possystembackend.bo.BOFactory;
import lk.ijse.possystembackend.bo.custom.CustomerBO;
import lk.ijse.possystembackend.dto.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer", loadOnStartup = 2)
public class CustomerController extends HttpServlet {

    CustomerBO  customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    static Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @Override
    public void init() throws ServletException {
        logger.info("Initializing CustomerController");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(!req.getContentType().toLowerCase().startsWith("application/json")|| req.getContentType() == null){
            //send error
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        // Persist Data

        try (var writer = resp.getWriter()){

            Jsonb jsonb = JsonbBuilder.create();
            CustomerDTO customerDto = jsonb.fromJson(req.getReader(), CustomerDTO.class);


            if (customerBO.saveCustomer(customerDto)){
                writer.write("Student saved successfully");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }else {
                writer.write("Save student failed");
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (JsonException | SQLException | NamingException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(e);
        }

    }
}
