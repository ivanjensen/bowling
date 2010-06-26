
class Game {
	
	def rolls = new int[21]
	def currentRoll = 0
	
	def roll(pins) {
		rolls[currentRoll++] = pins
	}
	
	def score() {
		def score = 0
		def frameIndex = 0
		for (def frame = 0; frame < 10; frame++) {
			if (isStrike(frameIndex)) {
				score += 10 + strikeBonus(frameIndex)
				frameIndex++
			} else if (isSpare(frameIndex)) { 
				score += 10 + spareBonus(frameIndex)
				frameIndex += 2
			} else {
				score += sumOfBallsInFrame(frameIndex)
				frameIndex += 2
			}
		}
		score
	}
	
	def sumOfBallsInFrame(frameIndex) {
		rolls[frameIndex] + rolls[frameIndex+1]
	}
	
	def strikeBonus(frameIndex) {
		rolls[frameIndex + 1] + rolls[frameIndex + 2]
	}
	
	def spareBonus(frameIndex) {
		rolls[frameIndex+2]
	}
	
	def isSpare(frameIndex) {
		rolls[frameIndex] + rolls[frameIndex+1] == 10
	}
	
	def isStrike(frameIndex) {
		rolls[frameIndex] == 10
	}
}
