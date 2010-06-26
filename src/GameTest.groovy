
class GameTest extends GroovyTestCase {
	
	Game game = new Game()
	
	def rollMany(n, pins) {
		(1..n).each { 
			game.roll(pins)
		}
	}
	
	void testGutterBallGame() {
		rollMany(20, 0)
		assertEquals 0, game.score()
	}
	
	void testAllOnes() {
		rollMany(20, 1)
		assertEquals 20, game.score()
	}
	
	void testOneSpare() {
		rollSpare()
		game.roll(3)
		rollMany(17, 0)
		assertEquals 16, game.score()
	}
	
	void testOneStrike() {
		rollStrike()
		game.roll 3
		game.roll 4
		rollMany 16, 0
		assertEquals 24, game.score()
	}
	
	void testPerfectGame() {
		rollMany(12, 10)
		assertEquals(300, game.score())
	}
	
	def rollSpare() {
		game.roll(5)
		game.roll(5)
	}

	def rollStrike() {
		game.roll(10)
	}
}