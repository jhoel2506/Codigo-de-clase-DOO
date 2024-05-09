package co.edu.uco.tiendachepito.data.dao.factory;

import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.data.dao.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.data.dao.factory.enums.Factory;
import co.edu.uco.tiendachepito.data.dao.factory.sql.azuresql.AzureSqlDAOFactory;

public abstract class DAOFactory {

	public static  final DAOFactory getFactory(final Factory factory){
		switch (factory){
            case MYSQL -> {
				var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
				var mensajeTecnico = "No existe configudara una factoria de datos para una base de datos MTSQL";
			}
			default -> {
				return new AzureSqlDAOFactory();
			}
		}
		return null;
	}
	protected abstract void obtenerConexion();

	public abstract void iniciarTransaccion();

	public abstract void confirmarTransaccion();

	public abstract void cancelarTransaccion();

	public abstract void cerrarConexion();

	public abstract PaisDAO getPaisDAO();

	public abstract DepartamentoDAO getDepartamentoDAO();

	public abstract CiudadDAO getCiudadDAO();

}
