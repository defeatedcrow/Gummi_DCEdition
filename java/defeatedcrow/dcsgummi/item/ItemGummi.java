package defeatedcrow.dcsgummi.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGummi extends ItemFood {
	
	@SideOnly(Side.CLIENT)
    private IIcon[] iconType;
	
	
	public ItemGummi (int reco, int sat, boolean flag)
	{
		super (reco, sat, flag);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
        this.setAlwaysEdible();
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, iconType.length - 1);
        return this.iconType[j];
    }
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return super.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0 ; i < iconType.length ; i++)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		int i = par1ItemStack.getItemDamage();
	    return i == 7 ? EnumRarity.rare : EnumRarity.common;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
    {
		this.iconType = new IIcon[8];
		for (int i = 0 ; i < iconType.length ; i++)
		{
			this.iconType[i] = par1IconRegister.registerIcon("dcsgummi:" + this.getTextureName(i));
		}
    }
	
	@SideOnly(Side.CLIENT)
    //マウスオーバー時の表示情報
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		int l = par1ItemStack.getItemDamage();
		ArrayList<PotionEffect> effect = this.getFluitEffect(l);
		if (effect != null && !effect.isEmpty())
		{
			for (PotionEffect p : effect)
			{
				String s = StatCollector.translateToLocal(p.getEffectName()).trim();
				if (p.getAmplifier() > 0)
		        {
					if (p.getAmplifier() < 4){
						s = s + " " + StatCollector.translateToLocal("potion.potency." + p.getAmplifier()).trim();
					}
					else {
						s = s + " " + p.getAmplifier();
					}
		        }

		        if (p.getDuration() > 20)
		        {
		            s = s + " (" + Potion.getDurationString(p) + ")";
		        }
				
				par3List.add(s);
			}
		}
		
		if (getToolTip(l) != null)
		{
			par3List.add(getToolTip(l));
		}
	}
	
	@Override
	protected void onFoodEaten(ItemStack item, World world, EntityPlayer player)
    {
		if (item != null && item.getItem() == this)
		{
			int i = item.getItemDamage();
			i = MathHelper.clamp_int(0, i, iconType.length - 1);
			
			this.formEffect(world, player, i);
			
			if (this.getHealAmount(i) > 0){
				player.heal(this.getHealAmount(i));
			}
			
			List<PotionEffect> effects = this.getFluitEffect(i);
			if (effects == null || effects.isEmpty()) return;
			for (int k = 0 ; k <= i ; k++)
			{
				if (effects.size() > k) player.addPotionEffect(effects.get(k));
			}
			
		}
    }
	
	protected String getTextureName(int i)
	{
		switch(i)
		{
		case 0:
			return "AppleGummi";
		case 1:
			return "PeachGummi";
		case 2:
			return "GrapeGummi";
		case 3:
			return "PineappleGummi";
		case 4:
			return "OrangeGummi";
		case 5:
			return "MaguroGummi";
		case 6:
			return "MixGummi";
		case 7:
			return "MiracleGummi";
		default:
			return "AppleGummi";
		}
	}
	
	protected String getToolTip(int i)
	{
		switch(i)
		{
		case 0:
			return (String)null;
		case 1:
			return "Heal oxigen bar when underwater.";
		case 2:
			return "Remove bad potion effects.";
		case 3:
			return (String)null;
		case 4:
			return "Heal hungar status.";
		case 5:
			return (String)null;
		case 6:
			return "Remove bad potion effects.";
		case 7:
			return "Remove bad potion effects.";
		default:
			return (String)null;
		}
	}
	
	
	protected ArrayList<PotionEffect> getFluitEffect(int i) {
		ArrayList<PotionEffect> ret = new ArrayList<PotionEffect>();
		
		switch (i)
		{
		case 3:
			ret.add(new PotionEffect(Potion.regeneration.id, 600, 0));
			break;
		case 5:
			ret.add(new PotionEffect(Potion.regeneration.id, 200, 0));
			break;
		case 7:
			ret.add(new PotionEffect(Potion.regeneration.id, 1200, 0));
			ret.add(new PotionEffect(Potion.damageBoost.id, 3600, 0));
			ret.add(new PotionEffect(Potion.resistance.id, 3600, 0));
			ret.add(new PotionEffect(Potion.digSpeed.id, 3600, 0));
			ret.add(new PotionEffect(Potion.waterBreathing.id, 3600, 0));
			ret.add(new PotionEffect(Potion.field_76434_w.id, 3600, 0));
			break;
		default:
			break;
		}
		
		return ret;
	}
	
	private void formEffect(World world, EntityPlayer player, int meta)
	{
		if (meta == 1)
		{
			player.setAir(300);
		}
		else if (meta == 4)
		{
			player.getFoodStats().addStats(4, 1.0F);
			if (player.isPotionActive(Potion.hunger))
			{
				player.removePotionEffect(Potion.hunger.id);
			}
		}
		else if (meta == 2 || meta == 6 || meta == 7)
		{
			ArrayList<Integer> removeList = new ArrayList<Integer>();
			Iterator iterator = player.getActivePotionEffects().iterator();
			
			while (iterator.hasNext())
			{
				PotionEffect effect = (PotionEffect)iterator.next();
				int id = effect.getPotionID();
				Potion potion = Potion.potionTypes[id];
				if (potion != null && potion.isBadEffect())
				{
					removeList.add(id);
				}
			}
			
			for (Integer i : removeList)
			{
				player.removePotionEffect(i);
			}
		}
	}
	
	
	
	protected int getHealAmount(int i)
	{
		int[] amount = {6, 4, 4, 0, 4, 0, 5, 10};
		if (i < 8)
		{
			return amount[i];
		}
		else
		{
			return 6;
		}
	}

}
