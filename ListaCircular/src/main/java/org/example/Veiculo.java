package org.example;

class Veiculo {
    String placa;
    String diaSemana;
    String horario;

    public Veiculo(String placa, String diaSemana, String horario) {
        this.placa = placa;
        this.diaSemana = diaSemana;
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " | Dia: " + diaSemana + " | Horário: " + horario;
    }
}
