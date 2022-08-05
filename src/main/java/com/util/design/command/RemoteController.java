package com.util.design.command;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class RemoteController {

    Command[] onCommand;
    Command[] offCommand;

    public RemoteController() {
        onCommand = new Command[5];
        offCommand = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommand[i] = new NoCommand();
            offCommand[i] = new NoCommand();
        }
    }

    public void setCommand(int no, Command onCommand, Command offCommand){
        this.onCommand[no] = onCommand;
        this.offCommand[no] = offCommand;
    }

    public void onButton(int no){
        onCommand[no].execute();
    }

    public void offButton(int no){
        offCommand[no].execute();
    }
}
