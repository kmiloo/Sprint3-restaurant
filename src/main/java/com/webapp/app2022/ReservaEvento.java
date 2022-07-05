package com.webapp.app2022;

import com.vaadin.flow.component.Component;
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




@Route("/reservaEvento")
public class ReservaEvento extends VerticalLayout{

    
    private TextField nombre = new TextField("Nombre");
    private TextField rut = new TextField("Rut");
    private DatePicker fecha = new DatePicker("Seleccione fecha que desea");
    private ComboBox<String> modalidad = new ComboBox<>("Seleccione la modalidad de su evento");
    private ComboBox<String> servicioEspecial = new ComboBox<>("Servicio especial (opcional)");

    
    Button confirmar = new Button("Confirmar");
    FormLayout formLayout = new FormLayout();
    HorizontalLayout ho = new HorizontalLayout();


    Binder<Person> binder = new Binder<>(Person.class);
    private Person person;
    private PersonRepository repository;  
    
    
    
    public ReservaEvento(PersonRepository repository){
        
        
        this.repository = repository;
        //Labels
        modalidad.setAllowCustomValue(true);
        modalidad.setItems("Abierta", "Semi-Cerrrada", "Cerrada");

        servicioEspecial.setAllowCustomValue(true);
        servicioEspecial.setItems("Si", "No");

        rut.setHelperText("Ingrese su rut sin puntos ni guion.");
        
        formLayout.add(
            nombre,
            rut,
            modalidad,
            servicioEspecial,
            fecha
        );
        
        ho.add(formLayout,Boton());
        
        binder.bindInstanceFields(this);



        formLayout.setColspan(nombre, 2);
        formLayout.setColspan(rut, 2);
        formLayout.setColspan(fecha, 2);
        ho.setDefaultVerticalComponentAlignment(Alignment.END);
        
        formLayout.setWidth("800px");
        //setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        add(ho);
        

        
    }
    private Component Boton(){
        confirmar.setHeight("270px");
        confirmar.setWidth("250px");
        confirmar.addClickListener(clickEvent ->{
            var persona = new Person(nombre.getValue(),rut.getValue(),fecha.getValue(),modalidad.getValue(),servicioEspecial.getValue());
            setPerson(persona);
            save();
            confirmar.getUI().ifPresent( ui -> ui.navigate("reservaFinal"));
            
        });
        return confirmar;
    }

    public void setPerson(Person person){
        this.person = person;
        binder.readBean(person);
    }
    private void save(){
        try {
            repository.save(person);
            binder.writeBean(person);
            
        } catch (ValidationException e) {
        }
    }
}