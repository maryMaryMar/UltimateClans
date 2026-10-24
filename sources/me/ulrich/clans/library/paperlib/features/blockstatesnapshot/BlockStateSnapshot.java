package me.ulrich.clans.library.paperlib.features.blockstatesnapshot;

import org.bukkit.block.Block;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/blockstatesnapshot/BlockStateSnapshot.class */
public interface BlockStateSnapshot {
    BlockStateSnapshotResult getBlockState(Block block, boolean z);
}
