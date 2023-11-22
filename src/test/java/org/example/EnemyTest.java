package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class EnemyTest {

    @Test
    public void enemyHurtTest() {
        // Criar um mock para Enemy
        Enemy enemy = mock(Enemy.class);

        // Configurar o mock com valores iniciais
        when(enemy.getActHP()).thenReturn(100);

        // Mockar o dano
        int damage = 30;

        // Chamar o método hurt no objeto mock Enemy
        enemy.hurt(damage);

        // Verificar se o método hurt foi chamado corretamente
        verify(enemy).hurt(damage);

        // Verificar se o método getActHP foi chamado corretamente após chamar o método hurt
        Assertions.assertEquals(70, enemy.getActHP());
    }

    @Test
    public void enemyDieTest() {
        // Criar um mock para Enemy
        Enemy enemy = mock(Enemy.class);

        // Configurar o mock com valores iniciais
        when(enemy.getActHP()).thenReturn(50);

        // Mockar o dano para exceder o atHP
        int damage = 60;

        // Chamar o método hurt no objeto mock Enemy
        enemy.hurt(damage);

        // Verificar se o método hurt foi chamado corretamente
        verify(enemy).hurt(damage);

        // Verificar se o método die é chamado quando actHP é <= 0
        verify(enemy).die();
    }
}
