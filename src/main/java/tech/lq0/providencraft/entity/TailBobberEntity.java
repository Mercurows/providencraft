package tech.lq0.providencraft.entity;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.fml.network.FMLPlayMessages;

import java.util.Collections;
import java.util.List;

public class TailBobberEntity extends FishingBobberEntity {
    public TailBobberEntity(FMLPlayMessages.SpawnEntity spawnPacket, World world){
        super(world.getPlayerByUuid(spawnPacket.getAdditionalData().readUniqueId()), world, 0, 0);
    }

    public TailBobberEntity(PlayerEntity player, World world, int luck, int lureSpeed) {
        super(player, world, luck, lureSpeed);
    }

    @Override
    public int handleHookRetraction(ItemStack stack) {
        PlayerEntity player = this.func_234606_i_();
        if (!this.world.isRemote && player != null) {
            int rodDamage = 0;
            ItemFishedEvent event = null;
            if (this.caughtEntity != null) {
                this.bringInHookedEntity();
                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayerEntity) player, stack, this, Collections.emptyList());
                this.world.setEntityState(this, (byte) 31);
                rodDamage = this.caughtEntity instanceof ItemEntity ? 3 : 5;
            } else if ((this.ticksCatchable > 0) && this.world instanceof ServerWorld) {
                ServerWorld serverWorld = (ServerWorld) this.world;
                LootContext.Builder builder = new LootContext.Builder(serverWorld).withParameter(LootParameters.field_237457_g_, this.getPositionVec()).withParameter(LootParameters.TOOL, stack).withRandom(this.rand).withLuck(player.getLuck());
                builder.withParameter(LootParameters.KILLER_ENTITY, player).withParameter(LootParameters.THIS_ENTITY, this);

                List<ItemStack> lootEntries = getLoot(builder, serverWorld);
                if (!lootEntries.isEmpty()) {
                    event = new ItemFishedEvent(lootEntries, this.onGround ? 2 : 1, this);
                    MinecraftForge.EVENT_BUS.post(event);
                    if (event.isCanceled()) {
                        this.remove();
                        return event.getRodDamage();
                    }
                    CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayerEntity) player, stack, this, lootEntries);

                    this.spawnLoot(player, lootEntries);
                    rodDamage = 1;
                }
            }
            if (this.onGround) {
                rodDamage = 2;
            }
            this.remove();
            return event == null ? rodDamage : event.getRodDamage();
        } else {
            return 0;
        }
    }

    private List<ItemStack> getLoot(LootContext.Builder builder, ServerWorld serverWorld) {
        ResourceLocation lootTableLocation = LootTables.GAMEPLAY_FISHING;
        LootTable lootTable = serverWorld.getServer().getLootTableManager().getLootTableFromLocation(lootTableLocation);
        return lootTable.generate(builder.build(LootParameterSets.FISHING));
    }

    private void spawnLoot(PlayerEntity player, List<ItemStack> lootEntries) {
        for (ItemStack loot : lootEntries) {
            ItemEntity lootEntity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), loot);
            double x = player.getPosX() - this.getPosX();
            double y = player.getPosY() - this.getPosY();
            double z = player.getPosZ() - this.getPosZ();
            lootEntity.setMotion(x * 0.1D, (y * 0.1D + Math.sqrt(Math.sqrt(x * x + y * y + z * z)) * 0.08D), z * 0.1D);
            this.world.addEntity(lootEntity);
            player.world.addEntity(new ExperienceOrbEntity(player.world, player.getPosX(), player.getPosY() + 0.5D, player.getPosZ() + 0.5D, this.rand.nextInt(6) + 1));
            if (loot.getItem().isIn(ItemTags.FISHES)) {
                player.addStat(Stats.FISH_CAUGHT, 1);
            }
        }
    }

    public IPacket<?> createSpawnPacket() {
        Entity entity = this.func_234616_v_();
        return new SSpawnObjectPacket(this, entity == null ? this.getEntityId() : entity.getEntityId());
    }
}
