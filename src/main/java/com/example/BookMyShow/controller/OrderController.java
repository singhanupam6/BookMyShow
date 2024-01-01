package com.example.BookMyShow.controller;

import com.example.BookMyShow.model.OrderModel;
import com.example.BookMyShow.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService orderServiceObj;

    @PostMapping ("/addOrder")
    public String addOrder(@RequestBody OrderModel orderModelObj){
        return orderServiceObj.addOrder(orderModelObj);
    }
    @GetMapping ("/displayAllOrder")
    public List<OrderModel> displayall(){
        return orderServiceObj.displayallOrders();
    }
    @GetMapping ("/displayOrderByID/{oid}")
    public Optional<OrderModel> displayId(@PathVariable int oid)
    {
        return orderServiceObj.displayById(oid);
    }

    @DeleteMapping("/deleteAllOrder")
    public String DeleteAll(){
        return orderServiceObj.deleteAll();
    }
    @DeleteMapping("/deleteOrderByID/{oid}")
    public String deleteById(@PathVariable int oid)
    {
        return orderServiceObj.deleteById(oid);
    }


}
