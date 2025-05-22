# Role-Playing Simulator - Term Project for UBC CPSC 210

[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/eqVeIVxqCJo/0.jpg)](https://www.youtube.com/watch?v=eqVeIVxqCJo)

## Proposal

### What will this application do?

This application provides a graphical user interface (GUI) that feature an interactive character creation screen with
visual elements for selecting **name, sex, class (Knight, Barbarian, Ranger...).**
Players can also train their characters inside school and earn **special abilities, as well as experience points.**

### Who will use this application?

Players use this application to build a character and train their characters to become stronger.

### Why is this project of interest to me?

I have played a lot of role-playing games in my childhood and enjoy character creation and customization. Designing one
helps me bring back childhood memories and allows me to unleash my creativity, also developing skills in user interface
development.

## User Stories

- As a player, I want to be able to create a new character or select an old character I created.

- As a player, I want to be able to create a character and add it to my list of characters created before, specifying
  their name, gender, and classes (e.g. Barbarians, Knights, Rangers).

- As a player, I want to be able to view the list of all of my character created.

- As a player, I want to be able to remove a created character from my list of characters created.

- As a player, I want to be able to view my character's health, attack power and defense power based on their classes.

- As a player, I want to be able to participate in training sessions to improve my character's skills and earn
  experience points, enabling character progression and development.

- As a player, I want to be able to train my character to acquire special abilities for each class.

- As a player, I want to be able to monitor my character's progression, including tracking experience points. upgrading
  them, and unlocked abilities.

- As a player, I want to be able to save my character list I just created into a file.

- As a player, I want to be given an option to load my character list from a file.


## Instructions for Grader

- You can generate the first required action related to the user story "adding multiple Xs to a Y" by clicking SELECT
CHARACTER button after clicking New Builder, this can select individual characters and look at their statistics.

- You can generate the second required action related to the user story "adding multiple Xs to a Y" by clicking REMOVE
CHARACTER button after clicking New Builder, this can remove a character from the Characterlog.

- You can locate my visual component by looking around the background, buttons, and photo in some of the windows.

- You can save the state of my application by clicking Save Builder button.

- You can reload the state of my application by Load Builder button.

## Phase 4: Task 2

Mon Apr 01 19:46:56 PDT 2024
Character Jake the Barbarian has been added!

Mon Apr 01 19:47:01 PDT 2024
Character Sally the Ranger has been added!

Mon Apr 01 19:47:07 PDT 2024
Character Henry the Knight has been added!

Mon Apr 01 19:47:10 PDT 2024
Character Jake the Barbarian has been selected and statistics has been retrieved.

Mon Apr 01 19:47:13 PDT 2024
Character Sally the Ranger has been selected and statistics has been retrieved.

Mon Apr 01 19:47:16 PDT 2024
Character Henry the Knight has been selected and statistics has been retrieved.

Mon Apr 01 19:47:20 PDT 2024
Character Henry the Knight has been removed.

## Phase 4: Task 3

- During an in-depth refactoring initiative targeting the Swing package, I've consistently discovered significant amounts 
of redundant code within classes, such as the setting background and buttons operations. To enhance maintainability and 
readability, I believe there's a substantial opportunity to refactor these duplicated code sections and introduce well-defined 
constants, which would abstract away literal values and make the code's intent clearer.

- Redundant coupling within the NewCharacterWindow and Classes classes suggests a strong need for refactoring; this could 
involve applying design patterns or dependency injection techniques to better decouple their functionalities.
