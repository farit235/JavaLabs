package com;

import java.io.Serializable;

/**
 *
 ** @author Sibgatulin Farit PIN-32
 * @version 0.0.1
 */

public class Vehicle implements Serializable {
    /** Property - brand */
    private String brand;
    /** Property - model */
    private String model;

    /**
     * Function for getting the value of the field
     * @return returns the name brand
     */
    public String getBrand(){
        return brand;
    }

    /**
     * Procedure for determining brand
     *
     */
    public void setBrand(String brand){
        this.brand = brand;
    }

    /**
     * Function for getting the value of the field
     * @return returns the name model
     */
    public String getModel(){
        return model;
    }

    /**
     * Procedure for determining model
     *
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**creating a new object Vehicle*/
    protected Vehicle(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    protected Vehicle(){
        String[] listBrand = {"Mercedes", "Honda", "Lada", "Porsche", "Volvo", "RR", "Niva", "1", "2", "3"};
        String[] listModel =  {"A-class", "Accord", "2101", "Panamera", "XC90", "Phantom", "Riga", "1", "2", "3"};
        int indexBrand = (int) Math.random()*10;
        int indexModel = (int) Math.random()*10;
        brand = listBrand[indexBrand];
        model = listModel[indexModel];
    }


    /**overriding String method*/
    public String toString() {
        return "Vehicle: " + brand + "\t" + model ;
    }
}


