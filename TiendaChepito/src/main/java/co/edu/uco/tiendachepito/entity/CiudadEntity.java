package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper;

public final class CiudadEntity {
    private int id;
    private String nombre;
    private DepartamentoEntity departamento;

    private CiudadEntity(final int id){
        setId(id);
    }
    private CiudadEntity(final int id,final String nombre,final DepartamentoEntity departamento){
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }
    protected static final CiudadEntity build(){
        return new CiudadEntity(NumericHelper.ZERO);
    }

    public DepartamentoEntity setDepartamento() {
        return departamento;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public final int getId() {
        return id;
    }
    public static final CiudadEntity build(final int id){
        return new CiudadEntity(id);
    }
    public static final CiudadEntity build(final int id,final String nombre,final DepartamentoEntity departamento){
        return new CiudadEntity(id,nombre,departamento);
    }
}
