package co.edu.uco.tiendachepito.dto;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;
public final class DepartamentoDTO {
    private int id;
    private String nombre;
    private PaisDTO pais;

    public DepartamentoDTO(){
        setNombre((TextHelper.EMPTY));
        setPais(PaisDTO.build());
    }
    public DepartamentoDTO(final int id, final String nombre, final PaisDTO pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }
    public final void setId(int id) {
        this.id = id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }
    public final PaisDTO getPais() {
        return pais;
    }
    public final void setPais(final PaisDTO pais) {
        this.pais = pais;
    }
}
