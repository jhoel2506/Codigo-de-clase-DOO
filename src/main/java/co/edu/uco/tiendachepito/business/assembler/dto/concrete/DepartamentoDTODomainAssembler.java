package co.edu.uco.tiendachepito.business.assembler.dto.concrete; // Change package to dto

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;
import co.edu.uco.tiendachepito.dto.PaisDTO;

import java.util.ArrayList;
import java.util.List;

public final class DepartamentoDTODomainAssembler implements DTODomainAssembler<DepartamentoDomain, DepartamentoDTO> {

    private static final DTODomainAssembler<DepartamentoDomain, DepartamentoDTO> instancia = new DepartamentoDTODomainAssembler();
    private static final DTODomainAssembler<PaisDomain, PaisDTO> paisAssembler = PaisDTODomainAssembler.obtenerInstancia();

    DepartamentoDTODomainAssembler() {
        super();
    }

    public static final DTODomainAssembler<DepartamentoDomain, DepartamentoDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public DepartamentoDomain ensamblarDominio(DepartamentoDTO dto) {
        return null;
    }

    @Override
    public DepartamentoDTO ensamblarDTO(DepartamentoDomain dominio) {
        var departamentoDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, DepartamentoDomain.crear());
        var paisDTO = paisAssembler.ensamblarDTO(departamentoDomainTemp.getPais());
        return DepartamentoDTO.build().setId(departamentoDomainTemp.getId()).setNombre(departamentoDomainTemp.getNombre()).setPais(paisDTO);
    }

    @Override
    public List<DepartamentoDTO> ensamblarListaDTO(List<DepartamentoDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<>());
        var resultados = new ArrayList<DepartamentoDTO>();

        for (var departamentoDomain : listaDominiosTmp) {
            var departamentoDTOTmp = ensamblarDTO((DepartamentoDomain) departamentoDomain);
            resultados.add(departamentoDTOTmp);
        }
        return resultados;
    }

    @Override
    public List<PaisDomain> ensamblarListaDominios(List<PaisDTO> listaDtos) {
        return null;
    }
}
