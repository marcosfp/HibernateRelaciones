package des.hibernate.relaciones.MannyToManyExtraColumns;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Matricula {

	private MatriculaId id_matricula;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("alumno_id")
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("modulo_id")
	private Modulo modulo;

	private Date fecha_creacion = new Date();
	
	private Integer calificacion;
	

	public Matricula() {
	}

	public Matricula(Alumno alumno, Modulo modulo, Integer calificacion) {
		super();
		this.alumno = alumno;
		this.modulo = modulo;
		this.calificacion = calificacion;
	}

	public Matricula( Alumno alumno, Modulo modulo) {
		super();
		this.alumno = alumno;
		this.modulo = modulo;
		this.calificacion = 0;
	}

	
	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public MatriculaId getId_matricula() {
		return id_matricula;
	}

	public void setId_matricula(MatriculaId id_matricula) {
		this.id_matricula = id_matricula;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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
