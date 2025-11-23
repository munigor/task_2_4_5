package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/cars")
    public String index(Model model, @RequestParam(name = "count", defaultValue = "50") String count) {
        model.addAttribute("cars", carService.getAll(getLimit(count)));
        return "car";
    }

    @GetMapping(path = "/cars-init")
    public String init(Model model) {
        carService.add(new Car("Hyundai", "PALISADE", 2025));
        carService.add(new Car("Hyundai", "IONIQ5", 2025));
        carService.add(new Car("Hyundai", "GRANDEUR", 2025));
        carService.add(new Car("Hyundai", "SONATA", 2025));
        carService.add(new Car("KIA", "K5", 2025));
        return "redirect:/cars";
    }

    private Integer getLimit(String count) {
        int MAX_CAR_LIMIT = 50;
        try {
            int limit = Integer.parseInt(count);
            if (limit <= 0 ||  limit >= 5) {
                return MAX_CAR_LIMIT;
            }
            return limit;
        } catch (NumberFormatException e) {
            return MAX_CAR_LIMIT;
        }
    }
}
