package co.edu.uco.tiendachepito.dto;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public final class CiudadDTO {

    private int id;
    private String nombre;
    private DepartamentoDTO departamento;

    public CiudadDTO(final int id,final String nombre,final DepartamentoDTO departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    public CiudadDTO() {
        setNombre(TextHelper.EMPTY);
        setDepartamento(DepartamentoDTO.build());
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public final DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public final void setDepartamento(final DepartamentoDTO departamento) {
        this.departamento = ObjectHelper.getObjectHelper().getDefault(departamento, DepartamentoDTO.build());
    }

}
