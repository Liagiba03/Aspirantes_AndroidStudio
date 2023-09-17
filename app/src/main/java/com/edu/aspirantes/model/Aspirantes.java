package com.edu.aspirantes.model;

public class Aspirantes {
    private String carrera;
    private String nombre;
    private double promedioBa;
    private int tipoBa;

    public void setCarrera(String carrera) {

        this.carrera = carrera;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setPromedioBa(double promedioBa) {

        this.promedioBa = promedioBa;
    }

    public void setTipoBa(int tipoBa) {

        this.tipoBa = tipoBa;
    }

    public String estatus(){
        String sta;
        if(promedioBa>=90 || (tipoBa==1 && promedioBa>=80)){//Bacillerato fisico matematico es 1
            sta="ACEPTADO";
        }else {
            sta="RECHAZADO";
        }
        return "Estudiante: "+nombre+"\nHas sido: "+sta
                +"\nEn la carrera de "+carrera;
    }
}
