package com.cameranoclip.mixin;

import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer {

    @ModifyConstant(
        method = {"orientCamera"},
        constant = {@Constant(intValue = 8)}
    )
    private int injectCameraClip(int eight) {
        // True forces 0, permanently disabling the 8-block wall check
        return true ? 0 : eight; 
    }
}
