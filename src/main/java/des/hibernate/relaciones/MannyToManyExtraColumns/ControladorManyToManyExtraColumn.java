package des.hibernate.relaciones.MannyToManyExtraColumns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/manytomanyextra")
public class ControladorManyToManyExtraColumn {

	@Autowired
	ManyToManyExtraService servicio;
	
	
	@RequestMapping(method = RequestMethod.GET, value = { "/", "/index" })
	public ModelAndView getIndex() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("listaModulos",servicio.ObtenerModulos());
		mav.addObject("listaMatriculas",servicio.ObtenerMatriculas());
		mav.addObject("listaAlumnos",servicio.ObtenerAlumnos());

		
		return mav;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value ={"/crearModulo"})
	public String crearModulo(@RequestParam String nombreModulo) {
		
		Modulo modulo = new Modulo(nombreModulo);
		servicio.crearModulo(modulo);
		return "redirect:/manytomanyextra/index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value ={"/crearAlumno"})
	public String crearAlumno(@RequestParam String nombreyapellidosAlumno) {

		Alumno alumno = new Alumno(nombreyapellidosAlumno);
		servicio.crearAlumno(alumno);
		return "redirect:/manytomanyextra/index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value ={"/matricularAlumno"})
	public String matricularAlumno(@RequestParam(name="modulo") Long moduloId, @RequestParam(name="alumno") Long alumnoId) {

		servicio.matricularAlumno(alumnoId, moduloId, 0);
		
		return "redirect:/manytomanyextra/index";
	}
	
	
}
