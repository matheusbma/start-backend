package com.tenway.start.entidades;

public class Usuario {

    private long usuarioId;
    private long matricula;
    private String nome;
    private String senha;
    private String email;

   public Usuario (long usuarioId, long matricula, String nome, String senha, String email) {
       this.usuarioId = usuarioId;
       this.matricula = matricula;
       this.nome = nome;
       this.senha = senha;
       this.email = email;
   }
   public boolean Login(String senhaInserida){
       return senhaInserida.equals(this.senha);
   }

   public void Register(String novoNome, String novaSenha, String novoEmail) {
       this.nome = novoNome;
       this.senha = novaSenha;
       this.email = novoEmail;
   }

   public void Agendar(String detalheAgendamento) {
       System.out.println("Agendamento feito com sucesso: " + detalheAgendamento);
   }

   public void AlterarAgendamento(String alterarAgendamento) {
       System.out.println("Agenda alterado com sucesso: " + alterarAgendamento);
   }

    public void CancelarAgendamento(String cancelarAgendamento) {
        System.out.println("Agenda cancelado com sucesso: " + cancelarAgendamento);
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
