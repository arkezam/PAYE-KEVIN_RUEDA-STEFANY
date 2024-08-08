package Dao;

import Model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OdontologoDAO implements iDao <Odontologo> {

    private static final Logger logger= Logger.getLogger(Odontologo.class);
    Map<Integer, Odontologo> odontologos = new HashMap<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        try {
            odontologos.put(odontologo.getNumeroMatricula(), odontologo);

            logger.info("El odontologo "+odontologo.getNombre()+" "+odontologo.getApellido()+" y numero de matricula "+odontologo.getNumeroMatricula()+" se ha guardado correctamente");

        }catch (Exception e){
            logger.error("El odontologo no se puede guardar en la base de datos: "+ e.getMessage());
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

        List<Odontologo> odontologosLista= new ArrayList<>(odontologos.values());
        try {

            for (Odontologo odontologo : odontologosLista) {
                System.out.println(odontologo.getNombre()+" "+odontologo.getApellido()+" "+odontologo.getNumeroMatricula());
            }

        }catch(Exception e){
            logger.error("La busqueda fallo "+e.getMessage());
        }
        return  odontologosLista;
    }
}
