package com.settingdust.enchantmentplus;


import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:SettingDust
 * Date:16-7-2
 * ByIntelliJIDEA
 */
public class EnchantmentsManager {
    Map<String, Enchantment> enchantmentHashMap = new HashMap<String, Enchantment>();

    public EnchantmentsManager() {
        enchantmentHashMap.put("力量", Enchantment.ARROW_DAMAGE);
        enchantmentHashMap.put("火矢", Enchantment.ARROW_FIRE);
        enchantmentHashMap.put("无限", Enchantment.ARROW_INFINITE);
        enchantmentHashMap.put("保护", Enchantment.PROTECTION_ENVIRONMENTAL);
        enchantmentHashMap.put("火焰保护", Enchantment.PROTECTION_FIRE);
        enchantmentHashMap.put("摔落保护", Enchantment.PROTECTION_FALL);
        enchantmentHashMap.put("爆炸保护", Enchantment.PROTECTION_EXPLOSIONS);
        enchantmentHashMap.put("弹射物保护", Enchantment.PROTECTION_PROJECTILE);
        enchantmentHashMap.put("水下呼吸", Enchantment.OXYGEN);
        enchantmentHashMap.put("水下速掘", Enchantment.WATER_WORKER);
        enchantmentHashMap.put("荆棘", Enchantment.THORNS);
        enchantmentHashMap.put("深海探索者", Enchantment.DEPTH_STRIDER);
        enchantmentHashMap.put("锋利", Enchantment.DAMAGE_ALL);
        enchantmentHashMap.put("亡灵杀手", Enchantment.DAMAGE_UNDEAD);
        enchantmentHashMap.put("节肢杀手", Enchantment.DAMAGE_ARTHROPODS);
        enchantmentHashMap.put("击退", Enchantment.KNOCKBACK);
        enchantmentHashMap.put("火焰附加", Enchantment.FIRE_ASPECT);
        enchantmentHashMap.put("抢夺", Enchantment.LOOT_BONUS_MOBS);
        enchantmentHashMap.put("效率", Enchantment.DIG_SPEED);
        enchantmentHashMap.put("精准采集", Enchantment.SILK_TOUCH);
        enchantmentHashMap.put("耐久", Enchantment.DURABILITY);
        enchantmentHashMap.put("时运", Enchantment.LOOT_BONUS_BLOCKS);
        enchantmentHashMap.put("海之眷顾", Enchantment.LUCK);
        enchantmentHashMap.put("饵钓", Enchantment.LURE);
    }
}
