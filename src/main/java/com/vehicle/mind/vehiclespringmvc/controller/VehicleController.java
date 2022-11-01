package com.vehicle.mind.vehiclespringmvc.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vehicle.mind.vehiclespringmvc.download.UserExcelExporter;
import com.vehicle.mind.vehiclespringmvc.model.Vehicle;
import com.vehicle.mind.vehiclespringmvc.service.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService service;

	@GetMapping("/")
	public String getAllVehicles(ModelMap model) {
		model.addAttribute("vehicles", service.getAllVehicles());
		return "vehiclesListPage";
	}

	@GetMapping("add-vehicle")
	public String showVehicle(ModelMap model) {
		Vehicle vehicle = new Vehicle("", "", "", "");
		model.addAttribute("vehicle", vehicle);
		return "VehicleAddUpdatePage";
	}

	@PostMapping("add-vehicle")
	public String addVehicleItem(ModelMap model, Vehicle vehicle) {

		service.addVehicle(vehicle);
		return "redirect:/";
	}

	@GetMapping("edit-vehicle")
	public String showEditVehcile(ModelMap model, @RequestParam String id) {
		Vehicle vehicle = service.getVehicleByNumber(id);
		model.addAttribute("vehicle", vehicle);
		return "VehicleAddUpdatePage";
	}

	@PostMapping("edit-vehicle")
	public String editVehicleItem(ModelMap model, Vehicle vehicle) {

		service.addVehicle(vehicle);
		return "redirect:/";
	}

	@GetMapping("/downloadExcel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Vehicle> listUsers = service.getAllVehicles();

		UserExcelExporter excelExporter = new UserExcelExporter(listUsers);

		excelExporter.export(response);
	}

}
