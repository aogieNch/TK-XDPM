package pm02.cameraWebSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pm02.cameraWebSeller.service.interfaces.AdminOrderService;

@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {
    private final AdminOrderService order;

    @Autowired
    public AdminOrderController(AdminOrderService order) {
        this.order = order;
    }

    @GetMapping("")
    public void getOrders() {
        order.getOrders();
    }

    @GetMapping("/")
    public void getOrderById(@RequestParam String id) {
        order.getOrderById(id);
    }

    @PutMapping("/")
    public void confirmOrder(@RequestParam String id) {
        order.confirmOrder(id);
    }
    @PutMapping("/")
    public void cancelOrder(@RequestParam String id) {
        order.cancelOrder(id);
    }
}
