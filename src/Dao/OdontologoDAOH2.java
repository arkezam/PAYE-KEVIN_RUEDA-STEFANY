package Dao;

import Model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{
    private static final Logger logger= Logger.getLogger(DomicilioDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (NUMERO_MATRICULA, NOMBRE, APELLIDO) " +
            "VALUES(?,?,?)";
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("iniciando las operaciones de guardado de un paciente");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute();

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return odontologo;
    }


    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection= null;
        Statement statement = null;
        List<Odontologo> odontologoDesdeDB = new ArrayList<>();
        try {
            connection= BD.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()){
                Integer matricula = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                odontologoDesdeDB.add(new Odontologo(matricula,nombre,apellido));
            }
            logger.info("Odontologo "+ odontologoDesdeDB);

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return odontologoDesdeDB;
        // update
    }
}
