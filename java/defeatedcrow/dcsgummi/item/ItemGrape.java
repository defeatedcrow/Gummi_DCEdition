package defeatedcrow.dcsgummi.item;

import java.util.ArrayList;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;

public class ItemGrape extends ItemFruitBase{

	public ItemGrape(int reco, int sat, boolean flag) {
		super(reco, sat, flag);
	}

	@Override
	protected String getTextureName(int i) {
		int m = MathHelper.clamp_int(0, i, 1);
		String[] name = {"Grape", "GoldenGrape"};
		return name[m];
	}

	@Override
	protected ArrayList<PotionEffect> getFluitEffect(int i) {
		ArrayList<PotionEffect> ret = new ArrayList<PotionEffect>();
		
		switch (i)
		{
		case 0:
			break;
		case 1:
			ret.add(new PotionEffect(Potion.regeneration.id, 100, 0));
			break;
		case 2:
			ret.add(new PotionEffect(Potion.regeneration.id, 240, 0));
			ret.add(new PotionEffect(Potion.damageBoost.id, 6000, 0));
			break;
		case 3:
			ret.add(new PotionEffect(Potion.regeneration.id, 600, 1));
			ret.add(new PotionEffect(Potion.damageBoost.id, 6000, 2));
			ret.add(new PotionEffect(Potion.field_76434_w.id, 6000, 1));
			break;
		default:
			ret.add(new PotionEffect(Potion.regeneration.id, 100, 0));
			break;
		}
		
		return ret;
	}

}
