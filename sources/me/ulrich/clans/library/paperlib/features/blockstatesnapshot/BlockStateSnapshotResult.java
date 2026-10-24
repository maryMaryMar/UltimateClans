package me.ulrich.clans.library.paperlib.features.blockstatesnapshot;

import org.bukkit.block.BlockState;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/blockstatesnapshot/BlockStateSnapshotResult.class */
public class BlockStateSnapshotResult {
    private final boolean isSnapshot;
    private final BlockState state;

    public BlockStateSnapshotResult(boolean z, BlockState blockState) {
        this.isSnapshot = z;
        this.state = blockState;
    }

    public boolean isSnapshot() {
        return this.isSnapshot;
    }

    public BlockState getState() {
        return this.state;
    }
}
