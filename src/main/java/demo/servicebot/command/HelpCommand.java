package demo.servicebot.command;

import demo.servicebot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import static demo.servicebot.command.CommandName.*;


public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨<b>Commands</b>✨\n\n"

                    + "<b>Start\\finish working with bot</b>\n"
                    + "%s - start\n"
                    + "%s - stop\n\n",
            START.getCommandName(), STOP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}