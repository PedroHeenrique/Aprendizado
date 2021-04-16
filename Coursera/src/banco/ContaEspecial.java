package banco;

public class ContaEspecial extends ContaCorrente{
  int limite;
  
  public ContaEspecial(int limite) {
   this.limite = limite;
  }
  
  public int sacar(int valor) {
    if(valor > (saldo + limite)) {
      return valor;
    }else {
      saldo-=valor;
      return valor;
    }
    
  }

}
