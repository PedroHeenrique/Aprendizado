package colaboracao.classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestesRegistroPontos {

  @Test
  public void pontosCriarTopico() {
    Usuario user = new Usuario();
    user.nome = "Pedro Henrique";
    
    CalculadoraBonus calc = new CalculadoraBonus();
    RegistroPontos registro = new RegistroPontos(calc);
    registro.criarUmTopico(user);
    
    assertEquals(user.pontos, 5);
  }
  
  
  @Test
  public void pontosCriarTopicoVip() {
    Usuario user = new Usuario();
    user.nome = "Pedro Henrique";
    user.vip = true;
    CalculadoraBonus calc = new CalculadoraBonus();
    RegistroPontos registro = new RegistroPontos(calc);
    registro.criarUmTopico(user);
    
    assertEquals(user.pontos, 25);
  }

  @Test
  public void pontosCriarTopicoBonusDoDia() {
    Usuario user = new Usuario();
    user.nome = "Pedro";
    user.vip = true;
    CalculadoraBonus calc = new CalculadoraBonus();
    calc.bonusDoDia = 3;
    RegistroPontos registro = new RegistroPontos(calc);
    registro.criarUmTopico(user);
    
    assertEquals(user.pontos, 75);
  }
  
  @Test
  public void pontosCriarTopicoBonusDoDia2() {
    Usuario user = new Usuario();
    user.nome = "Pedro";
    user.vip = true;
    CalculadoraBonus calc = new CalculadoraBonus();
    calc.bonusDoDia = 3;
    RegistroPontos registro = new RegistroPontos(calc);
    registro.criarUmTopico(user);
    
    assertEquals(user.pontos, 75);
  }
}
