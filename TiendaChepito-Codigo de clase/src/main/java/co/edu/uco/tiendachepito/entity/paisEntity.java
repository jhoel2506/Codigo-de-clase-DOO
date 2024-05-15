package co.edu.uco.tiendachepito.entity;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public final class paisEntity {

    private int id;
    private String nombre;

    public paisEntity(final int id, final String nombre) {
        setId(id);
        setNombre(TextHelper.EMPTY);
    }

    private paisEntity(final int id) {
        setNombre(TextHelper.EMPTY);
    }

    public static final paisEntity build(final int id){
        return new paisEntity(id);
    }

    public static final paisEntity build(final int id, final String nombre){
        return new paisEntity(id,nombre);
    }

    protected static final paisEntity build(){
        return new paisEntity(NumericHelper.ZERO);
    }

    public final int getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    private final void setId(final int id) {
        this.id = id;
    }

    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }
}
