package consultas.gof.controller;


import consultas.gof.model.Cliente;
import consultas.gof.model.Consulta;
import consultas.gof.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/melnek/clinica")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @PostMapping("/clientes")
    public Cliente cadastrarCliente(@RequestParam String nome, @RequestParam String telefone) {
        return clinicaService.cadastrarCliente(nome, telefone);
    }

    @PostMapping("/consultas")
    public ResponseEntity<String> agendarConsulta(@RequestParam Long clientId, @RequestParam LocalDateTime horario){
        boolean sucesso = clinicaService.agendarConsulta(clientId, horario);
        if (sucesso) {
            return ResponseEntity.ok("Consulta agendada com sucesso.");
        }else {
            return ResponseEntity.badRequest().body("Horário indisponível.");
        }
    }
    @GetMapping("/consultas")
    public List<Consulta> listarConsultas(){
        return clinicaService.listarConsultas();
    }
}
