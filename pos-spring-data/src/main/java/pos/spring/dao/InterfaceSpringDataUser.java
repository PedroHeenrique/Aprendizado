package pos.spring.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pos.spring.model.UsuarioSpring;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpring, Long>{
	
	@Transactional(readOnly = true)
    @Query(value="Select p from UsuarioSpring p where p.nome like %?1%")
	public List <UsuarioSpring> buscaPorNome(String nome);
	
	/**BLOQUEIA EM CASOS EM QUE ESTAO SENDO REALIZADAS OPERAÇÕES DE UPDATE/INSERT E
	ALGUEM ESTIVER TENTANDO CONSULTAR, 
	EVITA EXIBIÇÃO DE DADOS ERRADOS*/
	@Lock(LockModeType.READ)
	@Transactional(readOnly = true)
    @Query(value="select p from UsuarioSpring p where p.nome = :parametronome " )
    public UsuarioSpring buscaNomePorParametro(@Param("parametronome")String parametronome);
 
    default <S extends UsuarioSpring> S saveAtual(S entity) {
    	//PODE SE EXECUTAR VARIAS ROTINAS,CONSULTAS NO BANCO ANTES DE SALTAR
    	return save(entity);
    }
    
    /*PRIMEIRO DIZEMOS QUE VAMOS MODIFICAR A TABELA NO BANCO
     * EM SEGUIDA STARTAMOS UMA TRANSAÇÃO, NAO CONTENDO ESSAS ANOTAÇÕES VAI DAR ERRO
     */
    @Modifying
    @Transactional
                //ESSA INTERROGAÇÃO SEGUIDA POR UM NUMERO E A QUANTIDADE DE PARAMETROS QUE SERAM PASSADOS.
    @Query ("delete from UsuarioSpring u where u.nome =?1")
    public void deletePorNome(String nome);
   
    @Modifying
    @Transactional(rollbackFor = SQLException.class)//VAI REALIZAR UM ROLLBACK CASO ESSA CLASSE DE EXCEÇÃO SEJE LANÇADA
    @Query("update UsuarioSpring u set u.email = ?1 where u.nome =?2")
    public void updateEmailPorNome(String email, String nome);
}
