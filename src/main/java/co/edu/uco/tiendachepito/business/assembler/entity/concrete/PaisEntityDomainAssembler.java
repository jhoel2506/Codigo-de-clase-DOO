package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.PaisEntity;

import java.util.ArrayList;
import java.util.List;

public final class PaisEntityDomainAssembler implements EntityDomainAssembler <PaisDomain, PaisEntity> {

private  static final EntityDomainAssembler <PaisDomain, PaisEntity> instancia = new PaisEntityDomainAssembler();

    public static final EntityDomainAssembler <PaisDomain, PaisEntity> obtenerInstancia(){
        return instancia;
    }

    @Override
    public final PaisDomain ensamblarDominio(final PaisEntity entity) {
        var paisEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, PaisEntity.build(0));
        return PaisDomain.crear(paisEntityTemp.getId(), paisEntityTemp.getNombre());
    }

    @Override
    public final PaisEntity ensamblarEntidad(final PaisDomain dominio) {
        var paisDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio,PaisDomain.crear());
        return PaisEntity.build(paisDomainTemp.getId(), paisDomainTemp.getNombre());
    }

    @Override
    public List<PaisDomain> ensamblarListaDominios(List<PaisEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaEntidades, new ArrayList<PaisEntity>());
        var resultados = new ArrayList<PaisDomain>();

        for (PaisEntity paisEntity : listaEntidadesTmp){
            var paisDomainTmp = ensamblarDominio(paisEntity);
            resultados.add(paisDomainTmp);
        }
        return resultados;
    }


}
