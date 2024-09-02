package consultas.gof.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class Agendamento implements AgendamentoStrategy{

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public boolean verificarDisponibilidade(LocalDateTime horario){
        List<Consulta> consultas = consultaRepository.findByHorario(horario);
        return consultas.isEmpty();
    }
}
