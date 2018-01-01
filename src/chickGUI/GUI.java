package chickGUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI implements Listener , CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args){
		if(cmd.getName().equalsIgnoreCase("GUI")){
			if(!(sender instanceof Player)){
				return true;
			}
			Player player = (Player) sender;
			openGUI(player);
			
			
			return true;
		}
		return true;
	}
	
	public static void openGUI(Player player){
		Inventory  inv = Bukkit.createInventory(null,9,"測試GUI");
		ItemStack gamemode = new ItemStack(Material.CHEST);
		ItemMeta gamemeta = gamemode.getItemMeta();
		gamemeta.setDisplayName("測試物品");
		ArrayList<String> sLore = new ArrayList<String>();
		sLore.add("Lore1");
		sLore.add("Lore2");
		gamemeta.setLore(sLore);
		gamemode.setItemMeta(gamemeta);
		
		inv.setItem(2, gamemode);
		player.openInventory(inv);
		player.playSound(player.getLocation(), Sound.EXPLODE , 10, 1);
		
	}

	@EventHandler
	public void onClick(InventoryClickEvent ic){
		if(ic.getWhoClicked() instanceof Player){
			
			Player player = (Player) ic.getWhoClicked();
			
			ItemStack item =ic.getCurrentItem();
			if(ic.getClick().equals(ClickType.LEFT))
			if(item.hasItemMeta()){
				if(ic.getRawSlot() == 2){
					player.sendMessage("test");
					ic.getWhoClicked().closeInventory();
					
				}
			}
			
		}
		
	}
	
}
