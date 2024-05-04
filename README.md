# Magical Arena

## How to Run
To run the game, compile the `MagicalArena.java` file and then run the `MagicalArena` class.

javac MagicalArena.java
java MagicalArena


## Overview
Welcome to the Magical Arena! This is a simple console-based game where two players battle each other.

## Problem Statement
Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute, and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0. Any two players can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice and the defending player rolls the defending dice. The “attack” value multiplied by the outcome of the attacking dice roll is the damage created by the attacker. The defender “strength” value, multiplied by the outcome of the defending dice is the damage defended by the defender. Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender. Game ends when any player's health reaches 0.

Player with lower health attacks first at the start of a match.

Assume two players. Player A: 50 health, 5 strength, 10 attack. Player B: 100 health, 10 strength, and 5 attack. Attacking die and Defending die are both 6-sided die with values ranging from 1-6.

## Rules of the Game
- You can use Java, Go, or Node.js to implement the solution, without using any third-party libraries or frameworks.
- The code should NOT be hosted on GitHub or made public. Create a zip of the folder with local git history and provide us with the zip.
- You should provide a README file in the repository that explains how to run the code and any other relevant information.
- You should provide unit tests for your solution.
- We expect you to commit frequently with relevant commit messages. Multiple incremental commits are valued over one all-inclusive commit.

## Implementation Details
- Implemented in Java.
- Consists of two classes: `Player` and `MagicalArena`.
- `Player` class represents a player in the arena with attributes such as name, health, strength, and attack.
- `MagicalArena` class orchestrates the battle between two players.
- `rollDie()` method in the `Player` class simulates rolling a die with values ranging from 1 to 6.
- The battle is simulated by attacking and defending turns, with damage calculation as per the problem statement.
- The battle continues until one player's health reaches 0.