package co.edu.uco.tiendachepito.entity;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;

public final class ciudadEntity {

    private int id;
    private String nombre;
    private departamentoEntity departamento;

    private ciudadEntity(final int id, final String nombre, final departamentoEntity departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    private ciudadEntity(final int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
        setDepartamento(departamentoEntity.build());
    }

    public static final ciudadEntity build (final int id){
        return new ciudadEntity(id);
    }

    public static final ciudadEntity build(final int id, final String nombre, final departamentoEntity departamento){
        return new ciudadEntity(id);
    }

    protected static final ciudadEntity build(){
        return new ciudadEntity(NumericHelper.ZERO);
    }

    public final int getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final departamentoEntity getDepartamento() {
        return departamento;
    }

    private final void setId(final int id) {
        this.id = id;
    }

    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private final departamentoEntity setDepartamento(final departamentoEntity departamento) {
        this.departamento = ObjectHelper.getObjectHelper().getDefault(departamento, departamentoEntity.build(NumericHelper.ZERO));
        return departamento;
    }
}
