## Super Sports Predictor (SSP)

A Java-based sports outcome prediction engine developed for **CS 2114 (Software Design & Data Structures)**.  
The system evaluates team records, offensive/defensive metrics, momentum, and fatigue to generate matchup forecasts with calibrated confidence levels.

---

## Contributors & Authors
**Andrew Park** (andrewp04)
**Robert Laing** (rlaing4308)
**Joshua Essandoh** (jessandoh7)

---

## Project Overview
Super Sports Predictor (SSP) models sports teams using standardized metrics (Wins, Losses, Ties, Offensive/Defensive ratings, Streaks, Fatigue) and predicts the winner of a matchup using a weighted prediction algorithm.

### Key Components:
1. **`Team.java`**: Domain model encapsulating team statistics, mutual streak exclusivity, and win rate calculation (including ties as 0.5 wins).
2. **`PredictionEngine.java`**: Core algorithmic component evaluating:
   - **Pythagorean Expectation (50%)**: Derived from offensive vs. defensive rating shares.
   - **Win Rate Share (35%)**: Relative winning percentages including tie weights.
   - **Momentum Share (15%)**: Real-time momentum calculated from win streaks, loss streaks, and accumulated fatigue.
   - **Random Game-Day Variance**: Simulates unpredictable game factors (-5% to +5%).
3. **`PredictionResults.java`**: Formats the predicted winner, numeric confidence (50.0% – 100.0%), and qualitative summary (blowout, clear advantage, or slight upper hand).
4. **`SSPGame.java`**: Interactive console (CLI) runner with real-time input validation and user-friendly error retry loops.

---

## How to Run the Application

### 1. Running the CLI Interface
1. In Eclipse, navigate to `(default package) -> SSPGame.java`.
2. Right-click `SSPGame.java` -> **`Run As` -> `Java Application`**.
3. Follow the console prompts to input statistics for **Team 1** and **Team 2**.

### 2. Running Unit Tests
All business logic and edge cases are validated via JUnit (`student.TestCase`):
* `TeamTest.java`: Validates getters/setters, streak constraints, ties calculation, and boundary edge cases.
* `PredictionEngineTest.java`: Tests deterministic engine predictions using a seeded `Random`, zero-division edge cases, and duplicate team validations.
* `PredictionResultsTest.java`: Tests result formatting, boundary confidence bounds, and summary outputs.

**To Run**:
* Right-click any test file (or the test suite) -> **`Run As` -> `JUnit Test`**.

---

## Input Validation & Business Rules
* **Name**: Cannot be `null`, empty, or whitespace-only.
* **Record (Wins, Losses, Ties)**: Non-negative integers.
* **Ratings (Offensive & Defensive)**: Range `[0.0, 99.0]`.
* **Streak Exclusivity**:
  * Win streak cannot exceed total wins.
  * Loss streak cannot exceed total losses.
  * A team cannot simultaneously hold both an active win streak and loss streak.
* **Matchups**: Competing teams cannot be identical or share the same team name.

---

## Sample Run

```text
========================================
 Welcome to Super Sports Predictor (SSP) 
========================================

--- Enter Details for Team 1 ---
Team Name: Hokies
Wins: 10
Losses: 2
Ties: 0
Offensive Rating (0.0 - 99.0): 88.0
Defensive Rating (0.0 - 99.0): 75.0
Win Streak: 4
Loss Streak: 0
Fatigue (>= 0.0): 2.0

--- Enter Details for Team 2 ---
Team Name: Cavaliers
Wins: 4
Losses: 8
Ties: 0
Offensive Rating (0.0 - 99.0): 65.0
Defensive Rating (0.0 - 99.0): 78.0
Win Streak: 0
Loss Streak: 3
Fatigue (>= 0.0): 8.0

Evaluating matchup...

========================================
           PREDICTION RESULTS           
========================================
Matchup: Hokies vs Cavaliers
Predicted Winner: Hokies
Summary: Hokies has a clear advantage. Confidence: 69%.
========================================