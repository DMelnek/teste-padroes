package consultas.gof.service;

import consultas.gof.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClinicaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AgendamentoStrategy agendamentoStrategy;

    public boolean agendarConsulta(Long clienteId, LocalDateTime horario) {
        Cliente cliente = clienteRepository. findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        if (agendamentoStrategy.verificarDisponibilidade(horario)) {
            Consulta consulta = new Consulta(cliente, horario);
            consultaRepository.save(consulta);
            return true;
        } else {
            return false;
        }
    }
    public List<Consulta> listarConsultas() {
        Iterable<Consulta> consultaIterable = consultaRepository.findAll();
        return StreamSupport.stream(consultaIterable.spliterator(),false)
                .collect(Collectors.toList());
    }
    public Cliente cadastrarCliente(String nome, String telefone) {
        Cliente cliente = new Cliente(nome, telefone);

        return clienteRepository.save(cliente);
    }

}
