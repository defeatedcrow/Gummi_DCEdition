package defeatedcrow.dcsgummi.client;

import cpw.mods.fml.client.FMLClientHandler;
import defeatedcrow.dcsgummi.common.CommonProxyGM;
import net.minecraft.world.World;

public class ClientProxyGM extends CommonProxyGM{
	
	@Override
	public World getClientWorld()
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}

}
