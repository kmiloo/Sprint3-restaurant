package com.webapp.app2022;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/reserva")
public class Reserva extends VerticalLayout{

    public Reserva(){
        //texto
        H1 textoBienvenida = new H1("Seleccione el tipo de reserva que desea");
        

        //botones
        Button Normal = new Button("Normal", new Icon(VaadinIcon.ARROW_RIGHT));
        Normal.setIconAfterText(true);
        Normal.setHeight("150px");
        Normal.setWidth("250px");

        Normal.addClickListener(clickEvent ->{
            Normal.getUI().ifPresent( ui -> ui.navigate("reservaNormal"));
        });

        Button Evento = new Button("Evento", new Icon(VaadinIcon.ARROW_RIGHT));
        Evento.setIconAfterText(true);
        Evento.setHeight("150px");
        Evento.setWidth("250px");

        Evento.addClickListener(clickEvent ->{
            Evento.getUI().ifPresent( ui -> ui.navigate("reservaEvento"));
        });

        //layout
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(Normal, Evento);
    
        add(textoBienvenida,layout);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

    }
    
}
