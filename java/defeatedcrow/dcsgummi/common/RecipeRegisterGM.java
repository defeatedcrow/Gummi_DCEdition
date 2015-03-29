package defeatedcrow.dcsgummi.common;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeRegisterGM {
	
	private RecipeRegisterGM(){}
	
	public static void load()
	{
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsGummiCore.gummi, 1, 0),
	    		  new Object[]{
	    			  "foodSugar",
		    		  "slimeball",
		    		  "cropApple"
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsGummiCore.gummi, 1, 0),
	    		  new Object[]{
	    			  "foodSugar",
		    		  "slimeball",
		    		  Items.apple
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsGummiCore.gummi, 1, 1),
	    		  new Object[]{
	    			  "foodSugar",
		    		  "slimeball",
		    		  "cropPeach"
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsGummiCore.gummi, 1, 2),
	    		  new Object[]{
	    			  "foodSugar",
		    		  "slimeball",
		    		  "cropGrape"
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsGummiCore.gummi, 1, 3),
	    		  new Object[]{
	    			  "foodSugar",
		    		  "slimeball",
		    		  "cropPine"
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsGummiCore.gummi, 1, 4),
	    		  new Object[]{
	    			  "foodSugar",
		    		  "slimeball",
		    		  "cropOrange"
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsGummiCore.gummi, 1, 5),
	    		  new Object[]{
	    			  "foodSugar",
		    		  "slimeball",
		    		  Items.fish
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsGummiCore.gummi, 1, 6),
	    		  new Object[]{
	    			  "foodSugar",
		    		  "slimeball",
		    		  "cropApple",
		    		  "cropPeach",
		    		  "cropGrape",
		    		  "cropPine",
		    		  "cropOrange"
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsGummiCore.gummi, 1, 7),
	    		  new Object[]{
	    			  "foodSugar",
		    		  "slimeball",
		    		  "goldenPeach",
		    		  "goldenGrape",
		    		  "goldenPine",
		    		  "goldenOrange",
		    		  new ItemStack(Items.golden_apple, 1, 32767)
					 }));
		
		for (int i = 0 ; i < 4 ; i++)
		{
			Item[] fluits = {DCsGummiCore.peach, DCsGummiCore.grape, DCsGummiCore.pine, DCsGummiCore.orange};
			
			GameRegistry.addRecipe(
		 			new ItemStack(fluits[i], 1, 1),
		 			new Object[]{
		 					 "XXX",
		 					 "XYX",
		 					 "XXX",
		 					 'X', new ItemStack(Items.gold_nugget, 1),
		 					 'Y', new ItemStack(fluits[i], 1, 0)
		 			});
			
			GameRegistry.addRecipe(
		 			new ItemStack(fluits[i], 1, 2),
		 			new Object[]{
		 					 "XXX",
		 					 "XYX",
		 					 "XXX",
		 					 'X', new ItemStack(Items.gold_ingot, 1),
		 					 'Y', new ItemStack(fluits[i], 1, 0)
		 			});
			
			GameRegistry.addRecipe(
		 			new ItemStack(fluits[i], 1, 3),
		 			new Object[]{
		 					 "XXX",
		 					 "XYX",
		 					 "XXX",
		 					 'X', new ItemStack(Blocks.gold_block, 1),
		 					 'Y', new ItemStack(fluits[i], 1, 0)
		 			});
		}
		
		if (Loader.isModLoaded("DCsAppleMilk"))
		{
			addAMTIntegration();
		}
	}
	
	static void addAMTIntegration()
	{
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 6),
	    		  new Object[]{
	    			  "bottleRum",
		    		  "cropPine",
		    		  new ItemStack(Items.milk_bucket, 1),
		    		  "foodCrushedIce"
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 6),
	    		  new Object[]{
	    			  "bottleRum",
		    		  "cropPine",
		    		  "bucketMilk",
		    		  "foodCrushedIce"
					 }));
	}
}
