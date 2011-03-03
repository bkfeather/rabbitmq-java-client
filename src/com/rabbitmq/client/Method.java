//  The contents of this file are subject to the Mozilla Public License
//  Version 1.1 (the "License"); you may not use this file except in
//  compliance with the License. You may obtain a copy of the License
//  at http://www.mozilla.org/MPL/
//
//  Software distributed under the License is distributed on an "AS IS"
//  basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
//  the License for the specific language governing rights and
//  limitations under the License.
//
//  The Original Code is RabbitMQ.
//
//  The Initial Developer of the Original Code is VMware, Inc.
//  Copyright (c) 2007-2011 VMware, Inc.  All rights reserved.
//


package com.rabbitmq.client;

import java.io.IOException;

/**
 * Public interface to objects representing an AMQP method - see the <a href="http://www.amqp.org/">spec</a> for details.
 */

public interface Method {
    /**
     * Retrieve the protocol class ID
     * @return the AMQP protocol class ID of this Method
     */
    int protocolClassId(); /* properly an unsigned short */

    /**
     * Retrieve the protocol method ID
     * @return the AMQP protocol method ID of this Method
     */
    int protocolMethodId(); /* properly an unsigned short */

    /**
     * Retrieve the method name
     * @return the AMQP protocol method name of this Method
     */
    String protocolMethodName();

    /**
     * Synchronously send this Method over the specified channel.
     *
     * @param channel Channel over which to transmit method.
     * @return Response to method.  Caller should cast as appropriate.
     *
     * @throws IOException Problem transmitting method.
     */
    public Method rpc(Channel channel)
           throws IOException;

    /**
     * Asynchronously send this method over the specified channel.
     *
     * @param channel Channel over which to transmit method.
     *
     * @throws IOException Problem transmitting method.
     */
    public void asyncRpc(Channel channel)
                throws IOException;
}
