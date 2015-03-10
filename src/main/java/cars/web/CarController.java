package cars.web;

import java.beans.PropertyEditorSupport;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cars.common.Car;
import cars.dao.CarModelDao;
import cars.service.CarEngineService;
import cars.service.CarModelService;
import cars.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(
			Car.class, new PropertyEditorSupport() {
				@Override
				public void setAsText(String id) {
					setValue(carService.findOne(Integer.valueOf(id)));
				}
		});
	}

	@Resource
	CarService carService;
	
	@Resource 
	CarModelService carModelService;
	
	@Resource 
	CarEngineService carEngineService;	
	
	
	@RequestMapping({"/","/list"})
	public String showCarList(Model model){
		System.out.println("showCarList");
		model.addAttribute("cars", carService.findAll());
		System.out.println(model.asMap().get("cars"));		
		return "cars/list";
	}
	
	@RequestMapping(value={"/view"})
	public String viewCar(@RequestParam("id") Integer id, Model model){
		System.out.println("viewCar");
		model.addAttribute("car", carService.findOne(id));
		System.out.println(model.asMap().get("car"));		
		return "cars/view";
	}	
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String showAddCarForm(Model model){
		System.out.println("viewAddCarForm");
		model.addAttribute("carModels", carModelService.findAll());
		model.addAttribute("carEngines", carEngineService.findAll());				
		return "cars/add";
	}	
		
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String showEditCarForm(@RequestParam("id") Car car, Model model){
		System.out.println("showEditCarForm");
		model.addAttribute("carModels", carModelService.findAll());
		model.addAttribute("carEngines", carEngineService.findAll());				
		return "cars/edit";
	}
	
	@RequestMapping(value={"/edit"},method=RequestMethod.POST)
	public String editCar(@RequestParam("id") Integer id, Model model){
		System.out.println("editCar");
			
		return "cars/edit";
	}	
	
	@RequestMapping(value={"/delete"},method=RequestMethod.POST)
	public String deleteCar(@RequestParam("id") Integer id){
		System.out.println("deleteCar id="+id);
		carService.delete(id);
		
		return "cars/list";
	}
}
