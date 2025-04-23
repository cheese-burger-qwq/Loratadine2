package shop.xmz.lol.loratadine.modules.impl.combat;

import cn.lzq.injection.leaked.invoked.AttackEvent;
import cn.lzq.injection.leaked.invoked.LivingUpdateEvent;
import net.minecraft.world.entity.Entity;
import shop.xmz.lol.loratadine.event.annotations.EventTarget;
import shop.xmz.lol.loratadine.modules.Category;
import shop.xmz.lol.loratadine.modules.Module;
import shop.xmz.lol.loratadine.modules.setting.impl.BooleanSetting;
import shop.xmz.lol.loratadine.utils.player.MoveUtils;
import shop.xmz.lol.loratadine.utils.wrapper.WrapperUtils;

public class SuperKnockBack extends Module {
    public static boolean sprint = true;
    Entity target;
    private final BooleanSetting onlyMoveValue = new BooleanSetting("OnlyMove",this,true);
    private final BooleanSetting onlyGroundValue = new BooleanSetting("OnlyGround",this,false);

    public SuperKnockBack() {
        super("SuperKnockBack", "超级击退" ,Category.COMBAT);
        setEnabled(true);
    }

    @Override
    public void onDisable() {
        sprint = true;
    }

    @Override
    public void onEnable() {
        sprint = true;
    }

    @EventTarget
    public void onAttack(AttackEvent event) {
        if (mc.player == null || mc.level == null) return;

        if (!MoveUtils.isMoving() && onlyMoveValue.getValue() || !mc.player.onGround() && onlyGroundValue.getValue())
            return;

        target = event.getTarget();

        if (KillAura.target == null || target == null) sprint = true;

        if (mc.player.zza > 0 && WrapperUtils.getWasSprinting() == mc.player.isSprinting())
            sprint = !WrapperUtils.getWasSprinting();
    }

    @EventTarget
    public void onUpdate(LivingUpdateEvent event) {
        if (KillAura.target == null || target == null) sprint = true;
        this.setSuffix("Legit");
    }
}
