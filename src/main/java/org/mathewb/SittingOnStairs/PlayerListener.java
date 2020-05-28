package org.mathewb.SittingOnStairs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.ArrayList;

public class PlayerListener implements Listener {

    @EventHandler
    public void onItemClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();

        ArrayList<Material> stairs = new ArrayList<>();

        stairs.add(Material.STONE_STAIRS);
        stairs.add(Material.SANDSTONE_STAIRS);
        stairs.add(Material.SMOOTH_QUARTZ_STAIRS);
        stairs.add(Material.ACACIA_STAIRS);
        stairs.add(Material.ANDESITE_STAIRS);
        stairs.add(Material.SMOOTH_RED_SANDSTONE_STAIRS);
        stairs.add(Material.SPRUCE_STAIRS);
        stairs.add(Material.BIRCH_STAIRS);
        stairs.add(Material.BRICK_STAIRS);
        stairs.add(Material.COBBLESTONE_STAIRS);
        stairs.add(Material.DARK_OAK_STAIRS);
        stairs.add(Material.DARK_PRISMARINE_STAIRS);
        stairs.add(Material.END_STONE_BRICK_STAIRS);
        stairs.add(Material.DIORITE_STAIRS);
        stairs.add(Material.SMOOTH_SANDSTONE_STAIRS);
        stairs.add(Material.STONE_BRICK_STAIRS);
        stairs.add(Material.RED_NETHER_BRICK_STAIRS);
        stairs.add(Material.RED_SANDSTONE_STAIRS);
        stairs.add(Material.RED_SANDSTONE_STAIRS);

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && stairs.contains(e.getClickedBlock().getType())) {
            System.out.println("this worked");
            Bukkit.getLogger().info("this worked");

            Location location = e.getClickedBlock().getLocation();
            World world = player.getWorld();

            ArmorStand as = world.spawn(location.add(0.5, -1.225, 0.5), ArmorStand.class);

            as.setGravity(false);
            as.setCanPickupItems(false);
            as.setCustomNameVisible(false);
            as.setVisible(false);
            AttributeInstance healthAttribute = as.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            healthAttribute.setBaseValue(0);
            as.setPassenger(player);

        }
    }
        @EventHandler
        public void dismount(EntityDismountEvent e){

            if (!(e.getEntity() instanceof Player)) {
                return;
            }

            Player player = (Player) e.getEntity();

            Location location = player.getLocation().clone();
            location.setY(player.getLocation().getY()+2);

            if (player.teleport(location)){
                System.out.println("fag");

            }

        }
    }
