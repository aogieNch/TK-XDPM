package pm02.cameraWebSeller.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
    private String productId;
    private int quantity;

    private String name;
    private String address;
    private String phone;
    private String gmail;
}
