#Libraries
import random

#Instance Variables
computer_score = 0
player_score = 0

#Methods
def player_choice():
    player_choice = input("Choose Rock (r), Paper(p) or Scissors(s): ")
    if player_choice in [ "r"]:
        player_choice = "r"
    elif player_choice in ["p"]:
        player_choice = "p"
    elif player_choice in [ "s"]:
        player_choice = "s"
    else:
        print("Invalid Entry; please try again")
    return player_choice

def computer_choice():
    computer_choice = random.randint(1, 3)
    if computer_choice == 1:
        computer_choice = "r"
    elif computer_choice == 2:
        computer_choice = "p"
    else:
        computer_choice = "s"
    return computer_choice

def main():  
    global computer_score
    global player_score
    
    print("---Welcome to the RPS Game---")
    
    while True:
        stored_player_input = player_choice()
        print("you chose",stored_player_input)
        stored_computer_input = computer_choice()
        print("computer chose",stored_computer_input)
        
        #Control Structure aka Decision Making Logic
        # and condition means bad user input doesnt count towards score
        if stored_player_input == "r" and stored_computer_input == "r": 
            print("You both tied")
        
        elif stored_player_input == "r" and stored_computer_input == "p":
            print("You lose; computer wins")
            computer_score = computer_score + 1
            
        elif stored_player_input == "r" and stored_computer_input == "s":
            print("You win; computer loses")
            player_score = player_score + 1

        elif stored_player_input == "p" and stored_computer_input == "r":
            print("You win; computer loses")
            player_score = player_score + 1
        
        elif stored_player_input == "p" and stored_computer_input == "p":
            print("You both tied")
            
            
        elif stored_player_input == "p" and stored_computer_input == "s":
            print("You lose; computer wins")
            computer_score = computer_score + 1

        elif stored_player_input == "s" and stored_computer_input == "r":
            print("You lose; computer wins")
            computer_score = computer_score + 1
        
        elif stored_player_input == "s" and stored_computer_input == "p":
            print("You win' computer loses")
            player_score = player_score + 1
            
        elif stored_player_input == "s" and stored_computer_input == "s":
            print("You both tied")

        print("\n---RPS Game Score Checker---")
        print("Player won",str(player_score),"times")
        print("Computer won",str(computer_score),"times")
        print("")
    
        stored_player_input = input("Do you want to play again? (y/n): ")
                
        if stored_player_input in ["y"]:
           pass # placeholder; start from the top of the while loop
        elif stored_player_input in ["n"]:
            break #breaks out of the main method

main() #main method call

#executes after the  main method (announces the winner)
if(player_score > computer_score):
    print("You are the final winner")
elif (player_score < computer_score):
    print("Computer was the final winner")
elif (player_score == computer_score):
    print("There is no winner; you both tied")

print("\n---Thank you for playing the RPS Game---")









