package usermanager.bridge;

import modelo.Token;

public interface IPersistanceBridge {

    public byte[] save(String userId, String deviceId, String message);

    public Token recoverFromDigest(byte[] digest);

}
