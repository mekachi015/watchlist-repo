package com.moviebuster.moviebuster.entity;


import com.moviebuster.moviebuster.entity.User;
import com.moviebuster.moviebuster.entity.Watchlist;
import com.moviebuster.moviebuster.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

public class Wacthlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String movieTitle;
    private String releaseDate;
    private double imdbRating;

    public Wacthlist() {}

    public Wacthlist (User user, String movieTitle, String releaseDate, double imdbRating) {
        this.user = user;
        this.movieTitle = movieTitle;
        this.releaseDate =releaseDate;
        this.imdbRating = imdbRating;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public String getMovieTitle(){
        return movieTitle;
    }

    public String setMovieTitile(){
        this.movieTitle = movieTitle;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public double getImdbRating(){
        return imdbRating;
    }

    public void setImdbRating(double imdbRating){
        this.imdbRating = imdbRating;
    }




}
