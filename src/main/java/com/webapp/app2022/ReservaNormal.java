package com.webapp.app2022;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

@Route("/reservaNormal")
public class ReservaNormal extends VerticalLayout{

    private TextField nombre = new TextField();
    private TextField rut = new TextField();
    private TextField comensales = new TextField();
    private ComboBox<String> mesas = new ComboBox<>("Indique cuantas mesas utilizara");
    private DatePicker fecha = new DatePicker("Seleccione fecha que desea");
    private ComboBox<String> planComida = new ComboBox<>("Seleccione su plan de comida");
    private ComboBox<String> planDegustacion = new ComboBox<>("Seleccione su plan de desgustacion");

    private Button confirmar = new Button("Confirmar");
    private FormLayout formLayout = new FormLayout();
    private HorizontalLayout ho = new HorizontalLayout();
    // private TextField total = new TextField("Total:");
    

    Binder<Person2> binder = new Binder<>(Person2.class);
    private Person2 person2;
    private PersonRepository2 repository2;
    

    public ReservaNormal(PersonRepository2 repository2){

        this.repository2 = repository2;
        //labels
        //total.setReadOnly(true);
        nombre.setLabel("Ingrese su nombre");
        rut.setLabel("Ingrese su rut");
        comensales.setLabel("Ingrese cuantos comensales seran");
        mesas.setAllowCustomValue(true);
        mesas.setItems("1", "2", "3", "4");
        planComida.setAllowCustomValue(true);
        planComida.setItems("Inicial", "Intermedio", "Avanzado");
        planDegustacion.setAllowCustomValue(true);
        planDegustacion.setItems("Locales", "Internacional", "Cocina Fusion");

        //boton
       
        confirmar.setHeight("250px");
        confirmar.setWidth("300px");
        confirmar.addClickListener(clickEvent ->{
            confirmar.getUI().ifPresent( ui -> ui.navigate("reservaFinal"));
            var person2 = new Person2(nombre.getValue(), rut.getValue(), fecha.getValue(), planComida.getValue(), planDegustacion.getValue(), comensales.getValue(), mesas.getValue());
            setPerson(person2);
            save();
        });
        //total

        // planComida.addValueChangeListener(e ->{
        //         if(planComida.getValue()=="Inicial"){
        //             total.setValue("20.000");
        //         }
        //         if(planComida.getValue()=="Intermedio"){
        //             total.setValue("45.000");
        //         }
        //         if(planComida.getValue()=="Avanzado"){
        //             total.setValue("60.000");
        //         }
        //     }
        // );
        
        
        formLayout.add(
            nombre, 
            rut,
            planComida,
            planDegustacion,
            comensales,
            mesas,
            fecha
        );
        formLayout.setColspan(nombre, 2);
        formLayout.setColspan(rut, 2);
        formLayout.setColspan(fecha, 2);
        formLayout.setWidth("1200px");
        ho.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        ho.add(formLayout,confirmar);
        
        binder.bindInstanceFields(this);

        add(ho);
        //setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    public void setPerson(Person2 person2){
        this.person2 = person2;
        binder.readBean(person2);
    }
    private void save(){
        try {
            repository2.save(person2);
            binder.writeBean(person2);
        } catch (ValidationException e) {
        }
    }
    // public String suma(int a,int b,int c,int d){
    //     int suma1=a+b;
    //     int mult= suma1*c;
    //     int mesas = d*10000;
    //     int total = mult+mesas;
    //     String To= Integer.toString(total);

    //     return To;

    // }
}