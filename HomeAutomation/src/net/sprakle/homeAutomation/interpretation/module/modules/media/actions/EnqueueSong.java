package net.sprakle.homeAutomation.interpretation.module.modules.media.actions;

import java.util.ArrayList;

import net.sprakle.homeAutomation.interpretation.Phrase;
import net.sprakle.homeAutomation.interpretation.module.modules.media.MediaAction;
import net.sprakle.homeAutomation.interpretation.tagger.PhraseOutline;
import net.sprakle.homeAutomation.interpretation.tagger.Tagger;
import net.sprakle.homeAutomation.interpretation.tagger.tags.Tag;
import net.sprakle.homeAutomation.interpretation.tagger.tags.TagType;
import net.sprakle.homeAutomation.utilities.externalSoftware.software.media.MediaCentre;
import net.sprakle.homeAutomation.utilities.logger.Logger;

public class EnqueueSong extends MediaAction {

	public EnqueueSong(Logger logger, MediaCentre mc, Tagger tagger) {
		super(logger, mc, tagger);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ArrayList<PhraseOutline> makePhraseOutlines() {

		ArrayList<PhraseOutline> outlines = new ArrayList<PhraseOutline>();

		PhraseOutline poA = new PhraseOutline(logger, tagger, getName());
		poA.addTag(new Tag(TagType.PLAYBACK, "play", null, -1));
		poA.addTag(new Tag(TagType.UNKOWN_TEXT, null, null, -1));
		poA.addTag(new Tag(TagType.TIME_CHANGE, "next", null, -1));

		outlines.add(poA);

		return outlines;
	}

	@Override
	public void doExecute(Phrase phrase) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Enqueue song";
	}

}
