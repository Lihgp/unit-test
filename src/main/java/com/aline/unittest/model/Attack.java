package com.aline.unittest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.aline.unittest.commons.enumeration.AttackTypeEnum;

@Entity
public class Attack {

    @Id
    private Integer id;

    private AttackTypeEnum attackTypeEnum;

    private Float baseDamage;

}
