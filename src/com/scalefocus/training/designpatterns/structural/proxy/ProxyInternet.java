package com.scalefocus.training.designpatterns.structural.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristiyan SLavov
 */
public class ProxyInternet implements Internet{

    private Internet internet = new RealInternet();

    private static List<String> bannedSites;

    // Restricted sites
    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("qwe.com");
        bannedSites.add("rty.com");
        bannedSites.add("uio.com");
    }

    /**
     * This method checks the host, if it is not part of restricted site list,
     * then it connects.
     *
     * @param serverHost - the host you are trying to connect
     * @throws Exception - if serverhost is part of restricted sites
     */
    @Override
    public void connectTo(String serverHost) throws Exception{
        if(bannedSites.contains(serverHost.toLowerCase())) {
            throw new Exception("Access Denied!");
        }
        internet.connectTo(serverHost);
    }
}
