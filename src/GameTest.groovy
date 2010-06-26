
class GameTest extends GroovyTestCase {
	def g = new Game()		
	
	public void testNewGameNoScore() {
		assertEquals(0, g.score())
	}
	
	public void testFirstFrame() {
		g.roll(0)
		assertEquals 0, g.score()
		g.roll(1)
		assertEquals 1, g.score()
	}
	
	public void testTwoFrames() {
		[8, 1, 5].each { g.roll it }
		assertEquals 14, g.score()
		//g.roll(1)
		//assertEquals 15, g.score()
	}
	
	
	void testSpare() {
		[9, 1, 5].each { g.roll it }
		assertEquals 20, g.score()
	}

	void testStrike() {
		[10, 5, 2].each { g.roll it }
		assertEquals 31, g.score()
	}
	
	
	public void testFirstFrameScore_noOverlimit() {
		g.roll(5)
		assertInvalidRoll "Cannot knock down more than 10 pins per frame", {g.roll(6)}
	}
	
	
	public void testInvalidRoll_negative() {
		assertInvalidRoll "Should not be able to knock than 0 pins", {g.roll(-1)}
	}
	
	public void testInvalidRoll_overLimit() {
		assertInvalidRoll "Should not be able to knock down more than 10 pins", {g.roll(11)}
	}
	
	def assertInvalidRoll(msg, block) {
		try {
			block()
			fail(msg)
		} catch (InvalidRollException expected) {
			// expected
		}
	}
}