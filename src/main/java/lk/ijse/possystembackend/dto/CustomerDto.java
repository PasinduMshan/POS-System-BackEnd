package lk.ijse.possystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto implements Serializable {
    private String Id;
    private String Name;
    private String Address;
    private String Tel;
    private String NIC;
}
