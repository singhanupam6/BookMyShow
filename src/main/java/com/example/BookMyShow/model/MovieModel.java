package com.example.BookMyShow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MovieModel {
    @Id
    private int mid;
    private String mname;
    private int ticketPrice;
    private int seatAvailable;
    private String showTime;
}
