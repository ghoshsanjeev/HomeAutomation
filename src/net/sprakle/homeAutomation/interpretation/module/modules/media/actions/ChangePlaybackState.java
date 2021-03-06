package net.sprakle.homeAutomation.interpretation.module.modules.media.actions;

import java.util.ArrayList;

import net.sprakle.homeAutomation.externalSoftware.software.media.MediaCentre;
import net.sprakle.homeAutomation.externalSoftware.software.media.supporting.PlaybackCommand;
import net.sprakle.homeAutomation.interpretation.Phrase;
import net.sprakle.homeAutomation.interpretation.module.modules.media.MediaAction;
import net.sprakle.homeAutomation.interpretation.tagger.PhraseOutline;
import net.sprakle.homeAutomation.interpretation.tagger.tags.Tag;
import net.sprakle.homeAutomation.interpretation.tagger.tags.TagType;
import net.sprakle.homeAutomation.utilities.logger.LogSource;
import net.sprakle.homeAutomation.utilities.logger.Logger;

public class ChangePlaybackState extends MediaAction {

	public ChangePlaybackState(Logger logger, MediaCentre mc) {
		super(logger, mc);
	}

	@Override
	protected ArrayList<PhraseOutline> makePhraseOutlines() {

		ArrayList<PhraseOutline> outlines = new ArrayList<>();

		PhraseOutline poA = new PhraseOutline(getName());
		poA.addMandatoryTag(new Tag(TagType.PLAYBACK, null));
		poA.addMandatoryTag(new Tag(TagType.MEDIA, null));

		outlines.add(poA);

		return outlines;
	}

	@Override
	public void doExecute(Phrase phrase) {
		Tag commandTag = phrase.getTag(new Tag(TagType.PLAYBACK, null));
		String commandString = commandTag.getValue();

		PlaybackCommand command = null;
		switch (commandString) {
			case "play":
				command = PlaybackCommand.PLAY;
				break;

			case "pause":
				command = PlaybackCommand.PAUSE;
				break;

			default:
				logger.log("Unable to choose playback command from phrase", LogSource.ERROR, LogSource.EXTERNAL_SOFTWARE, 1);
				break;
		}

		mc.playbackCommand(command);
	}

	@Override
    protected String getName() {
		return "Change playback state";
	}

}
