package com.example.BookMyShow.service;

import com.example.BookMyShow.model.MovieModel;
import com.example.BookMyShow.model.OrderModel;
import com.example.BookMyShow.repository.MovieShowsRepository;
import com.example.BookMyShow.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
     OrderRepository orderRepositoryObj;

    @Autowired
    MovieShowsRepository movieShowsRepositoryobj;

    public String addOrder(OrderModel orderModelObj) {
        List<MovieModel> mobj = movieShowsRepositoryobj.findAll();
        try{
            for(int i=0;i< mobj.size();i++){
                MovieModel movieModel=mobj.get(i);
                int totalseat=movieModel.getSeatAvailable();
                if(orderModelObj.getTicketNumber()<=totalseat){
                    orderRepositoryObj.save(orderModelObj);
                    return "Order is done";
                }
            }

            return "Insufficient number of seats";
        }
        catch(Exception ex){
            return "catch: " + ex.getMessage();
        }
    }

    public List<OrderModel>displayallOrders(){
        return orderRepositoryObj.findAll();
    }


    public Optional<OrderModel> displayById(int orderId) {
        return orderRepositoryObj.findById(orderId);
    }

    public String deleteAll()
    {
        orderRepositoryObj.deleteAll();
        return "All Orders Deleted";
    }

    public String deleteById(@PathVariable int id)
    {
        orderRepositoryObj.deleteById(id);
        return "Order Deleted";
    }
    public String update(int orderId, OrderModel orderModelObj)
    {
        if (orderRepositoryObj.findById(orderId) != null)
        {
            orderRepositoryObj.deleteById(orderId);
            orderRepositoryObj.save(orderModelObj);
            return "updated";

        }
        return "Order not there";
    }

}
