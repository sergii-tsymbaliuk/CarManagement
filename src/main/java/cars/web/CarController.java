package cars.web;

import java.beans.PropertyEditorSupport;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cars.common.Car;
import cars.common.CarModel;
import cars.common.Engine121;
import cars.service.CarEngineService;
import cars.service.CarModelService;
import cars.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

	@Resource
	CarService carService;
	
	@Resource 
	CarModelService carModelService;
	
	@Resource 
	CarEngineService carEngineService;	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//Car
		binder.registerCustomEditor(
			Car.class, new PropertyEditorSupport() {
				@Override
				public void setAsText(String id) {
					System.out.println("PropertyEditorSupport.setAsText: id="+id);
					if (id != null && !id.isEmpty()){
						setValue(carService.findOne(Integer.valueOf(id)));
					}else setValue(null);
					System.out.println("PropertyEditorSupport.setAsText: value="+getValue());
				}
		});
		
		//CarModel
		binder.registerCustomEditor(
				CarModel.class, new PropertyEditorSupport() {
					@Override
					public void setAsText(String carModel) {
						setValue(carModelService.findOne(Long.valueOf(carModel)));
						System.out.println("CarModel binder. ID= "+carModel+ ", car: "+getValue());
				}
		});
		
		//Engine
		binder.registerCustomEditor(
				Engine121.class, new PropertyEditorSupport() {
					@Override
					public void setAsText(String engine) {
						setValue(carEngineService.findOne(Long.valueOf(engine)));
						System.out.println("Engine121 binder. ID= "+engine+ ", Engine: "+getValue());
				}
		});
	}
	
	@RequestMapping({"/","/list"})
	public String showCarList(Model model){
		System.out.println("showCarList");
		model.addAttribute("cars", carService.findAll());
		System.out.println(model.asMap().get("cars"));		
		return "cars/list";
	}
	
	@RequestMapping(value={"/view"})
	public String viewCar(@RequestParam("id") Car car, Model model){
		System.out.println("viewCar");
		model.addAttribute("car", car);
		System.out.println(model.asMap().get("car"));		
		return "cars/view";
	}	
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String showAddCarForm(Model model){
		System.out.println("viewAddCarForm");
		model.addAttribute("car",new Car());
		model.addAttribute("carModels", carModelService.findAll());
		model.addAttribute("carEngines", carEngineService.findAll());				
		return "cars/edit";
	}	
	
	@RequestMapping(value={"/edit"}, method=RequestMethod.GET)
	public String showEditCarForm(@RequestParam("id") Car car, Model model){
		System.out.println("showEditCarForm for car "+car);
		model.addAttribute("car",car);
		model.addAttribute("carModels", carModelService.findAll());
		model.addAttribute("carEngines", carEngineService.findAll());				
		return "cars/edit";
	}
	
	@RequestMapping(value={"/edit","/add"} ,method=RequestMethod.POST)
	public String editCar(
				@ModelAttribute("car") Car car
				){
		System.out.println("editCar post: + " + car);
		carService.save(car);
		//model.addAttribute("car",car);
		return "redirect:/cars/list";
	}	
	
	@RequestMapping(value={"/delete"},method=RequestMethod.POST)
	public String deleteCar(@RequestParam("id") Car car){
		System.out.println("deleteCar "+car);
		carService.delete(car);
		
		return "redirect:/cars/list";
	}
	
//	@ModelAttribute("car") 
//	public Car getCar(@RequestParam(value="id",required=false) Car car){
//		car = (car == null) ? new Car() : car;
//		System.out.println("getCar: "+car);
//		return car;
//	}
}
