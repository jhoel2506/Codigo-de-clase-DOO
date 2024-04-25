package co.edu.uco.tiendachepito.data.dao.factory.sql.azuresql;

import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.data.dao.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.dao.sql.azuresql.CiudadsqlDAO;
import co.edu.uco.tiendachepito.data.dao.sql.azuresql.DepartamentoAzuresqlDAO;
import co.edu.uco.tiendachepito.data.dao.sql.azuresql.PaisAzuresqlDAO;

import java.sql.Connection;


public final class AzureSqlDAOFactory extends DAOFactory {

    private final Connection connection;

    public AzureSqlDAOFactory(Connection connection) {
        this.connection = connection;
    }
    

    public AzureSqlDAOFactory() {
        obtenerConexion();
    }
    
    protected void obtenerConexion(){
        connection = null;
    }

    @Override
    public void obtenerConexion() {
        connection = null;
    }

    @Override
    public void iniciarTransaccion() {

    }

    @Override
    public void confirmarTransaccion() {

    }

    @Override
    public void cancelarTransaccion() {

    }

    @Override
    public void cerrarConexion() {

    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisAzuresqlDAO(connection);
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoAzuresqlDAO(connection);
    }

    @Override
    public CiudadDAO getCiudadDAO() {
        return new CiudadsqlDAO(connection);
    }
}
