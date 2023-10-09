package useless.patches.mixin;

import net.minecraft.client.render.ImageParser;
import net.minecraft.client.render.entity.PlayerRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = PlayerRenderer.class, remap = false)
public class PlayerRendererMixin {
	@Redirect(method = "renderSpecials(Lnet/minecraft/core/entity/player/EntityPlayer;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/PlayerRenderer;loadDownloadableTexture(Ljava/lang/String;Ljava/lang/String;Lnet/minecraft/client/render/ImageParser;)Z",ordinal = 0))
	private boolean customCape(PlayerRenderer instance, String url, String local, ImageParser imageParser){
		if (url.equals("https://api.betterthanadventure.net/capes?username=Useless7695))")){
			return true;
		}
		return instance.loadDownloadableTexture(url, local, imageParser);
	}
}
