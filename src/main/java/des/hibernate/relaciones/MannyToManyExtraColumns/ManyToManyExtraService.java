package des.hibernate.relaciones.MannyToManyExtraColumns;

public interface ManyToManyExtraService {

	
	Iterable<Alumno> ObtenerAlumnos();
	
	Iterable<Modulo> ObtenerModulos();
	
	Iterable<Matricula> ObtenerMatriculas();
	
	Alumno crearAlumno(Alumno a);
	
	Modulo crearModulo(Modulo m);
	
	Matricula matricularAlumno(Alumno a, Modulo m, Integer callificacion);
	
	void desmatricularAlumno(Matricula m);
	
}
