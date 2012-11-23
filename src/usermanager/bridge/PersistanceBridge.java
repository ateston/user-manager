package usermanager.bridge;

import modelo.Local;
import modelo.Persistencia;
import modelo.Token;

public class PersistanceBridge implements IPersistanceBridge {

    private Persistencia persistencia = new Persistencia(new Local());

    public byte[] save(String userId, String deviceId, String message) {
        return persistencia.Guardar(userId, deviceId, message);
    }

    public Token recoverFromDigest(byte[] digest) {
        return persistencia.Recuperar(digest);
    }

}
