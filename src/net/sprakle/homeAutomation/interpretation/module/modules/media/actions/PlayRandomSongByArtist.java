package net.sprakle.homeAutomation.interpretation.module.modules.media.actions;

import java.util.ArrayList;

import net.sprakle.homeAutomation.externalSoftware.software.media.MediaCentre;
import net.sprakle.homeAutomation.interpretation.Phrase;
import net.sprakle.homeAutomation.interpretation.module.modules.media.MediaAction;
import net.sprakle.homeAutomation.interpretation.tagger.PhraseOutline;
import net.sprakle.homeAutomation.interpretation.tagger.tags.Tag;
import net.sprakle.homeAutomation.interpretation.tagger.tags.TagType;
import net.sprakle.homeAutomation.utilities.logger.Logger;

public class PlayRandomSongByArtist extends MediaAction {

	public PlayRandomSongByArtist(Logger logger, MediaCentre mc) {
		super(logger, mc);
	}

	@Override
	protected ArrayList<PhraseOutline> makePhraseOutlines() {

		ArrayList<PhraseOutline> outlines = new ArrayList<>();

		// play random song by artist
		PhraseOutline poA = new PhraseOutline(getName() + " (S)");
		poA.addMandatoryTag(new Tag(TagType.PLAYBACK, "play"));
		poA.addMandatoryTag(new Tag(TagType.LANGUAGE, "something"));
		poA.addMandatoryTag(new Tag(TagType.LANGUAGE, "owned"));
		poA.addMandatoryTag(new Tag(TagType.UNKOWN_TEXT, null));

		// play random song by artist
		PhraseOutline poB = new PhraseOutline(getName() + " (T)");
		poB.addMandatoryTag(new Tag(TagType.PLAYBACK, "play"));
		poB.addMandatoryTag(new Tag(TagType.MEDIA, "track"));
		poB.addMandatoryTag(new Tag(TagType.LANGUAGE, "owned"));
		poB.addMandatoryTag(new Tag(TagType.UNKOWN_TEXT, null));

		outlines.add(poA);
		outlines.add(poB);

		return outlines;
	}

	@Override
	public void doExecute(Phrase phrase) {
		Tag[] sequenceRequest = new Tag[2];
		sequenceRequest[0] = new Tag(TagType.LANGUAGE, "owned");
		sequenceRequest[1] = new Tag(TagType.UNKOWN_TEXT, null);

		Tag[] sequence = phrase.getTagSequence(sequenceRequest);

		Tag artistTag = sequence[1];
		String artist = artistTag.getValue();

		mc.playRandomTrack(artist);
	}

	@Override
    protected String getName() {
		return "Play random song by specific artist";
	}

}
