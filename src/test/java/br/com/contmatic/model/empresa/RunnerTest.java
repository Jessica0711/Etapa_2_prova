package br.com.contmatic.model.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.model.endereco.EnderecoTest;
import br.com.contmatic.model.produto.ProdutoTest;
import br.com.contmatic.model.telefone.TelefoneTest;

/**
 * The Class RunnerTest.
 */
@RunWith(Suite.class)
@SuiteClasses({EmpresaTest.class,FuncionarioTest.class, ProdutoTest.class, EnderecoTest.class, ClienteTest.class, TelefoneTest.class})
public class RunnerTest {
}
