
class GameTest extends GroovyTestCase {
	
	def Game g = new Game()
	
	private rollMany(n, pins) {
		(1..n).each {
			g.roll pins
		}
	}
	
	void testGutterBallGame() {
		rollMany 20, 0
		assertEquals 0, g.score()
	}
	
	void testAllOnes() {
		rollMany 20, 1
		assertEquals 20, g.score()
	}
	
	void testOneSpare() {
		rollSpare()
		g.roll 3
		rollMany 17, 0
		assertEquals 16, g.score()
	}
	
	void testOneStrike() {
		rollStrike()
		g.roll 3
		g.roll 4
		rollMany 16, 0
		assertEquals 24, g.score()		
	}
	
	void testPerfectGame() {
		rollMany 12, 10
		assertEquals 300, g.score()
	}
	
	private rollSpare() {
		g.roll 5
		g.roll 5		
	}

	private rollStrike() {
		g.roll 10
	}
	
}