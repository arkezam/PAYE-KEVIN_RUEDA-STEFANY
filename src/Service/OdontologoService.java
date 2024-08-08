package Service;

import Dao.OdontologoDAO;
import Dao.iDao;
import Model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> daoOdontologo;

    public OdontologoService() {

        daoOdontologo= new OdontologoDAO();

    }

    public Odontologo guardarOdontologoEnLista(Odontologo odontologo){
        return  daoOdontologo.guardar(odontologo);
    }

    public List<Odontologo> mostrarListadoOdontologos(){
        return daoOdontologo.buscarTodos();
    }

}
