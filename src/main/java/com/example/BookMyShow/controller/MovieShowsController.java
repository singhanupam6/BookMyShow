package com.example.BookMyShow.controller;


import com.example.BookMyShow.model.MovieModel;
import com.example.BookMyShow.service.MovieShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieShowsController {

    @Autowired
    MovieShowsService movieShowsServiceObject;
    @PostMapping("/addMovie")
    public String addMovie(@RequestBody MovieModel movieModelObject){
        movieShowsServiceObject.addMovieShow(movieModelObject);
        return "movie added";
    }
    @GetMapping("/displayAllMovie")
    public List<MovieModel> displayAll(){
        return movieShowsServiceObject.displayAll();
    }

    @GetMapping("/displayMovieByName/{mname}")
    public Optional<MovieModel> displayByName(@PathVariable String mname){
        return movieShowsServiceObject.findByName(mname);
    }
    @GetMapping("/displayMovieById/{mid}")
    public Optional<MovieModel> findById(@PathVariable int mid){
        return movieShowsServiceObject.findById(mid);
    }

    @DeleteMapping("/deleteAllMovie")
    public String deleteAll(){
        return movieShowsServiceObject.deleteAll();
    }
    @DeleteMapping("/deleteMovieById/{mid}")
    public String deleteById(@PathVariable int mid){
        return movieShowsServiceObject.deleteById(mid);
    }

    @PutMapping("/updateMovie/{mid}")
    public String updateMovie(@PathVariable int mid, @RequestBody MovieModel moviemodelobj){
     return movieShowsServiceObject.update(mid,moviemodelobj);
}

}

