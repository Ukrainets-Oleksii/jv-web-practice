package mate.controller.car;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Car;
import mate.model.Manufacturer;
import mate.service.CarService;
import mate.service.ManufacturerService;

public class CreateCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private final CarService carService
            = (CarService) injector.getInstance(CarService.class);
    private final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/car/create.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String carModel = req.getParameter("Car model");
        Long manufacturerId = Long.parseLong(req.getParameter("Manufacturer id"));
        Car car = getCar(carModel, manufacturerId);
        carService.create(car);
        req.getRequestDispatcher("/WEB-INF/views/Complete.jsp")
                .forward(req,resp);
    }

    private Car getCar(String carModel, Long manufacturerId) {
        Car car = new Car();
        Manufacturer manufacturer = manufacturerService.get(manufacturerId);
        car.setModel(carModel);
        car.setManufacturer(manufacturer);
        car.setDrivers(new ArrayList<>());
        return car;
    }
}
