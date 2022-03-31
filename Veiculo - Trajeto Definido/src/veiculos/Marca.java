package veiculos;

/**
 *
 * @author Luiz Fillipe O. Morais
 *         Matrícula: 2019107733
 *              &
 *         Emanuel Silva Sergio
 *         Matrícula: 2019107863
 */
public class Marca {
    private String Nome, nrDeModelos, codigoIdentificador;
    private int anoLancamento;
    
    public Marca(){
        this.Nome = "";
        this.nrDeModelos = "";
        this.codigoIdentificador = "";
        this.anoLancamento = 0;
    }
    public Marca(String nome, String nModelo, int anoLancamento, String Chassi){
        this.Nome = nome;
        this.nrDeModelos = nModelo;
        this.codigoIdentificador = Chassi;
        this.anoLancamento = anoLancamento;
    }
    public void setNome(String nome){
        this.Nome = nome; 
    }
    public String getNome(){
        return this.Nome;
    }
    public void setnrDeModelos(String modelo){
        this.nrDeModelos = modelo;        
    }
    public String getnrDeModelos(){
        return this.nrDeModelos;
    }
    public void setanoLancamento(int ano){
        this.anoLancamento = ano;        
    }
    public int getanoLancamento(){
        return this.anoLancamento;
    }    
    public void setcodigoIdentificador(String chassi){
        this.codigoIdentificador = chassi;        
    }
    public String getcodigoIdentificador(){
        return this.codigoIdentificador;
    }    
}
