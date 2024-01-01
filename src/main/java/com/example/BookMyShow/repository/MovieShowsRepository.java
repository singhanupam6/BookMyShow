package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface MovieShowsRepository extends JpaRepository<MovieModel,Integer> {
    Optional<MovieModel> findByMname(String name);

}
