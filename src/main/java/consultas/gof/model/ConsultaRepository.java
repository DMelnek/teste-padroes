package consultas.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Long> {
    List<Consulta> findByHorario(LocalDateTime horario);
}
