package com.example.BookMyShow.service;

import com.example.BookMyShow.model.MovieModel;
import com.example.BookMyShow.repository.MovieShowsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieShowsService {
    @Autowired
    MovieShowsRepository movieShowsRepositoryObject;

    public void addMovieShow(MovieModel movieModelObject){

        movieShowsRepositoryObject.save(movieModelObject);
    }
    public List<MovieModel> displayAll(){
        return movieShowsRepositoryObject.findAll();
    }
    public String deleteAll(){
        movieShowsRepositoryObject.deleteAll();
        return "All record is deleted";
    }
    public Optional<MovieModel> findByName(String mname){
        return movieShowsRepositoryObject.findByMname(mname);
    }

    public Optional<MovieModel> findById(int mid){
        return movieShowsRepositoryObject.findById(mid);

    }
    public String deleteById(int showid){
        movieShowsRepositoryObject.deleteById(showid);
        return "movie deleted";
    }

    public String update(int mid, MovieModel moviemodelobj) {
        if(movieShowsRepositoryObject.findById(mid)!=null){
            movieShowsRepositoryObject.deleteById(mid);
            movieShowsRepositoryObject.save(moviemodelobj);
            return "Movie details is updated";
        }
        else return "Movie id not exist in the data base";
    }
}