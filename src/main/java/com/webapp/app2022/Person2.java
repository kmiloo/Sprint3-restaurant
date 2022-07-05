package com.webapp.app2022;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person2 {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String nombre;
    private String rut;
    private LocalDate fecha;
    private String planComida;
    private String planDegustacion;
    private String comensales;
    private String mesas;
    

    Person2(String nombre, String rut, LocalDate fecha,String planComida,String planDegustacion,String comensales,String mesas){
        this.nombre = nombre;
        this.rut = rut;
        this.fecha = fecha;
        this.planComida = planComida;
        this.planDegustacion = planDegustacion;
        this.comensales = comensales;
        this.mesas = mesas;
        

    }
    public Person2(){
        
    }

    public String getPlanDegustacion() {
        return planDegustacion;
    }
    public void setPlanDegustacion(String planDegustacion) {
        this.planDegustacion = planDegustacion;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getnombre() {
        return nombre;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    public String getrut() {
        return rut;
    }
    public void setrut(String rut) {
        this.rut = rut;
    }
    public String getcomensales() {
        return comensales;
    }
    public void setcomensales(String comensales) {
        this.comensales = comensales;
    }
    public String getmesas() {
        return mesas;
    }
    public void setmesas(String mesas) {
        this.mesas = mesas;
    }
    public LocalDate getfecha() {
        return fecha;
    }
    public void setfecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getPlanComida() {
        return planComida;
    }
    public void setPlanComida(String planComida) {
        this.planComida = planComida;
    }
    
}
