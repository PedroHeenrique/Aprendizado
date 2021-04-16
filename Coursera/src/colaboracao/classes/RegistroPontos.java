package colaboracao.classes;

public class RegistroPontos {
  
  private CalculadoraBonus bonus;
  
  public RegistroPontos(CalculadoraBonus calcbonus) {
   bonus = calcbonus;
  }
  
  public void fazerUmComentario(Usuario user) {
    user.pontos += 3 * bonus.bonus(user);
  }
  
  public void criarUmTopico (Usuario user) {
    user.pontos += 5 * bonus.bonus(user);
  }
  
  public void darLike(Usuario user) {
    user.pontos += 1 * bonus.bonus(user);
  }

}
