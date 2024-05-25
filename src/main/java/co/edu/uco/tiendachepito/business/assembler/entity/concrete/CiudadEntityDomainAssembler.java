package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.CiudadEntity;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;

import java.util.ArrayList;
import java.util.List;

public final class CiudadEntityDomainAssembler implements EntityDomainAssembler<CiudadDomain, CiudadEntity> {

    private static final EntityDomainAssembler<CiudadDomain, CiudadEntity> instancia = new CiudadEntityDomainAssembler();
    private static final EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> departamentoAssembler = DepartamentoEntityDomainAssembler.obtenerInstancia();

    private CiudadEntityDomainAssembler(){
        super();
    }

    public static final EntityDomainAssembler<CiudadDomain, CiudadEntity> obtenerInstancia(){
        return instancia;
    }

    @Override
    public CiudadDomain ensamblarDominio(CiudadEntity entity) {
        var ciudadEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, CiudadEntity.build());
        var departamentoDomain = departamentoAssembler.ensamblarDominio(ciudadEntityTemp.getDepartamento());
        return CiudadDomain.crear(ciudadEntityTemp.getId(), ciudadEntityTemp.getNombre(), departamentoDomain);
    }

    @Override
    public CiudadEntity ensamblarEntidad(CiudadDomain dominio) {
        var ciudadDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, CiudadDomain.crear());
        var departamentoEntity = departamentoAssembler.ensamblarEntidad(ciudadDomainTemp.getDepartamento());
        return CiudadEntity.build().setId(ciudadDomainTemp.getId()).setNombre(ciudadDomainTemp.getNombre()).setDepartamento(departamentoEntity);
    }

    @Override
    public List<CiudadDomain> ensamblarListaDominios(List<CiudadEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<>());
        var resultados = new ArrayList<CiudadDomain>();

        for (var ciudadEntity : listaEntidadesTmp) {
            var ciudadDomainTmp = ensamblarDominio((CiudadEntity) ciudadEntity);
            resultados.add(ciudadDomainTmp);
        }
        return resultados;
    }
}
