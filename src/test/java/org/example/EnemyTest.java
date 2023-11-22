package org.example;

public class EnemyTest {

    @Mock
    Point mockPoint;

    @Test
    public void testHurt() {
        // Configuração do objeto mock
        when(mockPoint.getX()).thenReturn(10.0);
        when(mockPoint.getY()).thenReturn(20.0);

        // Criando um inimigo mock
        Enemy enemy = new Enemy(1.5, 100, mockPoint);

        // Chamando o método a ser testado
        enemy.hurt(20);

        // Verificando se os métodos foram chamados corretamente
        verify(mockPoint, times(1)).getX();
        verify(mockPoint, times(1)).getY();

        // Verificando se o método die() foi chamado corretamente
        verify(enemy, times(1)).die();
    }

    @Test
    public void testDie() {
        // Criando um inimigo mock
        Enemy enemy = spy(new Enemy(1.5, 100, new Point(10, 20)));

        // Chamando o método a ser testado
        enemy.die();

        // Verificando se o método foi chamado corretamente
        verify(enemy, times(1)).die();
    }
}
