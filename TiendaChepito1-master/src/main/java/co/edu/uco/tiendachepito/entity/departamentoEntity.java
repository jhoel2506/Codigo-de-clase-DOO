package co.edu.uco.tiendachepito.entity;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public final class departamentoEntity {

    private int id;
    private String nombre;
    private paisEntity pais;

    private departamentoEntity (final int id){
        setId(id);
        setNombre(TextHelper.EMPTY);
        setPais(paisEntity.build());
    }

    public departamentoEntity(final int id, final String nombre, final paisEntity pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    public static final departamentoEntity build(final int id){
        return new departamentoEntity(id);
    }

    public static final departamentoEntity build(final int id, final String nombre, final departamentoEntity departamentoEntity){
        return new departamentoEntity(id);
    }

    protected static final departamentoEntity build(){
        return new departamentoEntity(NumericHelper.ZERO);
    }

    public final int getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final paisEntity getPais() {
        return pais;
    }

    private final void setId(final int id) {
        this.id = id;
    }

    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private final paisEntity setPais(final paisEntity pais) {
        this.pais = ObjectHelper.getObjectHelper().getDefault(pais, paisEntity.build(NumericHelper.ZERO));
        return pais;
    }
}
