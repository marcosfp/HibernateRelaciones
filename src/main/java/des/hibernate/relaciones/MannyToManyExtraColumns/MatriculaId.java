package des.hibernate.relaciones.MannyToManyExtraColumns;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class MatriculaId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "alumno_id")
	private Long alumno_id;

	@Column(name = "modulo_id")
	private Long modulo_id;

	public MatriculaId() {
	}

	public MatriculaId(Long alumno_id, Long modulo_id) {
		super();
		this.alumno_id = alumno_id;
		this.modulo_id = modulo_id;
	}

	public Long getAlumno_id() {
		return alumno_id;
	}

	public void setAlumno_id(Long alumno_id) {
		this.alumno_id = alumno_id;
	}

	public Long getModulo_id() {
		return modulo_id;
	}

	public void setModulo_id(Long modulo_id) {
		this.modulo_id = modulo_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno_id, modulo_id);
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

}
