package net.mcreator.myherounleashed.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.myherounleashed.network.MyHeroUnleashedModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnJoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(MyHeroUnleashedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MyHeroUnleashedModVariables.PlayerVariables())).Game_Start != false) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Test"), false);
			{
				boolean _setval = false;
				entity.getCapability(MyHeroUnleashedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Game_Start = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
