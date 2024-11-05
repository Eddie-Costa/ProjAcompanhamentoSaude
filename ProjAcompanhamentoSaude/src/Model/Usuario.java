package Model;

public class Usuario {
    private String Nome;
    private int Idade;
    private double Peso;
    private double Altura;
    private double PA;
    private double Glicemia;
    private double Colesterol;
    private double Creatinina;
    private int FrequenciaAcad;
    private double IMC;
    private String RemediosDiarios;
    
    //Métodos
    
    //Setters

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    public void setPA(double PA) {
        this.PA = PA;
    }

    public void setGlicemia(double Glicemia) {
        this.Glicemia = Glicemia;
    }

    public void setColesterol(double Colesterol) {
        this.Colesterol = Colesterol;
    }

    public void setCreatinina(double Creatinina) {
        this.Creatinina = Creatinina;
    }

    public void setFrequenciaAcad(int FrequenciaAcad) {
        this.FrequenciaAcad = FrequenciaAcad;
    }

    public void setRemediosDiarios(String RemediosDiarios) {
        this.RemediosDiarios = RemediosDiarios;
    }
    
    //Getters

    public String getNome() {
        return Nome;
    }

    public int getIdade() {
        return Idade;
    }

    public double getPeso() {
        return Peso;
    }

    public double getAltura() {
        return Altura;
    }

    public double getPA() {
        return PA;
    }

    public double getGlicemia() {
        return Glicemia;
    }

    public double getColesterol() {
        return Colesterol;
    }

    public double getCreatinina() {
        return Creatinina;
    }

    public int getFrequenciaAcad() {
        return FrequenciaAcad;
    }

    public double getIMC() {
        return IMC;
    }

    public String getRemediosDiarios() {
        return RemediosDiarios;
    }

    //Bi-Direcionais
    
    public double CalcularIMC(double p_altura, double p_peso){
        double al = p_altura * p_altura;
        double imc = p_peso / al;
        return this.IMC;
    }
}
