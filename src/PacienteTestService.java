import Dao.BD;
import Model.Odontologo;
import Model.Paciente;
import Service.OdontologoService;
import Service.OdontologoServiceH2;
import Service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PacienteTestService {
    @Test
    public void buscarPaciente(){
        BD.crearTablas();
        PacienteService pacienteService= new PacienteService();
        Integer idABuscar= 1;
        Paciente paciente= pacienteService.buscarPorId(idABuscar);
        Assertions.assertTrue(paciente!=null);
    }

    @Test
    public void insertarOdontologo(){
        BD.crearTablas();
        OdontologoServiceH2 odontologoService = new OdontologoServiceH2();
        Odontologo o1 = odontologoService.guardarOdontologo(new Odontologo(3211,"Alberto","salas"));
        Odontologo o2 = odontologoService.guardarOdontologo(new Odontologo(32111,"Maria","Gonzales"));

        Assertions.assertTrue(o1!=null);
        List<Odontologo> odontologos = odontologoService.listarOdontologos();
        Assertions.assertTrue(odontologos.size()>0);
    }

    @Test
    public void odontologosSinBD() {
        OdontologoService os = new OdontologoService();
        Odontologo odontologo1= os.guardarOdontologoEnLista(new Odontologo(123,"Juan","Perez"));
        Assertions.assertTrue(odontologo1!=null);
        Odontologo odontologo2= os.guardarOdontologoEnLista(new Odontologo(456,"Juana","Pelaez"));
        Assertions.assertTrue(odontologo2!=null);
        List<Odontologo> odontologos= os.mostrarListadoOdontologos();
        Assertions.assertTrue(odontologos.size()>0);
    }

}
