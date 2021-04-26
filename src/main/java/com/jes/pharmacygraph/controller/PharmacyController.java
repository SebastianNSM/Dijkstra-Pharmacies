package com.jes.pharmacygraph.controller;

import com.jes.pharmacygraph.entities.Query;
import com.jes.pharmacygraph.service.PharmacyService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("api/v1/pharmacy")
@RestController
public class PharmacyController{

    @Autowired
    private PharmacyService pService;

    @PostMapping(consumes={"application/json"})
    public String getShortestPath(@RequestBody Query q){
        return pService.findShortestPath(q.getOrigin(), q.getDestination());
    }

    @PostMapping("/adjacency")
    public String getShortestPath(@RequestBody String name){
        return pService.findAdjacencyList(name);
    }

}