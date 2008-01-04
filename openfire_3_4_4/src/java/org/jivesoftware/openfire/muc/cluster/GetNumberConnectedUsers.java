/**
 * $RCSfile$
 * $Revision: $
 * $Date: $
 *
 * Copyright (C) 2007 Jive Software. All rights reserved.
 *
 * This software is published under the terms of the GNU Public License (GPL),
 * a copy of which is included in this distribution.
 */

package org.jivesoftware.openfire.muc.cluster;

import org.jivesoftware.openfire.XMPPServer;
import org.jivesoftware.openfire.muc.spi.MultiUserChatServerImpl;
import org.jivesoftware.util.cache.ClusterTask;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Task to be executed in each cluster node to obtain the total number of
 * users using the multi user chat service.
 *
 * @author Gaston Dombiak
 */
public class GetNumberConnectedUsers implements ClusterTask{
    private Integer count;

    public Object getResult() {
        return count;
    }

    public void run() {
        MultiUserChatServerImpl mucServer = (MultiUserChatServerImpl) XMPPServer.getInstance().getMultiUserChatServer();
        count = mucServer.getNumberConnectedUsers(true);
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        // Do nothing
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Do nothing
    }
}
