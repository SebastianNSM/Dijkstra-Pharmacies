package com.jes.pharmacygraph.entities;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Query{

    private String origin;
    private String destination;
    
    public Query(@JsonProperty("destination")String dest, @JsonProperty("origin") String origin){
        this.destination = dest;
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}