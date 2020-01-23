package com.aline.unittest.model;

import com.aline.unittest.commons.enumeration.PlayerStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player{

    @Id
    private Integer id;
    private String name;
    private Float life;
    private Float size;
    private Float velocity;
    private PlayerStatusEnum playerStatusEnum;

    public Player() {
        this.playerStatusEnum = PlayerStatusEnum.ALIVE;
        this.life = 500F;
    }

    public Player(Integer id, String name, Float size, Float velocity) {
        this.id = id;
        this.name = name;
        this.life = 500F;
        this.size = size;
        this.velocity = velocity;
        this.playerStatusEnum = PlayerStatusEnum.ALIVE;
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

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Float getVelocity() {
        return velocity;
    }

    public void setVelocity(Float velocity) {
        this.velocity = velocity;
    }

    public PlayerStatusEnum getPlayerStatusEnum() {
        return playerStatusEnum;
    }

    public void setPlayerStatusEnum(PlayerStatusEnum playerStatusEnum) {
        this.playerStatusEnum = playerStatusEnum;
    }
}
