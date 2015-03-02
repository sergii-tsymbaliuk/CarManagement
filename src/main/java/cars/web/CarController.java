package cars.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cars.service.CarService;

@Controller
@RequestMapping("cars")
public class CarController {

	@Resource
	CarService carService;
	
	@RequestMapping({"","list"})
	public String showCarList(Model model){
		System.out.println("showCarList");
		model.addAttribute("cars",carService.findAll());
		System.out.println(model.asMap().get("cars"));		
		return "cars/list";
	}
	
}
