package com.moviebuster.moviebuster.service;


import com.moviebuster.moviebuster.entity.Watchlist;
import com.moviebuster.moviebuster.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.moviebuster.moviebuster.entity.Wacthlist;
import com.moviebuster.moviebuster.entity.Watchlist;
import com.moviebuster.moviebuster.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchListImplementation implements WatchlistService {

    private  WatchlistRepository watchlistRepository;
    private  UserRepository userRepository;

    @Autowired
    public WatchlistServiceImpl(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }
//    //Getting jwt
//    @Autowired
//    public WatchlistServiceImpl(WatchlistRepository watchlistRepository, UserRepository userRepository) {
//        this.watchlistRepository = watchlistRepository;
//        this.userRepository = userRepository;
//    }





    @Override
    public List<Watchlist> getAllWatchlistItems() {
        return watchlistRepository.findAll();
    }

    @Override
    public Watchlist addToWatchlist(Watchlist watchlist) {
        return watchlistRepository.save(watchlist);
    }

//    //Adding to the list of a regular user
//    @Override
//    public void addToWatchlist(String username, Watchlist watchlist) {
//        User user = userRepository.findByUsername(username);
//        watchlist.setUser(user);
//        watchlistRepository.save(watchlist);
//    }

    @Override
    public void removeFromWatchlist(Long id) {
        watchlistRepository.deleteById(id);
    }

    //Removing from watchlist- jwt
//    @Override
//    public void removeFromWatchlist(String username, Watchlist watchlist) {
//        User user = userRepository.findByUsername(username);
//        watchlist.setUser(user);
//        watchlistRepository.delete(watchlist);
//    }

    @Override
    public boolean isMovieInWatchlist(String username, String movieTitle) {
        User user = userRepository.findByUsername(username);
        return watchlistRepository.existsByUserAndMovieTitle(user, movieTitle);
    }
}
