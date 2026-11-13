package net.mcreator.myherounleashed.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.myherounleashed.network.MyHeroUnleashedModVariables;

public class RollRandomQuirkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double RandomNum = 0;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 2);
		if (RandomNum == 1) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your Quirk manifested:" + (entity.getCapability(MyHeroUnleashedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MyHeroUnleashedModVariables.PlayerVariables())).PlayerQuirk)),
						false);
		} else if (RandomNum == 2) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your Quirk manifested:" + (entity.getCapability(MyHeroUnleashedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MyHeroUnleashedModVariables.PlayerVariables())).PlayerQuirk)),
						false);
		}
	}
}
