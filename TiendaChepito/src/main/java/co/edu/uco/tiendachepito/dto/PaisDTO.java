package co.edu.uco.tiendachepito.dto;

import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

import javax.swing.plaf.PanelUI;

public class PaisDTO {
    private int id;
    private String nombre;

    public PaisDTO() {
        setNombre(TextHelper.EMPTY);
    }

    private void setNombre(String empty) {
    }

    public PaisDTO(final int id, final String nombre) {

        setNombre(nombre);
    }
    public static final PaisDTO build(){
        return new PaisDTO();
    }
    public final int getId() {
        return id;
    }



}
