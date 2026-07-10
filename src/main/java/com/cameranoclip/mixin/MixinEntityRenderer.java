package com.cameranoclip.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "net.minecraft.client.renderer.EntityRenderer")
public class MixinEntityRenderer {

    @ModifyConstant(
        // Maps both human name and official 1.8.9 obfuscated SRG method name
        method = {"orientCamera", "func_78467_g"}, 
        constant = @Constant(intValue = 8),
        remap = false // Prevents the engine from searching for a non-existent refMap file
    )
    private int injectCameraClip(int eight) {
        return true ? 0 : eight; 
    }
}
