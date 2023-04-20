import daos.CarDAO;

public class App {

    public static void main(String[] args) {
        CarDAO cardao = new CarDAO();
        System.out.println(cardao.findById(1));
    }

}
