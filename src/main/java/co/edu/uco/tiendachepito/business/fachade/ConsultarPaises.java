package co.edu.uco.tiendachepito.business.fachade;

import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.dto.PaisDTO;

import java.util.List;

public interface ConsultarPaises {

    List<PaisDomain> execute(PaisDomain pais);

    List<PaisDomain> ejecutar(PaisDomain pais);
}
