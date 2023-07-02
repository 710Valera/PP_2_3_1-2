package web.DAO;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private static List<Car> carsList;

    static {
        carsList = new ArrayList<>();
        carsList.add(new Car("Black", "Volga", 30));
        carsList.add(new Car("White", "BMV", 11));
        carsList.add(new Car("Black", "Volvo", 1));
        carsList.add(new Car("Red", "Mazda", 2));
        carsList.add(new Car("Red", "Lada", 8));
    }

    public static List<Car> getSomeCars(int count){
        return count>carsList.size() ? carsList : carsList.subList(0, count);
    }

}
