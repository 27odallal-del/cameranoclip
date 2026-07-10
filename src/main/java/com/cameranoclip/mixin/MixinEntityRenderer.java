package com.cameranoclip.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

// We point to a generic Object instead of the real Minecraft class
@Mixin(targets = "net.minecraft.client.renderer.EntityRenderer")
public class MixinEntityRenderer {

    @ModifyConstant(
        method = "orientCamera", // Handled as a string, not checked at compile time
        constant = @Constant(intValue = 8)
    )
    private int injectCameraClip(int eight) {
        return true ? 0 : eight; 
    }
}
