package defeatedcrow.dcsgummi.common;

import java.io.IOException;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.dcsgummi.item.*;

@Mod(
		modid = "DCsGummi",
		name = "Gummi_DCEdition",
		version = "1.7.10_1.0c",
		dependencies = "required-after:Forge@[10.13.2.1230,);after:DCsAppleMilk"
		)
public class DCsGummiCore {
	
	@SidedProxy(clientSide = "defeatedcrow.dcsgummi.client.ClientProxyGM", serverSide = "defeatedcrow.dcsgummi.common.CommonProxyGM")
	public static CommonProxyGM proxy;
	
	//インスタンスの生成
	@Instance("DCsGummi")
    public static DCsGummiCore instance;
	
	public static Item grape;
	public static Item peach;
	public static Item pine;
	public static Item orange;
	public static Item gummi;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		peach = new ItemPeach(3, 1, false)
        .setCreativeTab(CreativeTabs.tabFood)
		.setUnlocalizedName("dcsgummi.peach");
		GameRegistry.registerItem(peach, "dcsgummi.peach");
		
		grape = new ItemGrape(3, 1, false)
		.setCreativeTab(CreativeTabs.tabFood)
		.setUnlocalizedName("dcsgummi.grape");
		GameRegistry.registerItem(grape, "dcsgummi.grape");
		
		pine = new ItemPine(3, 1, false)
        .setCreativeTab(CreativeTabs.tabFood)
		.setUnlocalizedName("dcsgummi.pine");
		GameRegistry.registerItem(pine, "dcsgummi.pine");
		
		orange = new ItemOrange(3, 1, false)
        .setCreativeTab(CreativeTabs.tabFood)
		.setUnlocalizedName("dcsgummi.orange");
		GameRegistry.registerItem(orange, "dcsgummi.orange");
		
		gummi = new ItemGummi(0, 0, false)
        .setCreativeTab(CreativeTabs.tabFood)
		.setUnlocalizedName("dcsgummi.gummi");
		GameRegistry.registerItem(gummi, "dcsgummi.gummi");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		OreDictionary.registerOre("cropPeach", new ItemStack(peach, 1, 0));
		OreDictionary.registerOre("cropGrape", new ItemStack(grape, 1, 0));
		OreDictionary.registerOre("cropPine", new ItemStack(pine, 1, 0));
		OreDictionary.registerOre("cropPineapple", new ItemStack(pine, 1, 0));
		OreDictionary.registerOre("cropOrange", new ItemStack(orange, 1, 0));
		
		OreDictionary.registerOre("cropApple", new ItemStack(Items.apple, 1, 0));
		OreDictionary.registerOre("foodSugar", new ItemStack(Items.sugar, 1, 0));
		
		for (int i = 1 ; i < 4 ; i++)
		{
			OreDictionary.registerOre("goldenPeach", new ItemStack(peach, 1, i));
			OreDictionary.registerOre("goldenGrape", new ItemStack(grape, 1, i));
			OreDictionary.registerOre("goldenPine", new ItemStack(pine, 1, i));
			OreDictionary.registerOre("goldenPineapple", new ItemStack(pine, 1, i));
			OreDictionary.registerOre("goldenOrange", new ItemStack(orange, 1, i));
		}
		
		RecipeRegisterGM.load();
		
		MinecraftForge.EVENT_BUS.register(new LeavesDecayEvent());
	}
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event)
	{
		
	}

}
