package des.hibernate.relaciones.MannyToManyExtraColumns;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AlumnoRepository extends PagingAndSortingRepository<Alumno, Long>{


}
