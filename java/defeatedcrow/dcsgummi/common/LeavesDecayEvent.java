package defeatedcrow.dcsgummi.common;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LeavesDecayEvent {
	
	@SubscribeEvent
	public void DecayEvent(BlockEvent.HarvestDropsEvent event)
	{
		ItemStack added = (ItemStack)null;
		Block block = event.block;
		int meta = event.blockMetadata;
		boolean chance = event.world.rand.nextInt(20) == 0;
		boolean golden = event.world.rand.nextInt(20) == 0;
		
		if (block == Blocks.leaves && chance)
		{
			int m = meta & 3;
			int g = golden ? 1 : 0;
			
			switch (m)
			{
			case 1:
				added = new ItemStack(DCsGummiCore.grape, 1, g);
				break;
			case 2:
				added = new ItemStack(DCsGummiCore.peach, 1, g);
				break;
			case 3:
				added = new ItemStack(DCsGummiCore.pine, 1, g);
				break;
			default:
				break;
			}
			
			if (added != null)
			{
				event.drops.add(added);
				event.setResult(Result.ALLOW);
			}
		}
		else if (block == Blocks.leaves2 && event.world.rand.nextInt(20) == 0)
		{
			int m = meta & 3;
			int g = golden ? 1 : 0;
			
			switch (m)
			{
			case 1:
				added = new ItemStack(DCsGummiCore.orange, 1, g);
				break;
			default:
				break;
			}
			
			if (added != null)
			{
				event.drops.add(added);
				event.setResult(Result.ALLOW);
			}
		}
	}

}
