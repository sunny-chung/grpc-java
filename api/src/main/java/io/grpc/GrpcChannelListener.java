package io.grpc;

import javax.net.ssl.SSLSession;
import java.net.SocketAddress;
import java.util.List;

/**
 * Only implemented for Netty client channels.
 */
public interface GrpcChannelListener {

    void onDnsStartResolve(String host);
    void onDnsResolved(List<SocketAddress> addresses);
    void onChannelActive();
    void onChannelInactive();

    void onTlsHandshakeComplete(SSLSession session, String applicationProtocol);

}
