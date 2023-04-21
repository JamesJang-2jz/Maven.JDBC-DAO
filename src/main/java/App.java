import java.util.List;

import daos.CarDAO;
import models.CarDTO;

public class App {

    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO(); // DAO is data access object, is to CRUD changes to table
        // System.out.println(carDAO.findById(1));
        carDAO.delete(3);
        // carDAO.create(new CarDTO(3, "Toyota", "MR2", "White", 1992,
        // "8asfdn32on98usdf"));
        List<CarDTO> list = carDAO.findAll();
        System.out.println(list);
        // carDAO.update(new CarDTO(1, "Subaru", "Baja", "Blue", 2005,
        // "23098vdfj39hce9s7h7w"));
        // System.out.println(carDAO.findById(1));

    }

}
