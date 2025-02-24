package errorcraft.entitymodifiers.entity.modifier;

import errorcraft.entitymodifiers.entity.modifier.modifiers.*;
import errorcraft.entitymodifiers.mixin.registry.RegistryAccessor;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonSerializing;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class EntityModifierTypes {
	public static final RegistryKey<Registry<EntityModifierType>> ENTITY_MODIFIER_TYPE_KEY = RegistryAccessor.createRegistryKey("entity_modifier_type");
	public static final Registry<EntityModifierType> ENTITY_MODIFIER_TYPE = RegistryAccessor.create(ENTITY_MODIFIER_TYPE_KEY, () -> EntityModifierTypes.SET_INVULNERABLE);

	public static final EntityModifierType SET_INVULNERABLE = register("set_invulnerable", new SetInvulnerableEntityModifier.Serialiser());
	public static final EntityModifierType SET_HEALTH = register("set_health", new SetHealthEntityModifier.Serialiser());
	public static final EntityModifierType SET_HUNGER = register("set_hunger", new SetHungerEntityModifier.Serialiser());
	public static final EntityModifierType SET_AIR_TIME = register("set_air_time", new SetAirTimeEntityModifier.Serialiser());
	public static final EntityModifierType SET_FIRE_TIME = register("set_fire_time", new SetFireTimeEntityModifier.Serialiser());
	public static final EntityModifierType SET_CUSTOM_NAME = register("set_custom_name", new SetCustomNameEntityModifier.Serialiser());
	public static final EntityModifierType SET_ABSORPTION = register("set_absorption", new SetAbsorptionEntityModifier.Serialiser());
	public static final EntityModifierType SET_SHOW_ARMS = register("set_show_arms", new SetShowArmsEntityModifier.Serialiser());
	public static final EntityModifierType SET_POSITION = register("set_position", new SetPositionEntityModifier.Serialiser());

	public static Object createGsonAdapter() {
		return JsonSerializing.createSerializerBuilder(ENTITY_MODIFIER_TYPE, "function", "function", EntityModifier::getType).build();
	}

	private static EntityModifierType register(String id, EntityModifier.Serialiser<? extends EntityModifier> serialiser) {
		return Registry.register(ENTITY_MODIFIER_TYPE, new Identifier(id), new EntityModifierType(serialiser));
	}
}
