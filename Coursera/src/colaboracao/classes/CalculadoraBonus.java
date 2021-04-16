package colaboracao.classes;

public class CalculadoraBonus {
  public int bonusDoDia = 1;
  
  public int bonus(Usuario user) {
    int multiplicador = bonusDoDia;
    
    if(user.vip)
      multiplicador *= 5;
    return multiplicador;
  }

}
