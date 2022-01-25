package des.hibernate.relaciones.MannyToManyExtraColumns;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/manytomanyextra")
public class ControladorManyToManyExtraColumn {

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/index" })
	public String getIndex() {
		return "index";
	}
	
}
