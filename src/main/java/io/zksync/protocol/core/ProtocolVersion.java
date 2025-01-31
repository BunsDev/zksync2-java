package io.zksync.protocol.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.web3j.protocol.core.Response;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProtocolVersion {
    /** Protocol version ID. */
    private int versionId;

    /** Unix timestamp of the version's activation. */
    private long timestamp;

    /** Contains the hashes of various verification keys used in the protocol. */
    private VerificationKeysHashes verificationKeysHashes;

    /** Addresses of the base system contracts. */
    private BaseSystemContracts baseSystemContracts;

    /** Hash of the transaction used for the system upgrade, if any. */
    private String l2SystemUpgradeTxHash;
}

