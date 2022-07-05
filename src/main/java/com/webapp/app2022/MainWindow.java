package com.webapp.app2022;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainWindow extends VerticalLayout{
    public MainWindow(){

        H1 textoBienvenida = new H1("Restaurante Complejo turistico reloncavi");

        //botones
        Button arrowRightButton = new Button("Next", new Icon(VaadinIcon.ARROW_RIGHT));
        arrowRightButton.setIconAfterText(true);
        arrowRightButton.addClickListener(clickEvent ->{
            arrowRightButton.getUI().ifPresent(ui -> ui.navigate("reserva"));
        });

        //lugar
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(arrowRightButton);
        layout.setAlignItems(Alignment.END);

        //imagen
        HorizontalLayout layout2 = new HorizontalLayout();
        Image img = new Image("https://queestudiarenchile.com/wp-content/uploads/2018/09/universidad-de-los-lagos-1280x720.png", "imagen ulagos");
        img.setWidth("400px");
        layout2.add(img);
        
        
        //anadir
        add(layout2,textoBienvenida, layout);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        
    }    
}
