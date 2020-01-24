# Disney+

## Install Dependencies
- `brew install gradle`

## Compile & Run
1. MakeChange
	- `cd MakeChange`
	- `gradle run`
2. EndOfZWorld
	- `cd EndOfZWorld`
	- `gradle run --args='"Quarter,4,Dime,10,Nickel,20,Penny,100"'`
	- `gradle run --args='"Coin,1.5,Arrowhead,3,Button,150"'`

## Test
1. MakeChange
	- `cd MakeChange`
	- `gradle test`
2. EndOfZWorld
	- `cd EndOfZWorld`
	- `gradle test`

### Path to source
- `MakeChange/src/main/java/App.java`
- `EndOfZWorld/src/main/java/App.java`