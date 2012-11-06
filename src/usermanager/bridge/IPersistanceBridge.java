package usermanager.bridge;

public interface IPersistanceBridge {
    
    public byte[] save(String userId, String deviceId, String message);
    
    public String recoverFromDigest(byte[] digest);

}
