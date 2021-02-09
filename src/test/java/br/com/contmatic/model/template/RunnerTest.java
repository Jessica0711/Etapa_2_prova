package br.com.contmatic.model.template;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.model.auditoria.AuditoriaTest;
import br.com.contmatic.model.empresa.ClienteTest;
import br.com.contmatic.model.empresa.EmpresaTest;
import br.com.contmatic.model.empresa.FuncionarioTest;
import br.com.contmatic.model.endereco.CidadeTest;
import br.com.contmatic.model.endereco.EnderecoTest;
import br.com.contmatic.model.endereco.EstadoTest;
import br.com.contmatic.model.endereco.PaisTest;
import br.com.contmatic.model.produto.ProdutoTest;
import br.com.contmatic.model.telefone.TelefoneTest;

/**
 * The Class RunnerTest.
 */
@RunWith(Suite.class)
@SuiteClasses({ EmpresaTest.class, FuncionarioTest.class, ProdutoTest.class, EnderecoTest.class, ClienteTest.class,
		TelefoneTest.class, AuditoriaTest.class, CidadeTest.class, EstadoTest.class, PaisTest.class })
public class RunnerTest {
}
