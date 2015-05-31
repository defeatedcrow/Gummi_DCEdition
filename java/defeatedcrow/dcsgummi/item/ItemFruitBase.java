package defeatedcrow.dcsgummi.item;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

public abstract class ItemFruitBase extends ItemFood {
	
	@SideOnly(Side.CLIENT)
    protected IIcon[] iconType;
	
	
	public ItemFruitBase (int reco, int sat, boolean flag)
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
        int j = MathHelper.clamp_int(par1, 0, 1);
        return this.iconType[j];
    }
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return super.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(this, 1, 0));
		par3List.add(new ItemStack(this, 1, 1));
		par3List.add(new ItemStack(this, 1, 2));
		par3List.add(new ItemStack(this, 1, 3));
	}
	
	//文字色
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		int i = par1ItemStack.getItemDamage();
	    return i == 3 ? EnumRarity.rare : (i == 2 ? EnumRarity.uncommon : EnumRarity.common);
	}
		
	@SideOnly(Side.CLIENT)
	//エフェクト
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return par1ItemStack.getItemDamage() == 3;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
    {
		this.iconType = new IIcon[2];
        this.iconType[0] = par1IconRegister.registerIcon("dcsgummi:" + this.getTextureName(0));
        this.iconType[1] = par1IconRegister.registerIcon("dcsgummi:" + this.getTextureName(1));
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
	}
	
	@Override
	protected void onFoodEaten(ItemStack item, World world, EntityPlayer player)
    {
		if (item != null && item.getItem() == this)
		{
			int i = item.getItemDamage();
			i = MathHelper.clamp_int(0, i, 3);
			
			List<PotionEffect> effects = this.getFluitEffect(i);
			if (effects == null || effects.isEmpty()) return;
			for (int k = 0 ; k <= i ; k++)
			{
				if (effects.size() > k) player.addPotionEffect(effects.get(k));
			}
			
		}
    }
	
	protected abstract String getTextureName(int i);
	
	protected abstract ArrayList<PotionEffect> getFluitEffect(int i);
	
}
