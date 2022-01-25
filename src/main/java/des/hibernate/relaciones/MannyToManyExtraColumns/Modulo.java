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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long modulo_id;

	private String nombre;

	@OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Matricula> matriculas = new ArrayList<>();

	public Modulo(Long modulo_id, String nombre, List<Matricula> modulo) {
		super();
		this.modulo_id = modulo_id;
		this.nombre = nombre;
		this.matriculas = modulo;
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

	public void anadirMatricula(Matricula m) {
		matriculas.add(m);
	}

	public void eliminarMatricula(Matricula m) {
		matriculas.remove(m);
	}

}
