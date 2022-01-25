package des.hibernate.relaciones.MannyToManyExtraColumns;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long modulo_id;

	private String nombre;

	@OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Matricula> matriculas = new ArrayList<>();

	public Modulo(Long modulo_id, String nombre, List<Matricula> modulo) {
		super();
		this.modulo_id = modulo_id;
		this.nombre = nombre;
		this.matriculas = modulo;
	}

	public Modulo() {
	}
	
	

	public Long getModulo_id() {
		return modulo_id;
	}

	public void setModulo_id(Long modulo_id) {
		this.modulo_id = modulo_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Modulo tag = (Modulo) o;
		return Objects.equals(nombre, tag.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	
	public void anadirMatricula (Matricula m) {
		
		matriculas.add(m);
		
	}
	
	

}
