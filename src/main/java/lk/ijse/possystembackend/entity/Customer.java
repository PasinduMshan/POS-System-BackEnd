package lk.ijse.possystembackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer implements Serializable {
    private String Id;
    private String Name;
    private String Address;
    private String Tel;
    private String NIC;
}
