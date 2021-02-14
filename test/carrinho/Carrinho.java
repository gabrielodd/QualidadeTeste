package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTest {
	
	private Carrinho carrinho;
	
	@Test
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		
		Produto item1 = new Produto("Item 1", 5.0);
		Produto item2 = new Produto("Item 2", 10.0);
		carrinho.addItem(item1);
		carrinho.addItem(item2);
	}

	@Test
	public void testGetValorTotal() {
		double total = carrinho.getValorTotal();
		
		assertEquals(15.0, total);
	}
	
	@Test
	public void addItem() {
		Produto item3 = new Produto("Item 3", 5.0);
		carrinho.addItem(item3);
		
		assertEquals(3, carrinho.getQtdeItems());
	}
	
	@Test
	public void testRemoveItem() {
		Produto item4 = new Produto("Item 4", 5.0);
		carrinho.addItem(item4);
		
		try {
			assertEquals(3, carrinho.getQtdeItems());
			carrinho.removeItem(item4);
			assertEquals(2, carrinho.getQtdeItems());
		} catch (ProdutoNaoEncontradoException e) {
			
		}
		
	}
	
	@Test
	public void testRemoveItemException() {
		Produto item5 = new Produto("Item 5", 5.0);
		
		assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(item5));
	}
	
	@Test
	public void testEsvazia() {
		carrinho.esvazia();
		
		assertEquals(carrinho.getQtdeItems(), 0);
	}
}