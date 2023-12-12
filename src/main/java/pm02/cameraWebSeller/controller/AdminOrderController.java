package pm02.cameraWebSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pm02.cameraWebSeller.data_access.entity.Order;
import pm02.cameraWebSeller.reponse.ResponseObject;
import pm02.cameraWebSeller.service.interfaces.AdminOrderService;

import java.util.List;

@RestController
@RequestMapping("/admin/orders")
public class AdminOrderController {
    private final AdminOrderService order;

    @Autowired
    public AdminOrderController(AdminOrderService order) {
        this.order = order;
    }

    @GetMapping("")
    public ResponseObject getOrders() {
        List<Order> orders = order.getOrders();
        return new ResponseObject("OK", "Successfully retrieved all orders", orders);
    }

    @GetMapping("/")
    public ResponseObject getOrderById(@RequestParam String id) {
        Order order = this.order.getOrderById(id);
        return new ResponseObject("OK", "Successfully retrieved order by ID = " + id, order);
    }

    @PostMapping("/confirm")
    public ResponseObject confirmOrder(@RequestParam String id) {
        order.confirmOrder(id);
        return new ResponseObject("OK", "Confirm order successfully", null);
    }
    @PostMapping("/cancel")
    public ResponseObject cancelOrder(@RequestParam String id) {
        order.cancelOrder(id);
        return new ResponseObject("OK", "Cancel order successfully", null);
    }
}
