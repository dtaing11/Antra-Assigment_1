package com.example.antra.assignment.assignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class MovieService {

    private static final String BASE_URL =
        "https://jsonmock.hackerrank.com/api/moviesdata/search/";

    @Autowired
    private RestTemplate restTemplate;

    public List<Movie> fetchAllPages(Integer page, String title, Integer year) throws InterruptedException, ExecutionException {
        MovieResponse first = fetchPage(1, title, year);
        if (page != null) {
            MovieResponse response = fetchPage(page, title, year);
            return (response == null || response.getData() == null)
                    ? List.of()
                    : response.getData();
        }
        if (first == null) return List.of();
        int totalPages = first.getTotalPages();
        List<Movie> result = new ArrayList<>(first.getData());
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Callable<List<Movie>>> tasks = new ArrayList<>();
            for (int pageTask = 2;  pageTask <= totalPages; pageTask++) {
                final int p = pageTask;
                tasks.add(() -> fetchPage(p, title, year).getData());
            }
            var futures = executor.invokeAll(tasks);
            for (Future<List<Movie>> f : futures) {
                result.addAll(f.get());
            }
            return result;
        }
    }
    private MovieResponse fetchPage(int page, String title, Integer year) {
        UriComponentsBuilder builder =UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("page", page);
            if (title != null) {
                builder.queryParam("Title", title);
            }
            if (year != null) {
                builder.queryParam("Year", year);
            }
            return restTemplate.getForObject(
                builder.toUriString(),
                MovieResponse.class
            );
        }
}

