package zoologico.model;

public class GuiaTuristico extends Funcionario{
    private String idioma;
    
    public GuiaTuristico(int matricula, String nome, String cargo, String telefone, String email, String idioma){
        super(matricula, nome, cargo, telefone, email);
        this.idioma = idioma;
    }
    
    // Getters e Setters
    
    public String getIdioma(){
        return idioma;
    }
    
    public void setIdioma(String idioma){
        this.idioma = idioma;
    }
    
    // Metodo
    
    public void agendarTour(){
        // logica do tour aqui!
    }
}
