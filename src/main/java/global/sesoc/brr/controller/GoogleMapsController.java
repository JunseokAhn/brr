package global.sesoc.brr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "maps")
public class GoogleMapsController {

	@GetMapping(value = "mapsMain")
	public String MapsMain() {

		return "maps/mapsMain";
	}
}