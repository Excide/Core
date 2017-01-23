package org.excide.base;

import org.excide.base.commands.ClearChatCommand;
import org.excide.base.commands.MuteChatCommand;
import org.excide.base.commands.RulesCommand;
import org.excide.base.commands.ServerUptimeCommand;
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

        new MuteChatListener();

    }

}
