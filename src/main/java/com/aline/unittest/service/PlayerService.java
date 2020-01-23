package com.aline.unittest.service;

import com.aline.unittest.commons.enumeration.PlayerStatusEnum;
import com.aline.unittest.commons.exceptions.DamageExceededException;
import com.aline.unittest.commons.exceptions.DeadPlayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aline.unittest.commons.enumeration.AttackTypeEnum;
import com.aline.unittest.model.Player;
import com.aline.unittest.model.Enemy;

@Service
public class PlayerService {

    private AttackService attackService;

    private EnemyService enemyService;

    @Autowired
    public PlayerService(AttackService attackService, EnemyService enemyService) {
        this.attackService = attackService;
        this.enemyService = enemyService;
    }

    public Player getDamage(Player player, AttackTypeEnum attackType, Float baseDamage) {
        Float realDamage = attackService.realDamage(attackType, baseDamage);

        if (player.getLife() < realDamage)
            return die(player);

        player.setLife(player.getLife() - realDamage);

        if (player.getLife() < 250F)
            player.setPlayerStatusEnum(PlayerStatusEnum.WEAK);

        return player;
    }

    public Enemy giveDamage(Enemy enemy, AttackTypeEnum attackType, Float baseDamage) {
        Float realDamage = attackService.realDamage(attackType, baseDamage);

        if (enemy.getLife() < realDamage)
            return enemyService.die(enemy);

        enemy.setLife(enemy.getLife() - realDamage);
        return enemy;
    }

    public Player getStronger(Player player) {
        if (player.getLife() == 0.0F)
            throw new DeadPlayerException("The player is dead.");
        player.setLife(player.getLife() + 100F);
        player.setPlayerStatusEnum(PlayerStatusEnum.STRONG);
        return player;
    }

    public Player die(Player player) {
        setStatusDie(player);
        return player;
    }

    public void setStatusDie(Player player) {
        player.setLife(0.0F);
        player.setPlayerStatusEnum(PlayerStatusEnum.DEAD);
    }

//
//    public Player createClonePlayer(Player player){
//
//    }

    // Método para mostrar o uso do Argument Captor do Mockito
    public void createStrongClonePlayer(Player player) {
        Player playerClone = new Player(player.getId(), "playerClone", player.getSize(), player.getVelocity());

        enemyService.doNothing(playerClone);
    }
}

