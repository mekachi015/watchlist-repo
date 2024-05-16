package com.moviebuster.moviebuster.service;

import com.moviebuster.moviebuster.entity.Wacthlist;
import com.moviebuster.moviebuster.repository.WatchListRepository;

import java.util.List;
import java.util.Optional;

public interface WatchlistService {

   void addToWatchlist(String username, Watchlist watchlist);
   void removeFromWatchlist(String username, Watchlist watchlist);
   List<Watchlist> getWatchlist(String username);
   boolean isMovieInWatchlist(String username, String movieTitle);
}
