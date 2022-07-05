package com.webapp.app2022;

import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/reservaFinal")
public class ReservaFinal extends VerticalLayout{
    private Button precio = new Button("Acceptar:");
    private H1 texto = new H1("El precio total de su reserva es:");
    ArrayList<String> total1 = new ArrayList<String>();
    

    public ReservaFinal(){
        //labelsedit
        
        precio.setHeight("200px");
        precio.setWidth("300px");
        
        
        
        //Person a = repository.get
        //a.getnombre();
        precio.addClickListener(clickEvent ->{
            Notification.show("Su reserva se realizo con exito");
            
            
            precio.getUI().ifPresent( ui -> ui.navigate(""));
        });
        add(texto,precio);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}