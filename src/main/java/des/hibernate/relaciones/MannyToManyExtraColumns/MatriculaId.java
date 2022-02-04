package des.hibernate.relaciones.MannyToManyExtraColumns;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class MatriculaId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "alumno_id")
	private Long alumno_id;

	@Column(name = "modulo_id")
	private Long modulo_id;


	public MatriculaId(Long alumno_id, Long modulo_id) {
		super();
		this.alumno_id = alumno_id;
		this.modulo_id = modulo_id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		MatriculaId that = (MatriculaId) obj;
        return Objects.equals(alumno_id, that.alumno_id) &&
               Objects.equals(modulo_id, that.modulo_id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(alumno_id, modulo_id);
	}
}
