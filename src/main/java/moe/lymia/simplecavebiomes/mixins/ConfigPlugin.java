package moe.lymia.simplecavebiomes.mixins;

import net.minecraftforge.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class ConfigPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        switch (mixinClassName) {
            case "moe.lymia.cavebiomescompat.mixins.BiomeColorsMixin":
                return LoadingModList.get().getModFileById("embeddium") != null;
            case "moe.lymia.cavebiomescompat.mixins.OTGBiomeProviderHook":
            case "moe.lymia.cavebiomescompat.mixins.OTGChunkGeneratorHook":
                return LoadingModList.get().getModFileById("otg") != null;
            default:
                throw new RuntimeException("unknown mixin: " + mixinClassName);
        }
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }
}