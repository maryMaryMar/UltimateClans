package me.ulrich.clans.library.paperlib.features.blockstatesnapshot;

import org.bukkit.block.Block;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/blockstatesnapshot/BlockStateSnapshotNoOption.class */
public class BlockStateSnapshotNoOption implements BlockStateSnapshot {
    @Override // me.ulrich.clans.library.paperlib.features.blockstatesnapshot.BlockStateSnapshot
    public BlockStateSnapshotResult getBlockState(Block block, boolean z) {
        return new BlockStateSnapshotResult(true, block.getState());
    }
}
