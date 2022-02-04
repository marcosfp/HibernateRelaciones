package des.hibernate.relaciones.MannyToManyExtraColumns;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ManyToManyExtraServiceImpl implements ManyToManyExtraService {

	@Autowired
	AlumnoRepository alumnoRepository;

	@Autowired
	ModuloRepository moduloRepository;

	@Autowired
	MatriculaRepository matriculaRepository;

	@Override
	public Iterable<Alumno> ObtenerAlumnos() {
		return alumnoRepository.findAll();
	}

	@Override
	public Iterable<Modulo> ObtenerModulos() {
		return moduloRepository.findAll();
	}

	@Override
	public Iterable<Matricula> ObtenerMatriculas() {
		return matriculaRepository.findAll();
	}

	@Override
	public Alumno crearAlumno(Alumno a) {
		return alumnoRepository.save(a);
	}

	@Override
	public Modulo crearModulo(Modulo m) {
		return moduloRepository.save(m);
	}

	@Override
	public Matricula matricularAlumno(Long alumnoId, Long moduloId, Integer callificacion) {

		
		System.out.println("//////////////////RECUPERAMOS EL ALUMNO //////////////////");
		
		Alumno alumno = alumnoRepository.findById(alumnoId).orElse(null);
		
		System.out.println("//////////////////RECUPERAMOS EL MODULO //////////////////");

		
		Modulo modulo= moduloRepository.findById(moduloId).orElse(null);
		
		if(alumno == null || modulo == null) return null;
		
		System.out.println("//////////////////MATRICULA //////////////////");

		
		alumno.matricularAlumno(modulo, callificacion);
		alumnoRepository.save(alumno);
		return null;
	}

	@Override
	public void desmatricularAlumno(Matricula m) {

		m.getAlumno().desmatricularAlumno(m);

	}

}
