package co.edu.uco.tiendachepito.business.assembler.dto;

import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.dto.PaisDTO;

import java.util.List;

public interface DTODomainAssembler <D, T> {

    D ensamblarDominio(T dto);

    T ensamblarDTO(D dominio);

    List<T> ensamblarListaDTO(List<D> listaDominios);

    List<PaisDomain> ensamblarListaDominios(List<PaisDTO> listaDtos);
}
