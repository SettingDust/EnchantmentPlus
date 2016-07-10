package com.settingdust.enchantmentplus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Author: SettingDust
 * Date: 16-7-1
 * By IntelliJ IDEA
 */
public class EnchantmentPlus extends JavaPlugin {
    public FileConfiguration config = null;
    public EnchantmentsManager enchantmentsManager = null;

    @Override
    public void onEnable() {
        this.enchantmentsManager = new EnchantmentsManager();
        this.getCommand("enplus").setExecutor(this);
    }

    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("enplus")) {

            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "只有玩家才能使用此命令!");
            }
            Player player = (Player) sender;
            ItemStack item = player.getItemInHand();
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "缺少强化类型!");
            } else if (args.length == 1) {
                player.sendMessage(ChatColor.RED + "缺少强化等级!");
            } else if (!args[1].matches("\\d+")) {
                player.sendMessage(ChatColor.RED + "强化等级错误!");
            } else if (!enchantmentsManager.enchantmentHashMap.containsKey(args[0])) {
                player.sendMessage(ChatColor.RED + "强化类型错误!");
            } else if (item == null &&
                    item.getType().equals(Material.AIR)) {
                player.sendMessage(ChatColor.RED + "请拿着需要强化的物品!");
            } else {
                Enchantment enchantment = enchantmentsManager.enchantmentHashMap.get(args[0]);
                if (!enchantment.canEnchantItem(item)) {
                    player.sendMessage(ChatColor.RED + "本物品不可强化" + args[0] + "!");
                } else {
                    if (item.containsEnchantment(enchantment)) {
                        int level = item.getEnchantmentLevel(enchantment);

                        if (level + Integer.parseInt(args[1]) > 150) {
                            player.sendMessage(ChatColor.RED + "此物品已达到可强化最高等级!");
                        } else {
                            item.removeEnchantment(enchantment);
                            item.addUnsafeEnchantment(enchantment, level + Integer.parseInt(args[1]));
                            player.sendMessage(ChatColor.GREEN + "强化" + args[0] + (level + Integer.parseInt(args[1])) + "已成功!");
                        }
                    } else {
                        if (Integer.parseInt(args[1]) > 150) {
                            player.sendMessage(ChatColor.RED + "此物品已达到可强化最高等级!");
                        } else {
                            item.addUnsafeEnchantment(enchantment, Integer.parseInt(args[1]));
                            player.sendMessage(ChatColor.GREEN + "强化" + args[0] + args[1] + "已成功!");
                        }
                    }
                }
            }
        }

        return false;
    }
}
