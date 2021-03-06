package com.aline.unittest.service;

import com.aline.unittest.commons.enumeration.EnemyStatusEnum;
import com.aline.unittest.model.Enemy;
import com.aline.unittest.model.Player;
import org.springframework.stereotype.Service;

@Service
public class EnemyService {

    public Enemy die(Enemy enemy) {
        enemy.setLife(0.0F);
        enemy.setEnemyStatusEnum(EnemyStatusEnum.DEAD);
        return enemy;
    }

    public void doNothing(Player player) {
        System.out.println("nothing");
    }
}
