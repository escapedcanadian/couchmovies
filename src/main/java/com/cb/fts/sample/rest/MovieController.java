package com.cb.fts.sample.rest;


import java.util.List;

import com.cb.fts.sample.entities.vo.CoverVo;
import com.cb.fts.sample.entities.vo.Result;
import com.cb.fts.sample.service.ImageService;
import com.cb.fts.sample.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( maxAge = 3600)
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result search(@RequestParam("query") String query, @RequestParam(value = "filters", required = false) String filters, @RequestParam(value = "fuzzy", required = false) Boolean fuzzy) {
        return movieService.searchQuery(query, filters, fuzzy);
    }
    @RequestMapping(value = "/autocomplete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> autocomplete(@RequestParam("query") String query) {
        return movieService.autocomplete(query);
    }
    @RequestMapping(value = "/getCover", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CoverVo getCover(@RequestParam("movieName") String query) throws Exception {
        return imageService.getImg(query);
    }

}
