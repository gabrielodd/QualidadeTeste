package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	@Test
	public void testMultiplicacao() {
		int multiplicacao = calc.multiplicacao(3, 3);
		assertEquals(9, multiplicacao);
	}
	
	@Test
	public void testSubtracao() {
		int subtracao = calc.subtracao(3, 3);
		assertEquals(0, subtracao);
	}
	
	@Test
	public void testEhPositivo() {
		boolean positivo = calc.ehPositivo(1);
		boolean negativo = calc.ehPositivo(-1);
		assertEquals(true, positivo);
		assertEquals(false, negativo);
	}

	@Test
	public void testSomatoria() {
		int somatorio = calc.somatoria(10);
		assertEquals(55, somatorio);
	}
	
	@Test
	public void testCompara() {
		int comparaMenor = calc.compara(2, 3);
		int comparaMaior = calc.compara(3, 2);
		int comparaIgual = calc.compara(2, 2);
		assertEquals(-1, comparaMenor);
		assertEquals(1, comparaMaior);
		assertEquals(0, comparaIgual);
	}
}
