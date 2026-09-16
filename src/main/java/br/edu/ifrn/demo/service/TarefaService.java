package br.edu.ifrn.demo.service;
import br.edu.ifrn.demo.Model.Tarefa;
import br.edu.ifrn.demo.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TarefaService {
    private final TarefaRepository repository;
    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }
    public Tarefa criar(String titulo) {
        System.out.println("[SERVICE] Validando regra de negócio para: " +
                titulo);
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio.");
        }
        return repository.salvar(titulo.trim());
    }
    public List<Tarefa> listar() {
        System.out.println("[SERVICE] Solicitando lista de tarefas ao repository");
        return repository.listarTodas();
    }
    public Tarefa buscarPorId(Long id) {
        System.out.println("[SERVICE] Processando busca por id: " + id);
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + id));
    }
    public List<Tarefa> listarConcluidas() {
        System.out.println("[SERVICE] Solicitando lista de tarefas concluidas");
        List<Tarefa> tarefas = listar();
        List<Tarefa> tarefasConcluidas=new List<Tarefa>();

        for(tarefa in tarefas){
            if(tarefa.isConcluido()){
                tarefasConcluidas.put(tarefa);
            }
        }
        return tarefasConcluidas;
    }
}