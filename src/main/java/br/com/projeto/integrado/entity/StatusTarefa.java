package br.com.projeto.integrado.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "status_tarefa")
public class StatusTarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_tarefa_id")
    private Integer statusTarefaId;

    @Column(name = "status_descricao")
    private String statusDescricao;

    @OneToOne(mappedBy = "statusTarefa")
    Tarefa tarefa;

    public Integer getStatusTarefaId() {
        return statusTarefaId;
    }

    public void setStatusTarefaId(Integer statusTarefaId) {
        this.statusTarefaId = statusTarefaId;
    }

    public String getStatusDescricao() {
        return statusDescricao;
    }

    public void setStatusDescricao(String statusDescricao) {
        this.statusDescricao = statusDescricao;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

}