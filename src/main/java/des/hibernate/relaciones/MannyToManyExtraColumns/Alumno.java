package des.hibernate.relaciones.MannyToManyExtraColumns;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alumno_id;

	private String nombre;

	private String apellidos;

	private String dni;

	@OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Matricula> matriculas = new ArrayList<>();

	public void matricularAlumno (Modulo modulo, Alumno alumno, Integer calificacion ) {
		
		
		
		Matricula m = new Matricula (alumno, modulo,calificacion);
		this.getMatriculas().add(m);
		
		
		
		
	}

	public Alumno() {
	}

	public Alumno(Long alumno_id, String nombre, String apellidos, String dni, List<Matricula> matriculas) {
		super();
		this.alumno_id = alumno_id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.matriculas = matriculas;
	}

	public Long getAlumno_id() {
		return alumno_id;
	}

	public void setAlumno_id(Long alumno_id) {
		this.alumno_id = alumno_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

}
