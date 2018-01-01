package chickGUI;


import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin{
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new GUI(),this);
		this.getCommand("GUI").setExecutor((CommandExecutor) new GUI());
	}
	
	public void onDisable(){
		 
	}
	
	 

}
