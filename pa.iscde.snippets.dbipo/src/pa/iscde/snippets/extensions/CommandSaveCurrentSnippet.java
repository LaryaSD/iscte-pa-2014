package pa.iscde.snippets.extensions;

import pa.iscde.commands.internal.services.Command;
import pa.iscde.snippets.gui.SnippetsView;

public class CommandSaveCurrentSnippet implements Command{

	@Override
	public void action() {
		SnippetsView.getInstance().savedSnippetCommand();
	}

}
