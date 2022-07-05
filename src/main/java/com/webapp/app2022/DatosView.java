package com.webapp.app2022;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/Datos")
public class DatosView extends VerticalLayout{
    
    private PersonRepository repository;    
    private PersonRepository2 repository2; 
    private Grid<Person> grid = new Grid<>(Person.class);
    private Grid<Person2> grid2 = new Grid<>(Person2.class);
    


    public DatosView(PersonRepository repository,PersonRepository2 repository2){
    
        this.repository = repository;
        grid.setColumns("nombre", "rut","fecha","modalidad","servicioEspecial");
        add(grid);
        refreshGrid();

        this.repository2 = repository2;
        grid2.setColumns("nombre","rut","fecha","planComida","planDegustacion","comensales","mesas");
        add(grid2);
        refreshGrid2();

    }

    
    private void refreshGrid() {
        grid.setItems(repository.findAll());
        
    }
    private void refreshGrid2() {
        grid2.setItems(repository2.findAll());
    }

}