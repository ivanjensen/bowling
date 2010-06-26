
class Game {
	
	def frameScore = 0
	def knownScore = 0
	def firstRoll = true
	def spare = false
	def strike = false
	
	def score() {
		knownScore
	}
	
	def roll(int pins) {
		if (pins < 0 || pins > 10) throw new InvalidRollException()
		if (frameScore + pins > 10) throw new InvalidRollException()
		
		frameScore += pins
		knownScore += pins
		
		if (firstRoll) {
			if (pins == 10) {
				strike = true
			} else  {
				firstRoll = false
				if (spare) {
					knownScore += pins
					spare = false
				}
			}
		} else {
			if (frameScore == 10) {
				spare = true
			}
			if (strike) {
				knownScore += frameScore
				strike = false
			}
			frameScore = 0
			firstRoll = true
		}
	}
}
