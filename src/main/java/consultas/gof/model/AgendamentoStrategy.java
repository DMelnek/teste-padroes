package consultas.gof.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

public interface AgendamentoStrategy {
    boolean verificarDisponibilidade(LocalDateTime horario);
}
