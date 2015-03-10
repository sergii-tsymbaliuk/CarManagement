package cars.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cars.service.CarService;

@Controller
@RequestMapping("/ws/cars")
public class CarRestController {
	@Resource
	CarService carService;
	
	@RequestMapping("/get")
	
	public String viewCar( @PathVariable("id") Integer id, Model model){
		model.addAttribute("car", carService.findOne(id));
		return("/cars/view");
	}

}
