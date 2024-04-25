package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public final class PaisEntity {
    private int id;
    private String nombre;

    private PaisEntity(final int id) {
        setNombre(TextHelper.EMPTY);
    }

    private PaisEntity(final int id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public void setId(final int id) {
        this.id = id;
    }

    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public static final PaisEntity build(final int id) {
        return new PaisEntity(id);
    }

    public static final PaisEntity build(final int id, final String nombre, final PaisEntity pais) {
        return new PaisEntity(id, nombre);
    }

    protected static final PaisEntity build() {
        return new PaisEntity(NumericHelper.ZERO);
    }
}
