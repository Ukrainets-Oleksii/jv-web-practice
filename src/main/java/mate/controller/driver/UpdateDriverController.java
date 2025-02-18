package mate.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Driver;
import mate.service.DriverService;

public class UpdateDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/driver/update.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long driverId = Long.valueOf(req.getParameter("Id"));
        String driverName = req.getParameter("Driver name");
        String licenseNumber = req.getParameter("License Number");
        Driver driver = getDriver(driverId, driverName, licenseNumber);
        driverService.update(driver);
        req.getRequestDispatcher("/WEB-INF/views/Complete.jsp")
                .forward(req,resp);
    }

    private Driver getDriver(Long driverId, String driverName, String licenseNumber) {
        Driver driver = new Driver();
        driver.setId(driverId);
        driver.setName(driverName);
        driver.setLicenseNumber(licenseNumber);
        return driver;
    }
}
