/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.Packet
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package wtf.cattyn.woo.mixin.mixins;

import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import wtf.cattyn.woo.api.event.PacketEvent;

@Mixin(value={NetworkManager.class})
public class MixinNetworkManager {
    @Inject(method={"channelRead0"}, at={@At(value="HEAD")}, cancellable=true)
    public void onPacketReceive(ChannelHandlerContext context, Packet<?> packet, CallbackInfo ci) {
        PacketEvent.Receive event = new PacketEvent.Receive(packet);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (!event.isCanceled()) return;
        ci.cancel();
    }

    @Inject(method={"sendPacket(Lnet/minecraft/network/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    public void onPacketSend(Packet<?> packet, CallbackInfo ci) {
        PacketEvent.Send event = new PacketEvent.Send(packet);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (!event.isCanceled()) return;
        ci.cancel();
    }
}

