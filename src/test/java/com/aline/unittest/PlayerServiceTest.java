package com.aline.unittest;

import com.aline.unittest.commons.enumeration.AttackTypeEnum;
import com.aline.unittest.commons.exceptions.DeadPlayerException;
import com.aline.unittest.model.Player;
import com.aline.unittest.service.AttackService;
import com.aline.unittest.service.EnemyService;
import com.aline.unittest.service.PlayerService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class PlayerServiceTest {

    private AttackService attackService = Mockito.mock(AttackService.class);

    private EnemyService enemyService = Mockito.mock(EnemyService.class);

    private PlayerService playerService = new PlayerService(attackService, enemyService);

    //Test for WHEN/VERIFY/ARGUMENT MATCHERS
    @Test
    public void getDamageTest() {
        Float baseDamage = 100.0F;

        Mockito.when(attackService.realDamage(AttackTypeEnum.CRITICAL, baseDamage)).thenReturn(120.0F);


        playerService.getDamage(buildPlayer(), AttackTypeEnum.CRITICAL, baseDamage);

        Mockito.verify(attackService, Mockito.times(1)).realDamage(AttackTypeEnum.CRITICAL, baseDamage);
    }

    private Player buildPlayer(){
        return new Player(1, "playerMock", 1.50F, 10.0F);
    }

    @Test(expected = DeadPlayerException.class)
    public void getStrongerTest() {
        Player player = new Player(1, "playerMock", 1.50F, 10.0F);
        player.setLife(0.0F);
    }

    @Test
    public void testAssertTrue() {
        List<String> list = Arrays.asList("abc", "def", "ghi");
        Assert.assertTrue(list.contains("abc") && list.contains("xyz"));
    }

    @Test
    public void testAssertThat() {
        List<String> list = Arrays.asList("abc", "def", "ghi");
        Assert.assertThat("abc", CoreMatchers.is("def"));
    }

    @Test
    public void testAssertEquals() {
        List<String> list = Arrays.asList("abc", "def", "ghi");
        Assert.assertEquals("abc", 123);
    }


    // Usando Argument Captor
//    @Test
//    public void createClonePlayer() {
//        // Esse player não é a mesma instância que é criada no método real
//        Player player = new Player(1123, "playerClone", 1.20F, 100.0F);
//
//        playerService.createStrongClonePlayer(player);
//
//        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
//        Mockito.verify(enemyService).doNothing(playerArgumentCaptor.capture());
//
//        Player playerResponse = playerArgumentCaptor.getValue();
//
//        Assert.assertThat(playerResponse.getId(), CoreMatchers.is(11223));
//
//    }
//
//    @Test
//    public void test() {
//        Assert.assertTrue(true);
//        Assert.assertFalse(false);
//
//        Player player = new Player(1,"player", 1F, 1F);
//        Player player2 = new Player(1,"player", 1F, 1F);
//        Assert.assertEquals(player, CoreMatchers.equalToObject(player2));
//
//    }
//
//    @Test
//    public void assertThatAndEqualsTest() {
//        List<Integer> lista = new ArrayList<>();
//        lista.add(5);
//        lista.add(3);
//        lista.add(2);
//        lista.add(7);
//
////        Assert.assertTrue(responseString.contains("color") || responseString.contains("colour"));
//    }
}
