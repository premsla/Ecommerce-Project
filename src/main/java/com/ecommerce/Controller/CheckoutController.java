package com.ecommerce.Controller;
import com.ecommerce.service.CheckoutService;
import static com.ecommerce.service.UserService.user_id;

public class CheckoutController {

    public void checkout() {
        CheckoutService service = new CheckoutService();
        service.checkout(user_id);
    }
}