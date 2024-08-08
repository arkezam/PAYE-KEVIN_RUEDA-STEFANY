package Service;

import Dao.OdontologoDAOH2;
import Dao.iDao;
import Model.Odontologo;

import java.util.List;

public class OdontologoServiceH2 {
    private iDao<Odontologo> daoOdontologo;

    public OdontologoServiceH2() {
        daoOdontologo= new OdontologoDAOH2();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return  daoOdontologo.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return daoOdontologo.buscarTodos();
    }

}
