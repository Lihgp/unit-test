package com.aline.unittest;

import com.aline.unittest.service.AttackService;
import com.aline.unittest.service.EnemyService;
import com.aline.unittest.service.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    private AttackService attackService = Mockito.mock(AttackService.class);

    private EnemyService enemyService = Mockito.mock(EnemyService.class);

    private PlayerService playerService = new PlayerService(attackService, enemyService);

    @Test
    public void
}
