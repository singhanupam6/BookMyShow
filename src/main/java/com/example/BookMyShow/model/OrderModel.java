package com.example.BookMyShow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderModel {
    @Id
    private int oid;
    private String customerName;
    private Long phno;
    private int ticketNumber;










    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="mid")
    MovieModel moviemodelobj;
}
