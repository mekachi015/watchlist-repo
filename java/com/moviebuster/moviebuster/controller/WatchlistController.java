package com.moviebuster.moviebuster.controller;

import com.moviebuster.moviebuster.entity.Wacthlist;
import com.moviebuster.moviebuster.service.WatchlistService;

import java.lang.annotation.Target;
import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    private WatchlistService watchlistService;

    @Autowired
    public WatchlistController(WatchlistService watchlistService){
        this.watchlistService = watchlistService;
    }

    @GetMapping
    public ResponseEntityList<List<Watchlist>> getAllWatchlistItems(){
        List<Watchlist> watchlistItems = watchlistService.getALLWatchListItems();
        return new ResposneEntity <> (watchlistItems, HTTPStatus.OK);
    }

    @PostMapping
    public ResponeEntity<Watchlist> addToWatchlist(@RequestBody Watchlist watchlist){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        watchlist.setUser(user);

        Watchlist savedWatchlistItems = watchlistService.addToWatchlist(watchlist);
        return new ResponseEntity<>(savedWatchlistItems, HttStaus.CREATED)
    }

    //Adds movie to wacth-list according to jwt token
//    @PostMapping("/add")
//    public ResponseEntity<?> addToWatchlist(@RequestBody Watchlist watchlist) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName(); // Extract username from JWT token
//
//        // Check if the movie already exists in the user's watchlist
//        if (watchlistService.isMovieInWatchlist(username, watchlist.getMovieTitle())) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Movie already exists in the watchlist.");
//        }
//
//        // Add movie to watchlist
//        watchlistService.addToWatchlist(username, watchlist);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Movie added to watchlist.");
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFromWacthlist(@PathVariable Long id){
        watchlistService.removeFormWacthlist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    //Removing User movie by id using the jwt token
//    @PostMapping("/remove")
//    public ResponseEntity<?> removeFromWatchlist(@RequestBody Watchlist watchlist) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName(); // Extract username from JWT token
//
//        // Remove movie from watchlist
//        watchlistService.removeFromWatchlist(username, watchlist);
//        return ResponseEntity.status(HttpStatus.OK).body("Movie removed from watchlist.");
//    }


    //Getting user watchlist
    @GetMapping("/list")
    public ResponseEntity<List<Watchlist>> getWatchlist() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Extract username from JWT token

        // Get user's watchlist
        List<Watchlist> watchlist = watchlistService.getWatchlist(username);
        return ResponseEntity.status(HttpStatus.OK).body(watchlist);
    }


}
