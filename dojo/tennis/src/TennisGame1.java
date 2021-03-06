public class TennisGame1 implements WinningPoint {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame1(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore;
        if (playerOneScore==playerTwoScore)
        {
            switch (playerOneScore)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;
            }
        }
        else if (playerOneScore>=4 || playerTwoScore>=4)
        {
            int scoreDifference = playerOneScore-playerTwoScore;
            if (scoreDifference==1) score ="Advantage player1";
            else if (scoreDifference ==-1) score ="Advantage player2";
            else if (scoreDifference>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = playerOneScore;
                else { score+="-"; tempScore = playerTwoScore;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}