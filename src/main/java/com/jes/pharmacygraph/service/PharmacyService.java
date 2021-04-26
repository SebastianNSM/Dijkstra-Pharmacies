package com.jes.pharmacygraph.service;
import org.springframework.stereotype.Service;

@Service
public interface PharmacyService{
    String findShortestPath(String origin, String destination);
    String findAdjacencyList(String name);
}