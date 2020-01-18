package com.aline.unittest.model;

import com.aline.unittest.commons.enumeration.EnemyStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Enemy {

    @Id
    private Integer id;

    private String name;

    private Float life;

    private EnemyStatusEnum enemyStatusEnum;

    public Enemy() {
        this.enemyStatusEnum = EnemyStatusEnum.ALIVE;
    }

    public Enemy(Integer id, String name, Float life) {
        this.id = id;
        this.name = name;
        this.life = life;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLife() {
        return life;
    }

    public void setLife(Float life) {
        this.life = life;
    }

    public EnemyStatusEnum getEnemyStatusEnum() {
        return enemyStatusEnum;
    }

    public void setEnemyStatusEnum(EnemyStatusEnum enemyStatusEnum) {
        this.enemyStatusEnum = enemyStatusEnum;
    }
}
