package com.coyotestudio.healthyfruitsinfo.model;

public class Fruta {

    private String nombre = "";
    private String imagen = "";
    private int calorias = 0;
    private double agua = 0.0;
    private double fibra = 0.0;
    private double proteinas = 0.0;
    private double grasas = 0.20;
    private String minerales = "";
    private String vitaminas = "";
    private String propiedades = "";

    public Fruta(){
        
    }

    public Fruta(String nombre, String imagen, int calorias, double agua, double fibra, double proteinas, double grasas,
                 String minerales, String vitaminas, String propiedades) {

        this.nombre = nombre;
        this.imagen = imagen;
        this.calorias = calorias;
        this.agua = agua;
        this.fibra = fibra;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.minerales = minerales;
        this.vitaminas = vitaminas;
        this.propiedades = propiedades;
    }

    public String getNombre() {
       return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public double getFibra() {
        return fibra;
    }

    public void setFibra(double fibra) {
        this.fibra = fibra;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public String getMinerales() {
        return minerales;
    }

    public void setMinerales(String minerales) {
        this.minerales = minerales;
    }

    public String getVitaminas() {
        return vitaminas;
    }

    public void setVitaminas(String vitaminas) {
        this.vitaminas = vitaminas;
    }

    public String getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(String propiedades) {
        this.propiedades = propiedades;
    }
}
