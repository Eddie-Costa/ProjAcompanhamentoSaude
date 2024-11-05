
package Model;

import java.util.Date;

public class Academia {
    private String Dia;
    private String DiaDaSemana;
    private String TipoDeTreino;
    
    //Métodos
    
    //Setters

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public void setDiaDaSemana(String DiaDaSemana) {
        this.DiaDaSemana = DiaDaSemana;
    }

    public void setTipoDeTreino(String TipoDeTreino) {
        this.TipoDeTreino = TipoDeTreino;
    }
    
    //Getters

    public String getDia() {
        return Dia;
    }

    public String getDiaDaSemana() {
        return DiaDaSemana;
    }

    public String getTipoDeTreino() {
        return TipoDeTreino;
    }
    
}
