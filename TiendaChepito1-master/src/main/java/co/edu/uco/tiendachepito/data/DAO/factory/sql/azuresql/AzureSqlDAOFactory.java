package co.edu.uco.tiendachepito.data.DAO.factory.sql.azuresql;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.SQLHelper;
import co.edu.uco.tiendachepito.data.DAO.CiudadDAO;
import co.edu.uco.tiendachepito.data.DAO.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.DAO.PaisDAO;
import co.edu.uco.tiendachepito.data.DAO.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.DAO.sql.azuresql.CiudadAzureSqlDAO;
import co.edu.uco.tiendachepito.data.DAO.sql.azuresql.DepartamentoAzureSqlDAO;
import co.edu.uco.tiendachepito.data.DAO.sql.azuresql.PaisAzureSqlDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class AzureSqlDAOFactory extends DAOFactory {

    private Connection connection;

    public AzureSqlDAOFactory (){
        obtenerConexion();
    }

    @Override
    protected void obtenerConexion() {
        final String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=<database>;user=<username>;password=<password>";
        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void iniciarTransaccion() {
        SQLHelper.initTransaction(connection);
    }

    @Override
    public void confirmarTransaccion() {
        SQLHelper.commit(connection);
    }

    @Override
    public void cancelarTransaccion() {
        SQLHelper.rollback(connection);
    }

    @Override
    public void cerrarConexion() {
        SQLHelper.close(connection);
    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisAzureSqlDAO(connection);
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoAzureSqlDAO(connection);
    }

    @Override
    public CiudadDAO getCiudadDAO() {
        return new CiudadAzureSqlDAO(connection);
    }
}
