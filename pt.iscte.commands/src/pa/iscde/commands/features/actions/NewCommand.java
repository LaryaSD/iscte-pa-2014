package pa.iscde.commands.features.actions;

import pa.iscde.commands.features.comments.CommentFeature;
import pa.iscde.commands.internal.services.Action;
import pa.iscde.commands.models.CommandDataDecorator;
import pa.iscde.commands.models.CommandDefinition;
import pa.iscde.commands.models.CommandKey;

public class NewCommand implements Action {

	@Override
	public void action(CommandDataDecorator data) {
		
		//� necess�rio pensar como atribuir a key e o contexto (deve aparecer pop-ups a pedir a informa��o..)
		
		CommandKey cmdKey = new CommandKey("comando teste", "pa.iscde.commands.CommandsView", true, false, 'X');
		CommandDefinition cmdDef = new CommandDefinition(cmdKey, "pa.iscde.commands.CommandsView", 
				new CommentFeature(), "novo comando por via din�mica");
		
		
		data.insertCommandLine(cmdDef);

	}

}
