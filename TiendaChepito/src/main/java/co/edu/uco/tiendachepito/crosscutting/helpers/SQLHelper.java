package co.edu.uco.tiendachepito.crosscutting.helpers;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.CrosscuttingTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;

import java.sql.Connection;
import java.sql.SQLException;

import static java.util.Objects.isNull;

public final class SQLHelper {

    private SQLHelper(){
        super();
    }

    public static final boolean IsNull(final Connection connection){
        return ObjectHelper.getObjectHelper().isNull(connection);
    }

    public static final boolean isOpen(final Connection connection){
        try {
            return !isNull(connection) && !connection.isClosed();
        } catch(SQLException exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00007);

            throw new CrosscuttingTiendaChepitoException(mensajeTecnico,mensajeUsuario,exception);
        }catch(final Exception exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00008);

            throw new CrosscuttingTiendaChepitoException(mensajeTecnico,mensajeUsuario,exception);
        }
    }

    public static final void Close(final Connection connection){
        try {
            if(!isOpen(connection)){
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00009);

                throw new CrosscuttingTiendaChepitoException((mensajeTecnico,mensajeUsuario);
            }
            connection.close();
        } catch(final CrosscuttingTiendaChepitoException exception){
            throw  exception;
        } catch(SQLException exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00010);

            throw new CrosscuttingTiendaChepitoException(mensajeTecnico,mensajeUsuario,exception);
        }catch(final Exception exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00008);

            throw new CrosscuttingTiendaChepitoException(mensajeTecnico,mensajeUsuario,exception);
        }
    }

    public static final void commit(final Connection connection){

    }

    public static final void rollback(final Connection connection){

    }

    public static final void initTransaction(final Connection connection){

    }
}
