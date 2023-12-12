package dataModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {
    private String id;
    private String productName;
    private String cardName;
    private String cardNumber;
    private String cvc;
    private String expiryMonth;
    private String expiryYear;
}
