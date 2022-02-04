package des.hibernate.relaciones.MannyToManyExtraColumns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Alumno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alumno_id;

	private String nombreyapellidos;

	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Matricula> matriculas = new ArrayList<>();

	public Matricula matricularAlumno(Modulo modulo, Integer calificacion) {

		Matricula matricula = new Matricula(this, modulo, calificacion);
		modulo.getMatriculas().add(matricula);
		matriculas.add(matricula);
		return matricula;
	}

	public void desmatricularAlumno(Matricula matricula) {

		matricula.getModulo().eliminarMatricula(matricula);
		this.getMatriculas().remove(matricula);
	}

	public Alumno(Long alumno_id, String nombreyapellidos, List<Matricula> matriculas) {
		this.alumno_id = alumno_id;
		this.nombreyapellidos = nombreyapellidos;
		this.matriculas = matriculas;
	}

	public Alumno(String nombreyapellidos) {
		this.nombreyapellidos = nombreyapellidos;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Alumno m = (Alumno) o;
		return Objects.equals(nombreyapellidos, m.nombreyapellidos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreyapellidos);
	}

}
