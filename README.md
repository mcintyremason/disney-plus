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

## Run Tests
1. MakeChange
	- `cd MakeChange`
	- `gradle cleanTest test --info`
2. EndOfZWorld
	- `cd EndOfZWorld`
	- `gradle cleanTest test --info`

### Path to source
- `MakeChange/src/main/java/App.java`
- `EndOfZWorld/src/main/java/App.java`