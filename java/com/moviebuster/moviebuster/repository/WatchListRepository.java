package com.moviebuster.moviebuster.repository;

import com.moviebuster.moviebuster.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WatchListRepository extends JpaRepository <Wacthlist, Long>{
    List<Wacthlist>findByUserId(User user, String movieTitle);
}
