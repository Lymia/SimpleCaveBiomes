package moe.lymia.simplecavebiomes.mixins;

import net.minecraftforge.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class ConfigPlugin implements IMixinConfigPlugin {
    private boolean hasNaturesCompass;

    private static boolean hasMod(String id) {
        return LoadingModList.get().getModFileById(id) != null;
    }

    @Override
    public void onLoad(String s) {
        hasNaturesCompass = hasMod("naturescompass");
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String s, String s1) {
        switch (s1) {
            case "moe.lymia.simplecavebiomes.mixins.compat.NaturesCompassCompat":
                return hasNaturesCompass;
            default:
                return true;
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
