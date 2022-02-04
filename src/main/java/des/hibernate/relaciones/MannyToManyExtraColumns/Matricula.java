package des.hibernate.relaciones.MannyToManyExtraColumns;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatriculaId id_matricula;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("alumno_id")
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("modulo_id")
	private Modulo modulo;

	private Date fecha_creacion = new Date();
	
	private Integer calificacion;
	
	public Matricula(Alumno alumno, Modulo modulo, Integer calificacion) {
		this.id_matricula= new MatriculaId(alumno.getAlumno_id(),modulo.getModulo_id());
		this.alumno = alumno;
		this.modulo = modulo;
		this.calificacion = calificacion;
	}

	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Matricula that = (Matricula) o;
        return Objects.equals(alumno, that.alumno) &&
               Objects.equals(modulo, that.modulo);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(alumno, modulo);
    }
	
	
	
	
	
}
