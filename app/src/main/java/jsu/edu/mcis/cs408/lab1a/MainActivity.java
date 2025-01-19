package jsu.edu.mcis.cs408.lab1a;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import jsu.edu.mcis.cs408.lab1a.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    private Weapon playerWeapon, computerWeapon;
    private int playerScore, computerScore;
    private TextView score, player_weapon_text, computer_weapon_text, winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        score = binding.score;
        player_weapon_text = binding.playerWeaponText;
        computer_weapon_text = binding.computerWeaponText;
        winner = binding.winner;
        View view = binding.getRoot();
        setContentView(view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart() invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop() invoked");
    }

    private String CheckWin() {
        StringBuilder winMessage = new StringBuilder();

        if (playerWeapon.equals(computerWeapon)) {
            winMessage.append("Draw!");
        }
        else if ((playerWeapon == Weapon.ROCK && computerWeapon == Weapon.SCISSORS)
                || (playerWeapon == Weapon.PAPER && computerWeapon == Weapon.ROCK)
                || (playerWeapon == Weapon.SCISSORS && computerWeapon == Weapon.PAPER)) {
            playerScore += 1;
            winMessage.append("Players wins: ").append(playerWeapon);
            if (playerWeapon == Weapon.SCISSORS) {
                winMessage.append(" cuts ");
            } else {
                winMessage.append(" beats ");
            }

            winMessage.append(computerWeapon);

        } else {
            computerScore += 1;

            winMessage.append("Computer wins: ").append(computerWeapon);
            if (computerWeapon == Weapon.SCISSORS) {
                winMessage.append(" cuts ");
            } else {
                winMessage.append(" beats ");
            }

            winMessage.append(playerWeapon);
        }

        score.setText(String.format(getString(R.string.score_text), playerScore, computerScore));
        return winMessage.toString();
    }

    private void updateOutput(String message) {
        StringBuilder pw = new StringBuilder();
        pw.append("Player's Weapon: ").append(playerWeapon);
        player_weapon_text.setText(pw.toString());

        StringBuilder cw = new StringBuilder();
        cw.append("Computer's Weapon: ").append(computerWeapon);

        computer_weapon_text.setText(cw.toString());

        winner.setText(message);
    }

    private void ComputerPick() {
        computerWeapon = Weapon.getRandomWeapon();
        String winMessage = CheckWin();
        updateOutput(winMessage);
    }

    public void onClickRock(View v) {
        playerWeapon = Weapon.ROCK;
        ComputerPick();
    }

    public void onClickPaper(View v) {
        playerWeapon = Weapon.PAPER;
        ComputerPick();
    }

    public void onClickScissors(View v) {
        playerWeapon = Weapon.SCISSORS;
        ComputerPick();
    }
}