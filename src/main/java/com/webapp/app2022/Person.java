package com.webapp.app2022;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Person {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String nombre;
    private String rut;
    private LocalDate fecha;
    private String modalidad;
    private String servicioEspecial;
    //private String plancomida;
    //private String planDegustacion;
    // private String comensales;
    // private String mesas;
    

    Person(String nombre, String rut, LocalDate fecha,String modalidad,String servicioEspecial){
        this.nombre = nombre;
        this.rut = rut;
        this.fecha = fecha;
        this.modalidad = modalidad;
        this.servicioEspecial = servicioEspecial;
        

    }
    public Person(){
        
    }

    // String getPlanDegustacion() {
    //     return planDegustacion;
    // }
    // void setPlanDegustacion(String planDegustacion) {
    //     this.planDegustacion = planDegustacion;
    // }
    // String getPlancomida() {
    //     return plancomida;
    // }
    //  void setPlancomida(String plancomida) {
    //     this.plancomida = plancomida;
    // }

    public String getModalidad() {
        return modalidad;
    }
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
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
    //  String getcomensales() {
    //     return comensales;
    // }
    //  void setcomensales(String comensales) {
    //     this.comensales = comensales;
    // }
    //  String getmesas() {
    //     return mesas;
    // }
    //  void setmesas(String mesas) {
    //     this.mesas = mesas;
    // }
    public LocalDate getfecha() {
        return fecha;
    }
    public void setfecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getServicioEspecial() {
        return servicioEspecial;
    }
    public void setServicioEspecial(String servicioEspecial) {
        this.servicioEspecial = servicioEspecial;
    }
    
     

}
