package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public final class DepartamentoEntity {
    private int id;
    private String nombre;
    private PaisEntity pais;

    public DepartamentoEntity(final int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
        setPais(PaisEntity.build());
    }

    public DepartamentoEntity(int id, String nombre, PaisEntity pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    public static final DepartamentoEntity build(final int id) {
        return new DepartamentoEntity(id);
    }

    public static final DepartamentoEntity build(final int id,final String nombre,final PaisEntity pais) {
        return new DepartamentoEntity(id,nombre,pais);
    }
    protected static final DepartamentoEntity build(){
        return new DepartamentoEntity(NumericHelper.ZERO);
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setPais(final PaisEntity pais) {
        this.pais = ObjectHelper.getObjectHelper().getDefault(pais,PaisEntity.build());
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public PaisEntity getPais() {
        return pais;
    }
}
