package com.aline.unittest.service;

import com.aline.unittest.commons.enumeration.AttackTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class AttackService {

    public Float realDamage(AttackTypeEnum attackTypeEnum, Float baseDamage){
        if (this.missAttack()) {
            return 0F;
        }
        if (AttackTypeEnum.CRITICAL.equals(attackTypeEnum)){
            return baseDamage*2;
        }
        if (AttackTypeEnum.SPECIAL.equals(attackTypeEnum)) {
            return baseDamage*5;
        }
        return baseDamage;
    }

    private Boolean missAttack(){
        if (Math.random() == 0.0)
            return true;
        return false;
    }
}
