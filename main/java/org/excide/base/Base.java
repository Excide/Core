package org.excide.base;

import org.excide.base.commands.*;
import org.excide.base.listeners.FlyListener;
import org.excide.base.listeners.MuteChatListener;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.base
 * Time: 2017-01-22
 */
public class Base
{

    public Base()
    {

        new ClearChatCommand();
        new MuteChatCommand();
        new ServerUptimeCommand();
        new RulesCommand();
        new FlyCommand();

        new MuteChatListener();
        new FlyListener();

    }

}
