//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\maywr\Documents\remapping\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.ResourceLocation
 */
package wtf.cattyn.woo.api.util;

import java.io.InputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundUtil {
    public static final SoundUtil INSTANCE = new SoundUtil();
    public ResourceLocation woo = new ResourceLocation("audio/seal.wav");
    public ResourceLocation coinmaster = new ResourceLocation("audio/coinmaster.wav");
    public ResourceLocation goku = new ResourceLocation("audio/goku.wav");
    public ResourceLocation hs = new ResourceLocation("audio/hs.wav");
    public ResourceLocation kill9 = new ResourceLocation("audio/kill9.wav");
    public ResourceLocation kill10 = new ResourceLocation("audio/kill10.wav");
    public ResourceLocation kill11 = new ResourceLocation("audio/kill11.wav");
    public ResourceLocation metallic = new ResourceLocation("audio/metallic.wav");
    public ResourceLocation mission = new ResourceLocation("audio/mission.wav");
    public ResourceLocation neverlose = new ResourceLocation("audio/neverlose.wav");
    public ResourceLocation saynndog = new ResourceLocation("audio/sitnndog.wav");
    public ResourceLocation ya = new ResourceLocation("audio/ya.wav");
    public ResourceLocation hitsound = new ResourceLocation("audio/hitsoundlol.wav");

    public static void playSound(ResourceLocation rl) {
        try {
            InputStream sound = Minecraft.getMinecraft().getResourceManager().getResource(rl).getInputStream();
            AudioStream as = new AudioStream(sound);
            AudioPlayer.player.start(as);
            return;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

