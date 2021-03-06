package net.sprakle.homeAutomation.interaction.objectDatabase.componentTree.components;

import net.sprakle.homeAutomation.interaction.objectDatabase.ComponentType;
import net.sprakle.homeAutomation.interaction.objectDatabase.NodeType;
import net.sprakle.homeAutomation.interaction.objectDatabase.componentTree.Component;
import net.sprakle.homeAutomation.utilities.logger.LogSource;
import net.sprakle.homeAutomation.utilities.logger.Logger;

public class DB_Object extends Component {

	// all DB_Objects must define a default node for Binary, Integer, and String commands
    private DB_Node defaultNodeBin;
	private DB_Node defaultNodeInt;
	private DB_Node defaultNodeStr;
	private DB_Node defaultDefault;

	public DB_Object(Logger logger, Component parent, String identifier) {
		super(logger, parent, identifier);

		this.componentType = ComponentType.DB_OBJECT;
	}

	public void setDefaultNode(NodeType nodeType, DB_Node node) {
		String error = "DefaultNode already set for object '" + this.identifier;

		switch (nodeType) {
			case BINARY:
				if (defaultNodeBin == null)
					defaultNodeBin = node;
				else
					logger.log(error, LogSource.ERROR, LogSource.OD_COMPONENT_INFO, 1);
				break;

			case INTEGER:
				if (defaultNodeInt == null)
					defaultNodeInt = node;
				else
					logger.log(error, LogSource.ERROR, LogSource.OD_COMPONENT_INFO, 1);
				break;

			case STRING:
				if (defaultNodeStr == null)
					defaultNodeStr = node;
				else
					logger.log(error, LogSource.ERROR, LogSource.OD_COMPONENT_INFO, 1);
				break;

			case DEFAULT:
				if (defaultDefault == null) {
					defaultDefault = node;
				} else {
					logger.log(error, LogSource.ERROR, LogSource.OD_COMPONENT_INFO, 1);
				}
				break;
		}
	}

	public DB_Node getDefaultNode(NodeType nodeType) {
		DB_Node targetDefaultNode = null;
		switch (nodeType) {
			case BINARY:
				targetDefaultNode = defaultNodeBin;
				break;

			case INTEGER:
				targetDefaultNode = defaultNodeInt;
				break;

			case STRING:
				targetDefaultNode = defaultNodeStr;
				break;

			case DEFAULT:
				targetDefaultNode = defaultDefault;
				break;
		}

		return targetDefaultNode;
	}

}
