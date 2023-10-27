package com.tenway.start.entidades;

public class Agendamento {

    private int agendamentoId;


    private Long usuarioId;
    private int recursoId;

    public int getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(int agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(int recursoId) {
        this.recursoId = recursoId;
    }
}
