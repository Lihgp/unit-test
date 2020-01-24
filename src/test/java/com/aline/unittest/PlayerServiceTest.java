package com.aline.unittest;

import com.aline.unittest.commons.enumeration.AttackTypeEnum;
import com.aline.unittest.commons.exceptions.DamageExceededException;
import com.aline.unittest.model.Player;
import com.aline.unittest.service.AttackService;
import com.aline.unittest.service.EnemyService;
import com.aline.unittest.service.PlayerService;
import org.junit.Test;
import org.mockito.Mockito;

public class PlayerServiceTest {

    private AttackService attackService = Mockito.mock(AttackService.class);

    private EnemyService enemyService = Mockito.mock(EnemyService.class);

    private PlayerService playerService = new PlayerService(attackService, enemyService);

    @Test
    public void getDamageTest() {
        
    }

    @Test(expected = DamageExceededException.class)
    public void getDamageTestWithException() {
        Player player = buildPlayer();
        Float baseDamage = 900.0F;

        Mockito.when(attackService.realDamage(AttackTypeEnum.CRITICAL, baseDamage)).thenThrow(DamageExceededException.class);

        playerService.getDamage(player, AttackTypeEnum.CRITICAL, baseDamage);

        Mockito.verify(attackService, Mockito.times(1)).realDamage(AttackTypeEnum.CRITICAL, baseDamage);

    }

    private Player buildPlayer(){
        return new Player(1, "playerMock", 1.50F, 10.0F);
    }

    //Test Argument Captor
    @Test
    public void createStrongClonePlayerTest() {
        // Esse player não é a mesma instância que é criada no método real
        Player player = new Player(1, "playerClone", 1.20F, 100.0F);

        playerService.createStrongClonePlayer(player);

        Mockito.verify(enemyService).doNothing(player);

    }
}
