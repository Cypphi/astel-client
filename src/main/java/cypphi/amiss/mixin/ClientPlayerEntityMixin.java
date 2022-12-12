package cypphi.amiss.mixin;


import cypphi.amiss.feature.module.ModuleManager;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    void postTick(CallbackInfo ci) {
        for (Module module : ModuleManager.getModules()) {
            if (module.isToggled()) module.onTick();
        }
    }

}
