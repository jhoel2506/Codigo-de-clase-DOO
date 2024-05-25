package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;
import co.edu.uco.tiendachepito.entity.PaisEntity;

import java.util.ArrayList;
import java.util.List;

public final class DepartamentoEntityDomainAssembler implements EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> {

    private static final EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> instancia = new DepartamentoEntityDomainAssembler();
    private static final EntityDomainAssembler<PaisDomain, PaisEntity> paisAssembler = PaisEntityDomainAssembler.obtenerInstancia();

    private DepartamentoEntityDomainAssembler(){
        super();
    }

    public static final EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> obtenerInstancia(){
        return instancia;
    }

    @Override
    public DepartamentoDomain ensamblarDominio(DepartamentoEntity entity) {
        var departamentoEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, DepartamentoEntity.build());
        var paisDomain = paisAssembler.ensamblarDominio(departamentoEntityTemp.getPais());
        return DepartamentoDomain.crear(departamentoEntityTemp.getId(), departamentoEntityTemp.getNombre(), paisDomain);
    }

    @Override
    public DepartamentoEntity ensamblarEntidad(DepartamentoDomain dominio) {
        var departamentoDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, DepartamentoDomain.crear());
        var paisEntity = paisAssembler.ensamblarEntidad(departamentoDomainTemp.getPais());
        return DepartamentoEntity.build().setId(departamentoDomainTemp.getId()).setNombre(departamentoDomainTemp.getNombre()).setPais(paisEntity);
    }

    @Override
    public List<DepartamentoDomain> ensamblarListaDominios(List<DepartamentoEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<>());
        var resultados = new ArrayList<DepartamentoDomain>();

        for (var departamentoEntity : listaEntidadesTmp) {
            var departamentoDomainTmp = ensamblarDominio((DepartamentoEntity) departamentoEntity);
            resultados.add(departamentoDomainTmp);
        }
        return resultados;
    }
}
