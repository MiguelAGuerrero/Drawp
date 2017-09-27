package testdrawp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import drawp.ParticleBrush;
import drawp.CompositeParticleBrush;

public class TestParticleBrushGroup {

	CompositeParticleBrush testCBG;
	ParticleBrush testParticleBrushes;
	
	@Before
	public void setUp() throws Exception
	{
		CompositeParticleBrush testCBG = new CompositeParticleBrush();
		int arbitrary = 3;
		for(int i = 0; i < arbitrary; i++)
		{
			testCBG.addBrush(new ParticleBrush());
		}
	}

	@Test
	public void testWhetherComposingBrushesMoveWithFocusBrush()
	{
		for(ParticleBrush pb: testCBG)
		{
		}
	}

}
