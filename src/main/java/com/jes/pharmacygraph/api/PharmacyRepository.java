package com.jes.pharmacygraph.api;

import com.jes.pharmacygraph.entities.Graph;
import com.jes.pharmacygraph.entities.HashNode;
import com.jes.pharmacygraph.entities.Node;
import com.jes.pharmacygraph.entities.TablaHash;

import org.springframework.stereotype.Repository;

public class PharmacyRepository {

    Graph graph;

    TablaHash hash;


    public PharmacyRepository(){
        this.hash = new TablaHash(25);
        this.graph = initializeGraph();
    }

    private Graph initializeGraph() {
        Graph data = new Graph();
        Node santaLucia = new Node("Santa Lucia");
        Node servisalud = new Node("Servisalud");
        Node bomba = new Node("La Bomba");
        Node sucre1 = new Node("Sucre Capitalina");
        Node sucre2 = new Node("Sucre");
        Node drLee = new Node("Dr Lee");
        Node frachel = new Node("Frachel");
        Node rusisan = new Node("Rusisan");
        Node sucre3 = new Node("Sucre Mercado Central");
        Node sucre4 = new Node("Sucre Plaza de la Democracia");
        Node macroSJ = new Node("Macrobiotica San Jose");
        Node rusisan2 = new Node("Rusisan #2");
        Node sucre5 = new Node("Sucre Paseo de los Estudiantes");
        Node botica = new Node("Botica San Jose");
        Node sucre6 = new Node("Sucre Avenida Tercera");
        Node macroGaviotas = new Node("Macrobiotica Las Gaviotas");
        Node farmaValue = new Node("Farma Value San Jose");
        Node universalHomeo = new Node("Universal Homeopatia");
        Node botica2 = new Node("Botica Internacional");
        Node fischel = new Node("Fischel");
        Node sucre7 = new Node("Sucre Avenida Central");
        Node saba = new Node("Saba San Jose");
        Node italiana = new Node("Italiana");
        Node bomba2 = new Node("La Bomba #2");
        Node fischel2 = new Node("Fischel #2");

        santaLucia.addDestination(sucre1, 100);
        santaLucia.addDestination(servisalud, 500);

        servisalud.addDestination(sucre1, 550);
        servisalud.addDestination(bomba, 550);
        servisalud.addDestination(drLee, 600);

        sucre1.addDestination(sucre2, 200);
        sucre1.addDestination(bomba, 400);

        drLee.addDestination(sucre4, 575);

        sucre2.addDestination(bomba, 200);
        sucre2.addDestination(frachel, 100);

        bomba.addDestination(drLee, 500);
        bomba.addDestination(macroSJ, 650);
        bomba.addDestination(sucre4, 600);
        bomba.addDestination(rusisan, 400);

        frachel.addDestination(rusisan, 100);

        rusisan.addDestination(sucre3, 200);
        rusisan.addDestination(sucre4, 750);

        sucre3.addDestination(macroSJ, 900);

        sucre4.addDestination(botica, 800);
        sucre4.addDestination(macroSJ, 500);

        macroSJ.addDestination(botica, 500);
        macroSJ.addDestination(rusisan2, 400);
        macroSJ.addDestination(farmaValue, 750);

        botica.addDestination(universalHomeo, 850);
        botica.addDestination(macroGaviotas, 150);
        botica.addDestination(farmaValue, 350);

        rusisan2.addDestination(sucre5, 300);

        sucre5.addDestination(farmaValue, 600);

        macroGaviotas.addDestination(universalHomeo, 900);
        macroGaviotas.addDestination(farmaValue, 150);
        macroGaviotas.addDestination(botica2, 400);

        farmaValue.addDestination(botica2, 100);

        universalHomeo.addDestination(sucre6, 200);
        universalHomeo.addDestination(botica2, 700);

        sucre6.addDestination(fischel, 550);

        botica2.addDestination(fischel, 600);
        botica2.addDestination(sucre7, 1000);

        sucre7.addDestination(fischel, 1200);
        sucre7.addDestination(fischel2, 900);

        fischel.addDestination(italiana, 1000);
        fischel.addDestination(saba, 850);

        saba.addDestination(italiana, 200);
        saba.addDestination(bomba2, 200);
        saba.addDestination(fischel2, 600);

        fischel2.addDestination(bomba2, 300);

        bomba2.addDestination(italiana, 400);
        
        
        data.addNode(santaLucia);
        data.addNode(servisalud);
        data.addNode(bomba);
        data.addNode(sucre1);
        data.addNode(sucre2);
        data.addNode(drLee);
        data.addNode(frachel);
        data.addNode(rusisan);
        data.addNode(sucre3);
        data.addNode(sucre4);
        data.addNode(macroSJ);
        data.addNode(rusisan2);
        data.addNode(sucre5);
        data.addNode(botica);
        data.addNode(sucre6);
        data.addNode(macroGaviotas);
        data.addNode(farmaValue);
        data.addNode(universalHomeo);
        data.addNode(botica2);
        data.addNode(fischel);
        data.addNode(sucre7);
        data.addNode(saba);
        data.addNode(italiana);
        data.addNode(bomba2);
        data.addNode(fischel2);

        for (Node i : data.getNodes()) {
            hash.add(i.getName());
        }
        return data;
    }

    public Graph getGraph() {
        return graph;
    }

    public TablaHash getHash() {
        return hash;
    }
}
