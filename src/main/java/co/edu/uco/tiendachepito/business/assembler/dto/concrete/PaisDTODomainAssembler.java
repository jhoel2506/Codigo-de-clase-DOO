package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.PaisDTO;

import java.util.ArrayList;
import java.util.List;

public final class PaisDTODomainAssembler implements DTODomainAssembler<PaisDomain, PaisDTO> {

    private static final DTODomainAssembler<PaisDomain, PaisDTO> instancia = new PaisDTODomainAssembler();

    public static final DTODomainAssembler<PaisDomain, PaisDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final PaisDomain ensamblarDominio(final PaisDTO dto) {
        var paisDtoTemp = ObjectHelper.getObjectHelper().getDefault(dto, PaisDTO.build());
        return PaisDomain.crear(paisDtoTemp.getId(), paisDtoTemp.getNombre());
    }

    @Override
    public final PaisDTO ensamblarDTO(final PaisDomain dominio) {
        var paisDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, PaisDomain.crear());
        return new PaisDTO(paisDomainTemp.getId(), paisDomainTemp.getNombre());
    }

    @Override
    public List<PaisDTO> ensamblarListaDTO(List<PaisDomain> listaDominios) {
        return null;
    }

    @Override
    public List<PaisDomain> ensamblarListaDominios(List<PaisDTO> listaDtos) {
        var listaDtosTmp = ObjectHelper.getObjectHelper().getDefault(listaDtos, new ArrayList<PaisDTO>());
        var resultados = new ArrayList<PaisDomain>();

        for (PaisDTO paisDto : listaDtosTmp) {
            var paisDomainTmp = ensamblarDominio(paisDto);
            resultados.add(paisDomainTmp);
        }
        return resultados;
    }
}
