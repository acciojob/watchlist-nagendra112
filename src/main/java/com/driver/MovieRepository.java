package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieMap;
    HashMap<String, Director> directorMap;
    HashMap<String, List<String>> pairMap;

    public MovieRepository(){
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.pairMap = new HashMap<>();
    }

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director){
        if(pairMap.containsKey(director)){
            List<String> temp = pairMap.get(director);
            temp.add(movie);
            pairMap.put(director, temp);
        }
        else {
            List<String> temp = new ArrayList<>();
            temp.add(movie);
            pairMap.put(director, temp);
        }
    }

    public Movie getMovieByName(String movieName){
        return movieMap.get(movieName);
    }

    public Director getDirectorByName(String dirName){
        return directorMap.get(dirName);
    }

    public List<String> getMoviesByDirectorName(String dirName){
        return pairMap.get(dirName);
    }

    public List<String> findAllMovies(){
        List<String> movies = new ArrayList<>();
        for(String m : movieMap.keySet()){
            movies.add(m);
        }
        return movies;
    }

    public void deleteDirectorByName(String dirName){
        List<String> movielist = pairMap.get(dirName);
        for(String s : movielist){
            movieMap.remove(s);
        }
        directorMap.remove(dirName);
        pairMap.remove(dirName);
    }

    public void deleteAllDirectors() {
        for(String directorName : pairMap.keySet()){
            deleteDirectorByName(directorName);
        }
    }
}


















