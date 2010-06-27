
class Game {
	
	def rolls = []
	def currentRoll = 0
	
	def roll(pins) {
		rolls << pins
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
				score += sumOfFrame(frameIndex)
				frameIndex += 2
			}
		}
		score
	}
	
	private sumOfFrame(frameIndex) {
		rolls[frameIndex] + rolls[frameIndex + 1]
	}
	
	private spareBonus(frameIndex) {
		rolls[frameIndex + 2]
	}
	
	private strikeBonus(frameIndex) {
		rolls[frameIndex + 1] + rolls[frameIndex + 2]
	}
	
	private isStrike(frameIndex) {
		rolls[frameIndex] == 10
	}
	
	private isSpare(frameIndex) {
		rolls[frameIndex] + rolls[frameIndex + 1] == 10
	}
	
}
